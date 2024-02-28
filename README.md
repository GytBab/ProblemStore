# Ekspla ProblemStore
WEB page for learning Spring MVC and registering problems during laser manufacturing process

### Prerequisites
This project used Bootstrap 5 and Spring Boot 3.2.1.
Spring Security version 6.2 included.

### Requirements
* Language JDK 17
* Check if JAVA_HOME used JDK 17

## Run DB with Docker
### Run mysql
```
docker compose up -d mysqldb
```

## Run application using spring-boot
### on H2 DB
```
./mvnw spring-boot:run
```

### on mysql DB
```
./mvnw spring-boot:run -D"spring.profiles.active=mysql"
```

## Access the application
http://localhost:8080