
# Event Registration API

## Laboratory Work 7 — Spring Boot REST Controller

**Student:** Imantaev Sanzhar  
**Group:** IT3-2502DS

## Description

This project is a Spring Boot REST API for managing events.

It supports creating, reading, updating, deleting and searching events using HTTP requests.

The application stores event data in an in-memory ArrayList.

## Technologies

- Java 21
- Spring Boot 3.4.5
- Gradle
- Spring Web
- Postman

## Project Structure

- model - EventInfo class
- service - EventService class
- controller - RegistrationController class

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/hello | Welcome message |
| GET | /api/info | Application information |
| GET | /api/events | Get all events |
| GET | /api/events/{id} | Get event by ID |
| GET | /api/events?title=quiz | Search events by title |
| POST | /api/events | Create a new event |
| PUT | /api/events/{id} | Update an event |
| DELETE | /api/events/{id} | Delete an event |

## Example JSON Body

```json
{
  "title": "Python Workshop",
  "location": "Room 404"
}
```

## HTTP Status Codes

- 200 OK - Request successful.
- 201 Created - Event successfully created.
- 204 No Content - Event successfully deleted.
- 400 Bad Request - Invalid or empty input.
- 404 Not Found - Event does not exist.

## How to Run

1. Install JDK 21.
2. Open the project in IntelliJ IDEA.
3. Run EventRegistrationApplication.java.
4. The application starts at http://localhost:8080.
5. Use Postman to test the API endpoints.

## Dependency Injection

EventService is injected into RegistrationController through constructor injection.

Spring manages the service using the @Service annotation.

The controller handles HTTP requests, while the service manages event data and business logic.

## Testing

The API was tested using Postman.

The following operations were tested:

- GET all events.
- GET event by ID.
- Search events by title.
- POST a new event.
- PUT update an existing event.
- DELETE an event.
- Check responses for missing IDs.

## Conclusion

This laboratory work demonstrates how to create and test a REST API using Spring Boot.

CRUD operations, HTTP methods, request parameters, path variables and JSON request bodies were implemented and tested.
