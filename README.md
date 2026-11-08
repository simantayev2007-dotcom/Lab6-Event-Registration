
# Event Registration API

## Description
This project is a Spring Boot REST API developed for Laboratory Work 6.
It demonstrates Dependency Injection and REST endpoints.

## Technologies
- Java 21
- Spring Boot
- Gradle
- Spring Web

## Project Structure
- model - EventInfo class
- service - EventService class
- controller - RegistrationController class

## API Endpoints

| Method | Endpoint | Description |
| GET | /api/hello | Welcome message |
| GET | /api/events | List of events |
| GET | /api/info | Application information |

## How to Run

1. Install JDK 17 or higher.
2. Open the project in IntelliJ IDEA.
3. Run EventRegistrationApplication.java.
4. Open http://localhost:8080/api/events in your browser.

## Dependency Injection
EventService is injected into RegistrationController through its constructor.
Spring manages the service using the @Service annotation.
