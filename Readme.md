# Java SpringBoot API Template

This is a template project for a Java Spring Boot CRUD API that uses OracleDB as a database.

## Features

- [x] Dockerized OracleDB Database instance.
- [x] [Spring Boot & Devtools for hot reloading](https://spring.io/projects/spring-boot)
- [x] Unit tests 

## Getting Started

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [JDK 21](https://openjdk.org/projects/jdk/21/)
- Terminal or IDE of your choice

### Installing

Clone the repository or start a new project with this template.

Copy the .env.example file to .env and modify the values as needed.

```bash
cp example.env .env
```

### Running the tests

```bash
./gradlew test
```

### Running the application

You can either launch the docker container from your IDE or run:

```bash
docker-compose up -d
```

Then start the application with

```
./gradlew bootRun
```
### Using the example colors crud api

The example api is a simple CRUD api for colors. It has the following endpoints:

- GET /colors - Returns all colors
- GET /colors/:id - Returns a color by id
- POST /colors - Creates a new color
- PUT /colors/:id - Updates a color by id (id in json body needs to match id in url)
- DELETE /colors/:id - Deletes a color by id
