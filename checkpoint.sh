#!/usr/bin/env bash
set -e

./mvnw clean package
docker build -t sdeleuze/docker-spring:builder .
docker run -d --privileged --rm --name=docker-spring --ulimit nofile=1024 -p 8080:8080 -v $(pwd)/target:/opt/mnt sdeleuze/docker-spring:builder
echo "Please wait during creating the checkpoint..."
sleep 10
docker commit --change='ENTRYPOINT ["/opt/app/entrypoint-restore.sh"]' $(docker ps -aqf "name=docker-spring") sdeleuze/docker-spring:checkpoint
docker kill $(docker ps -aqf "name=docker-spring")