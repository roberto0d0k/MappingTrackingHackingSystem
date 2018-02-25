#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 24 08:04:35 2018

@author: ethanyoung
"""

import sqlite3
from sqlite3 import Error
import os
 
  
def create_connection(db_file):
    """ create a database connection to a SQLite database """
    try:
        conn = sqlite3.connect(db_file)
    except Error as e:
        print(e)
    return conn
                                              
def add_entry(conn, query):
    try:
        c = conn.cursor()
        c.execute(query)
    except Error as e:
        print(e)
                                                                                                      
def read_inputs(filename):
    file = open(filename, "r")
                                                                                                                  
    input = []
                                                                                                                          
    for row in file:
        input.append(row)
                                                                                                                                                  
    return input

def create_date(date):
        for i in range(0, len(date)):
            if (len(date[i]) == 1):
                date[i] = "0" + str(date[i])
        string = "'" + str(date[0]) + "-" + str(date[1]) + "-" + str(date[2]) + " " +  str(date[3]) + ":" + str(date[4]) + ":" + str(date[5]) + "'"       
        return string
while(1):
    if (not os.path.exists("./ProcessedData")):
        continue    
    row = read_inputs("ProcessedData")      
    
    #for row in uploads:
        
    conn = create_connection("./Master_Data.db")
    
    
    for j in range(0, len(row)):
        upload = row[j].split("'")
        while (len(upload) < 7):
            upload.append("'NULL'")
        
        query1 = "CREATE TABLE IF NOT EXISTS Sensors" + str(upload[5]) + " (Time DATETIME, Mobile_ID INT, Mobile_Name TEXT, AreaID INT, Area_Name TEXT, Activity_ID INT, Activity_Name TEXT);"
        add_entry(conn, query1)
        query = "INSERT INTO Sensors" + str(upload[5]) + " VALUES( " + str(create_date(upload[0].split(":"))) + " , " + str(upload[1])+ " , '" + str(upload[2])+ "' , " + str(upload[3])+ " , '" + str(upload[4])+ "' , " + str(upload[5])+ " , '" + str(upload[6]) + "' );"
        add_entry(conn, query)
        conn.commit()

    os.remove("ProcessedData")
