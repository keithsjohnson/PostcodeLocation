cd PostcodeLocationClient\build\docker
start eb-create-and-deploy-client.cmd
@REM cd ..\..\..\PostcodeLocationDisplayer\build\docker
@REM start eb-create-and-deploy-displayer.cmd
cd ..\..\..\PostcodeLocationFinder\build\docker
start eb-create-and-deploy-finder.cmd
cd ..\..\..\PostcodeLocationRequestReceiver\build\docker
start eb-create-and-deploy-requestreceiver.cmd
cd ..\..\..\
