@REM https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3.html
eb init postcodelocation --keyname keithsjohnson-key-pair-ireland --region eu-west-1 --platform "Docker 1.6.2"

eb create postcodelocation --cname postcodelocationclient --instance_type t2.micro --region eu-west-1 --tier webserver

@REM eb deploy postcodelocation 

@REM eb terminate postcodelocation --all --force 
