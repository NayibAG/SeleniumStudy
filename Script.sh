#!/bin/bash

clear

echo "--- Run Selenium Grid Hub"
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:latest

echo "--- Create the seleniumstudy image"
docker build . -f Dockerfile -t seleniumstudy

echo "--- Run seleniumstudy container"
docker run --rm --name seleniumstudy seleniumstudy

# Stop and delete SeleniumStudy container
echo "--- List all inactive containers "
docker ps -a

echo "--- Stop the container"
docker stop seleniumstudy selenium/standalone-chrome:latest

echo "--- Remove the container"
docker rm seleniumstudy selenium/standalone-chrome:latest

echo "--- List all inactive containers "
docker ps -a

# Delete SeleniumStudy image
echo "--- List all images"
docker images

echo "--- Remove image"
docker rmi seleniumstudy

echo "--- List all images"
docker images



