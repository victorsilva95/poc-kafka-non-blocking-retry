# poc-kafka-non-blocking-retry

Project created to study some features that were released in version 2.7 of spring boot (RetryableTopic and DltHandler)

## Description

Simple project that consumes from a kafka topic some records (Animes) and registers these animes in a Mysql database, if an error occurs, three re-attempts are performed and if the error persists, the record is sent to a dlt.

## Getting Started

### Dependencies

* Kafka
* Mysql
* Docker
* Maven 3.6.x+
* Java 17

Obs: kafka and mysql 
are present in the docker-compose file shipped in the project

### Installing

1. Clone project from repo:
```
git clone git@github.com:victorsilva95/poc-kafka-non-blocking-retry.git
```
2. Execute clean and package command from maven to check if the project is working:
```
mvn clean compile
```


### Executing program

* Before running the application, 
you need to run a script to upload the external 
dependencies (kafka, mysql) and also create the topic 
and publish some events in it, all this is 
encapsulated in the script called 
**start-dependencies.sh**.
```
1. cd scripts
2. ./start-dependencies.sh
```
* After it is finished, it will provide a 
mysql database on port 3306, and a kafka broker 
with 4 records, 1 of which are events 
that will enter the retry queue.
* Now at the project root let's generate the project jar and let's run it
```
1. mvn clean install
2. java -jar target/poc-kafka-non-blocking-retry-0.0.1.jar
```
* After the execution in the mysql database in the anime table there must be three animes registered and in the anime_dlt table there must be an anime registered after having four retries.


## Version History

* 0.2
    * Various bug fixes and optimizations
    * Unit Tests and Integration tests
* 0.1
    * Initial Release
