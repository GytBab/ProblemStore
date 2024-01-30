# Ekspla ProblemStore
WEB page for learning Spring MVC and registering problems during laser manufacturing process

### Requirements
* Language JDK 17
* Check if JAVA_HOME used JDK 17

## Run DB with Docker
### Run mysql
```
docker compose up -d mysqldb
```

### Run postgres
```
docker compose up -d postgresqldb
```

### Run pgAdmin for postgres
```
docker compose up -d pgadmin4
```

## Run application using spring-boot
### on H2 DB
```
./mvnw spring-boot:run
```

### on mysql DB
```
./mvnw spring-boot:run -Dspring.profiles.active=mysql
```

### on postgresql DB
```
./mvnw spring-boot:run -Dspring.profiles.active=pg
```

## Access the application
http://localhost:8080