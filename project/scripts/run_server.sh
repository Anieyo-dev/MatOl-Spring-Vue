#!/bin/bash
cd ..

clear
echo "WHICH SERVER TO RUN?:"
echo "1. development server"
echo "2. development server + rebuild"
read -s -n1 choice

if [ $choice -eq "1" ]; then
    cd docker
    echo "Starting DEVELOPMENT server"
    docker-compose -f docker-compose.yml up --remove-orphans
elif [ $choice -eq "2" ]; then
    cd docker
    echo "Starting DEVELOPMENT server with rebuild"
    docker-compose -f docker-compose.yml up --remove-orphans --build
else
    echo "DONE NOTHING NO OPTION SELECTED!"
fi