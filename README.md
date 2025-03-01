# MovieInfo - Spring Reactive Project with MongoDB

## Overview
MovieInfo is a reactive Spring Boot application that provides movie-related information using Spring WebFlux and MongoDB. The application follows a fully non-blocking, event-driven architecture to ensure high performance and scalability.

## Features
- Reactive CRUD operations for movie information.
- Integration with MongoDB as the database.
- Uses Spring WebFlux for asynchronous request handling.
- Error handling and validation mechanisms.

## Technologies Used
- **Spring Boot** (3.x)
- **Spring WebFlux**
- **Spring Data MongoDB**
- **MongoDB**
- **Project Reactor**
- **JUnit 5 & Mockito** (for testing)

## Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven 3+
- MongoDB (running locally or via Docker)

## Setup Instructions
### Clone the Repository
```bash
git clone https://github.com/your-repo/movieinfo.git
cd movieinfo
```

### Configure MongoDB
Modify `application.properties` or `application.yml`:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/movieinfo-db
```

### Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

### Run Tests
```bash
mvn test
```

## API Endpoints
### Create Movie Info
```http
POST /movies
Content-Type: application/json
{
    "title": "Inception",
    "releaseYear": 2010,
    "genre": "Sci-Fi"
}
```

### Get All Movies
```http
GET /movies
```

### Get Movie by ID
```http
GET /movies/{id}
```

### Update Movie Info
```http
PUT /movies/{id}
Content-Type: application/json
{
    "title": "Inception Updated",
    "releaseYear": 2010,
    "genre": "Sci-Fi"
}
```

### Delete Movie
```http
DELETE /movies/{id}
```

## Docker Support
To run MongoDB in Docker:
```bash
docker run -d --name mongodb -p 27017:27017 mongo
```

## License
This project is licensed under the MIT License.

