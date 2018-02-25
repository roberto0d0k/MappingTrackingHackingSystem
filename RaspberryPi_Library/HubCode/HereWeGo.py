import socket
import os
import datetime
import atexit

serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
rt = 2000
serversocket.bind(('0.0.0.0', 8066))
serversocket.listen(5) # become a server socket, maximum 5 connections

os.system("sh runProg.sh")

#Application loop
while True:
        connection, address = serversocket.accept()
        buf = connection.recv(64)
        if len(buf) > 0:
            fileIn = ''
            #Check if our input file has not been dealt with and append
            if os.path.exists("CurrentRawData"):
                fileIn = open("CurrentRawData", "a")
            else:
                fileIn = open("CurrentRawData", "w")
            print buf
            #print to screen, very useful for testing
            fileIn.write(buf)
            fileIn.close()
            connection.close()
            
serversocket.close()
