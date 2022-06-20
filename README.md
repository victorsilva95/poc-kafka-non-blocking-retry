# poc-kafka-non-blocking-retry

Project created to study some features that were released in version 2.7 of spring boot (RetryableTopic and DltHandler)

## Description

Simple project that consumes from a kafka topic some records (Animes) and registers these animes in a Mysql database, if an error occurs, three re-attempts are performed and if the error persists, the record is sent to a dlt.

## Getting Started

### Dependencies

* Kafka
* Mysql
* Docker
* Maven 3.8.1
* Java 17

Obs: kafka and mysql 
are present in the docker-compose file shipped in the project

### Installing

* How/where to download your program
* Any modifications needed to be made to files/folders

### Executing program

* How to run the program
* Step-by-step bullets
```
code blocks for commands
```

## Help

Any advise for common problems or issues.
```
command to run if program contains helper info
```

## Authors

Contributors names and contact info

ex. Dominique Pizzie  
ex. [@DomPizzie](https://twitter.com/dompizzie)

## Version History

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
* 0.1
    * Initial Release

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)