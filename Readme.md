Postcode Location Demo
----------------------
This is a demonstration (or showcase) project for using Spring Boot, Spring Cloud, Spring Data, AWS SQS, SNS, DynomoDB

Author
------
Keith Johnson

Details
-------

There are 4 subprojects:
1. Postcode Location Client (9000)

   a. Display Web Page to send Postcode Location Display Requests (ToDo 2)
   
   b. Receives messages from PostcodeLocationDisplayQueue
   
   c. Display Map of Postcode Locations Received on Websocket
   
   d. Upload postcodes.csv to S3 with subscription to SQS PostcodeLocationFileQueue (ToDo)
   
   e. Receive messages from PostcodeLocationFileQueue
   
   f. Send Postcode Location Display requests to Map
   
   g. Package application in jar and Dockerfile for running on AWS
   
   h. Deploy Docker zip to AWS using terraform (ToDo 1)

2. Postcode Location Request Receiver (9001)

   a. Receives REST Postcode Requests 
   
   b. Sends Postcode to SQS PostcodeLocationFinderQueue
   
   c. Stores Requests in DynamoDB Table PostcodeLocationRequests  (ToDo 3) 
   
   d. Package application in jar and Dockerfile for running on AWS
   
   e. Deploy Docker zip to AWS using terraform (ToDo 1)

3. Postcode Location Finder (9002)

   a. Receives messages from PostcodeLocationFinderQueue
   
   b. Retrieves Postcode from DynamoDB PostcodeLocationDetails table
   
   c. Sends Postcode & Location (as JSON) to SQS PostcodeLocationDisplayQueue
   
   d. Sends Postcode to PostcodeLocationDisplayAuditQueue
   
   e. Store Postcode on DynamoDB PostcodeLocationDisplayAudit table (ToDo 3)
   
   f. Receives REST Postcode Location Details save Requests
   
   g. Stores Postcode Location Details in DynamoDB Table PostcodeLocationDetails 
   
   h. Package application in jar and Dockerfile for running on AWS
   
   i. Deploy Docker zip to AWS using terraform  (ToDo 1)

4. Postcode Location Displayer (9003) NO LONGER NEEDED BUT KEEP FOR NOW

   a. Receives messages from PostcodeLocationDisplayQueue (NO LONGER NEEDED BUT KEEP FOR NOW)
   
   b. Send Postcode Location to Websocket Map for display (NO LONGER NEEDED BUT KEEP FOR NOW)
   
Postcode Test Data URL
----------------------
http://www.doogal.co.uk/PostcodeDownloads.php

Postcode Location URLs
----------------------
PostcodeLocationFinder (Also Stores using the URLs)
----------------------
JVM Arguments: -Duse.profile.credentials=true -Dserver.port=9002

http://localhost:9002

http://localhost:9002/save?postcode=SK1%203LF&latitude=53.402139&longitude=-2.152291&population=0&households=0

http://localhost:9002/save?postcode=SK4%202HD&latitude=53.407577&longitude=-2.177943&population=0&households=0

http://localhost:9002/save?postcode=ST5%204EP&latitude=52.987161&longitude=-2.233692&population=180&households=65

http://localhost:9002/save?postcode=ST7%202YB&latitude=53.096855&longitude=-2.294545&population=35&households=22

http://localhost:9002/save?postcode=LS2%209JT&latitude=53.807899&longitude=-1.553664&population=0&households=0

http://postcodelocationfinder.elasticbeanstalk.com/

http://postcodelocationfinder.elasticbeanstalk.com/save?postcode=LS2%209JT&latitude=53.807899&longitude=-1.553664&population=0&households=0

PostcodeLocationRequestReceiver
-------------------------------
JVM Arguments: -Duse.profile.credentials=true -Dserver.port=9000

http://localhost:9001

http://localhost:9001/postcode?postcode=SK1%203LF

http://localhost:9001/postcode?postcode=SK4%202HD

http://localhost:9001/postcode?postcode=ST5%204EP

http://localhost:9001/postcode?postcode=ST7%202YB

http://postcodelocationrequest.elasticbeanstalk.com/postcode?postcode=SK1%203LF

http://postcodelocationrequest.elasticbeanstalk.com/postcode?postcode=SK4%202HD

http://postcodelocationrequest.elasticbeanstalk.com/postcode?postcode=ST5%204EP

http://postcodelocationrequest.elasticbeanstalk.com/postcode?postcode=ST7%202YB

http://postcodelocationrequest.elasticbeanstalk.com/postcode?postcode=LS2%209JT

PostcodeLocationClient
----------------------
JVM Arguments: -Duse.profile.credentials=true -Dserver.port=9000

http://localhost:9000

http://localhost:9000/map.html

http://localhost:9000/upload?key=postcodes.csv&filename=E:/dev/git/PostcodeLocation/PostcodeLocationClient/testData/postcodes.csv

http://localhost:9000/displaypostcode?postcode=ST7%202YB&latitude=53.096855&longitude=-2.294545

http://localhost:9000/displaypostcode?postcode=LS2%209JT&latitude=53.807899&longitude=-1.553664

http://postcodelocationclient.elasticbeanstalk.com/

http://postcodelocationclient.elasticbeanstalk.com/map.html

http://postcodelocationclient.elasticbeanstalk.com/displaypostcode?postcode=ST7%202YB&latitude=53.096855&longitude=-2.294545

http://postcodelocationclient.elasticbeanstalk.com/displaypostcode?postcode=LS2%209JT&latitude=53.807899&longitude=-1.553664

Build Details
-------------
The project uses Gradle for building the application.

gradle build buildDockerZip --daemon --parallel

https://docs.gradle.org/current/userguide/multi_project_builds.html

AWS Secret Key (for running locally)
------------------------------------
%UserProfile%\.aws\credentials


AWS Role (for running on AWS)
-----------------------------
Create Role with SQS and DynamoDB access

AWS Queues
----------
PostcodeLocationDisplayQueue
PostcodeLocationFinderQueue
PostcodeLocationDisplayAuditQueue
PostcodeLocationFileQueue

eb cli
-------
eb 