@echo off
call mvn clean package
call docker build -t fr.ecoloscan/studentSimulator .
call docker rm -f studentSimulator
call docker run -d -p 9080:9080 -p 9443:9443 --name studentSimulator fr.ecoloscan/studentSimulator