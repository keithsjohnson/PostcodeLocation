Postcode Location Demo
----------------------
This is a demonstration projection for using Spring Boot, Spring Cloud, Spring Data, AWS SQS, SNS, DynomoDB

Author
------
Keith Johnson

Details
-------
The project uses Gradle for building the application.

There are 4 subprojects:
1. Postcode Location Client (9000)
   a. Display Web Page to send Postcode Location Display (ToDo 2)
   b. Display Map of Postcode Locations Received on Websocket (ToDo 1)
   c. Upload postcodes.csv to S3 with subscription to SQS PostcodeLocationFileQueue (ToDo)
   d. Receive messages from PostcodeLocationFileQueue (ToDo)
   e. Send Postcode Location Display requests (ToDo)

2. Postcode Location Request Receiver (9001)
   a. Receives REST Postcode Requests 
   b. Sends Postcode to SQS PostcodeLocationFinderQueue
   c. Stores Requests in DynamoDB Table PostcodeLocationRequests  (ToDo) 

3. Postcode Location Finder (9002)
   a. Receives messages from PostcodeLocationFinderQueue
   b. Retrieves Postcode from DynamoDB PostcodeLocationDetails table
   c. Sends Postcode & Location (as JSON) to SQS PostcodeLocationDisplayQueue
   d. Sends Postcode to PostcodeLocationDisplayAuditQueue
   e. Store Postcode on DynamoDB PostcodeLocationDisplayAudit table (ToDo)
   f. Receives REST Postcode Location Details save Requests
   g. Stores Postcode Location Details in DynamoDB Table PostcodeLocationDetails 

4. Postcode Location Displayer (9003)
   a. Receives messages from PostcodeLocationDisplayQueue (ToDo 1)
   b. Send Postcode Location to Websocket Map for display (ToDo 1)
   
Postcode Test Data URL
----------------------
http://www.doogal.co.uk/PostcodeDownloads.php

Postcode Location URLs
----------------------
Save Data
---------
http://localhost:9002/save?postcode=SK1 3LF&latitude=53.402139&longitude=-2.152291&population=0&households=0
http://localhost:9002/save?postcode=SK4 2HD&latitude=53.407577&longitude=-2.177943&population=0&households=0
http://localhost:9002/save?postcode=ST5 4EP&latitude=52.987161&longitude=-2.233692&population=180&households=65
http://localhost:9002/save?postcode=ST7 2YB&latitude=52.987161&longitude=-2.294545&population=35&households=22

Display Postcode Location
-------------------------
http://localhost:9001/postcode?postcode=SK1 3LF
http://localhost:9001/postcode?postcode=SK4 2HD
http://localhost:9001/postcode?postcode=ST5 4EP
http://localhost:9001/postcode?postcode=ST7 2YB

