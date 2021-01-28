#!/bin/sh
if [ $(docker ps -a -f name=studentSimulator | grep -w studentSimulator | wc -l) -eq 1 ]; then
  docker rm -f studentSimulator
fi
mvn clean package && docker build -t fr.ecoloscan/studentSimulator .
docker run -d -p 9080:9080 -p 9443:9443 --name studentSimulator fr.ecoloscan/studentSimulator
