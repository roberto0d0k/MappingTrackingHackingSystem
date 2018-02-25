import serial
from datetime import datetime
import socket

#opens the serial port for data from an arduino 
ser = serial.Serial('/dev/ttyACM0',9600)

while True:

    #reads in data from the serial connection from the arduino
    inputData = ser.readline()
    if len(inputData) > 0:
        
        #parses the data and initializes variables
        parsedData = inputData.split(" ")
        readerID = parsedData[0]
        cardIDs = ""
        cardID = 0
        
        #gets the current data and time and stores it
        now = datetime.now()
        currDay = now.day
        currMonth = now.month
        currYear = now.year
        currSec = now.second
        currMin = now.minute
        currHour = now.hour
        
        #stores the RFID tag data
        for i in range(2,6):
            cardIDs = cardIDs + parsedData[i]
       
        #converts the hexadecimal RFID key to a decimal key
        for num in range(0,len(cardIDs)-2):
            if cardIDs[num] == (' ' or '') :
                continue
            else: 
                cardID = cardID + int(cardIDs[num],16)
        
        #stores formatted data
        date = str(currYear) + ":" + str(currMonth) + ":" + str(currDay)
        time = str(currHour) + ":" + str(currMin) + ":" + str(currSec)
        timeStamp = date + ":" + time
        
        #send the data to a rasp pi hub via wi-fi
        clientsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        clientsocket.connect(('192.168.43.74', 8066))
        clientsocket.send(("%s'%s'%s\n") % (timeStamp,readerID,cardID))
        clientsocket.close()
        
