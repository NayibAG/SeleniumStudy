#!/bin/bash

clear

echo "RUN TEST SUITE IN CHROME BROWSER USING DOCKER COMPOSE"
docker-compose -f docker-compose-chrome.yaml up --build -d

echo "STOP AND REMOVE THE CONTAINERS FROM CHROME TEST SUITE"
docker-compose -f docker-compose-chrome.yaml down

echo "REMOVE THE IMAGE FROM SELENIUMSTANDALONE-CHROME"
docker rmi selenium/standalone-chrome

echo "RUN TEST SUITE IN FIREFOX BROWSER USING DOCKER COMPOSE"
docker-compose -f docker-compose-firefox.yaml up --build -d

echo "STOP AND REMOVE THE CONTAINERS FROM FIREFOX TEST SUITE"
docker-compose -f docker-compose-firefox.yaml down

echo "REMOVE THE IMAGE FROM SELENIUMSTANDALONE-FIREFOX"
docker rmi selenium/standalone-firefox

echo "REMOVE THE IMAGE FROM SELENIUMSTUDY"
docker rmi seleniumstudy_seleniumstudy