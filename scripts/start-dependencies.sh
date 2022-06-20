#!/usr/bin/env bash

echo '============== Stopping and removing all containers. Avoid conflicts ... =============='
cd ..
docker-compose down

echo '============== Starting all docker dependencies ... =============='
docker-compose up -d zookeeper kafka mysql

sleep 25
cd scripts

echo '============== Creating topics ... =============='
./create-topics.sh

echo '============== Seeding topics ... =============='
docker-compose run kafkacat-bulk-seed-topics
echo '============== All dependencies started =============='
