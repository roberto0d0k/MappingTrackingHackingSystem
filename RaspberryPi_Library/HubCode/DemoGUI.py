#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 24 21:14:42 2018

@author: ethanyoung
"""

from time import sleep
import sqlite3
from sqlite3 import Error          

def create_connection(db_file):
    """ create a database connection to a SQLite database """
    try:
        conn = sqlite3.connect(db_file)
    except Error as e:
        print(e)
    return conn

def print_locations(A, B, C, D):
    Door1 = """
           ________________________________________________________________
           |  |            |   |                                          |
           |  |            |   |                                          |
           |  |            |   |                                          |
           |  |____________|   |                                          |
           |                   |                                          |
           |     """ + str(A) + """          |                                          |
           |                  |                               """ + str(C) + """          |
           |                   |                          ________________|
           |                                             |                |
           |               """ + str(D) + """                         |                |
           |                                             |                |
           |                                             |                |
           |                   |                         |________________|
           |                   |                                          |
           |                  |          """ + str(B) + """                               |
           |                   |        _______                           |
           |                   |       |       |                          |
           |                   |       |       |                          |
           |___________________|_______|_______|__________________________|"""
    
    print(Door1)

def print_key(A, vA, B, vB, C, vC, D, vD):
    print()
    string = "                              " + str(vA) + ":" + str(A) + " " + str(vB) + ":" + str(B) + " " + str(vC) + ":" + str(C) + " " + str(vD) + ":" + str(D)
    print(string)
    print()
    
def get_next_values():
    #Time DATETIME, Mobile_ID INT, Mobile_Name TEXT, AreaID INT, Area_Name TEXT, Activity_ID INT, Activity_Name TEXT
    T1 = "SELECT Mobile_ID FROM Sensors1 WHERE Time = (SELECT MAX(Time) FROM Sensors1)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(T1)
    Sensor1 = c.fetchone()
    conn.close()

    T2 = "SELECT Mobile_ID FROM Sensors2 WHERE Time = (SELECT MAX(Time) FROM Sensors2)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(T2)
    Sensor2 = c.fetchone()
    conn.close()

    T3 = "SELECT Mobile_ID FROM Sensors3 WHERE Time = (SELECT MAX(Time) FROM Sensors3)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(T3)
    Sensor3 = c.fetchone()
    conn.close()

    T4 = "SELECT Mobile_ID FROM Sensors4 WHERE Time = (SELECT MAX(Time) FROM Sensors4)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(T4)
    Sensor4 = c.fetchone()
    conn.close()

    N1 = "SELECT Mobile_Name FROM Sensors1 WHERE Time = (SELECT MAX(Time) FROM Sensors1)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(N1)
    Name1 = c.fetchone()
    conn.close()

    N2 = "SELECT Mobile_Name FROM Sensors2 WHERE Time = (SELECT MAX(Time) FROM Sensors2)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(N2)
    Name2 = c.fetchone()
    conn.close()

    N3 = "SELECT Mobile_Name FROM Sensors3 WHERE Time = (SELECT MAX(Time) FROM Sensors3)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(N3)
    Name3 = c.fetchone()
    conn.close()

    N4 = "SELECT Mobile_Name FROM Sensors4 WHERE Time = (SELECT MAX(Time) FROM Sensors4)"
    conn = create_connection("./Master_Data.db")
    c = conn.cursor()
    c.execute(N4)
    Name4 = c.fetchone()
    conn.close()
    #print(str(Sensor1) + " " + str(Sensor2) + " " + str(Sensor3) + " " + str(Sensor4)) 
    print_locations(Sensor1[0], Sensor2[0], Sensor3[0], Sensor4[0])
    print_key(Name1[0], Sensor1[0], Name2[0], Sensor2[0], Name3[0], Sensor3[0], Name4[0], Sensor4[0])
    
while(1):   
    get_next_values()
    sleep(3)
