#!/bin/bash

clear

# Create the seleniumstudy image
docker build . -f Dockerfile -t seleniumstudy
# Run seleniumstudy container
docker run --rm --name seleniumstudy seleniumstudy

# Stop and delete SeleniumStudy container
echo "--- List all inactive containers "
docker ps -a

echo "--- Stop the container"
docker stop seleniumstudy

echo "--- Remove the container"
docker rm seleniumstudy

echo "--- List all inactive containers "
docker ps -a

# Delete SeleniumStudy image
echo "--- List all images"
docker images

echo "--- Remove image"
docker rmi seleniumstudy

echo "--- List all images"
docker images

docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome