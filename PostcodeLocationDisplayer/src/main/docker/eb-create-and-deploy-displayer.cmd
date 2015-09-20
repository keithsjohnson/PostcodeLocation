@REM https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3.html
eb init postcodelocation --region eu-west-1 --platform "Docker 1.6.2"

eb create postcodelocationdisplayer --cname postcodelocationdisplayer --instance_type t2.micro --region eu-west-1 --tier webserver
