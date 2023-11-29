# Java Spring Task Tracker

An API for tracking tasks, built using Java and the Spring Boot web framework.

## Getting Started

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [JDK 21](https://openjdk.org/projects/jdk/21/)
- Terminal or IDE of your choice

### Installing

Clone the repository

```bash
git clone https://github.com/zspratt21/JavaSpringTaskTracker
```

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

Use an API client such as ARC or Postman, to make requests to the API. By default, the API is hosted at http://localhost:8085. The following endpoints are available:
#### GET /api/Tasks
Returns a list of all tasks.
#### GET /api/Tasks/{id}
Returns a single task with the specified id.
#### POST /api/Tasks
Creates a new task. The request body should contain a JSON object with the following properties:
- name (string)
- isCompleted (bool)
#### PUT /api/Tasks/{id}
Updates an existing task with the specified id. The request body should contain a JSON object with the following properties:
- id (int)
- name (string)
- isCompleted (bool)
#### DELETE /api/Tasks/{id}
Deletes an existing task with the specified id.

## Made With
- [Java 21](https://openjdk.java.net/projects/jdk/21/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Mustache](https://mustache.github.io/)
- [Oracle Database](https://www.oracle.com/database/)
- [Docker](https://www.docker.com/)
- [Tailwind CSS](https://tailwindcss.com/)
- [Intelij IDEA](https://www.jetbrains.com/idea/)