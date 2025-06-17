# Student Management System (CRUD)

A RESTful web application built using Spring Boot to manage student data with full CRUD operations.  
The project follows a layered architecture, integrates Swagger for API documentation, and uses Spring Data JPA with MySQL for database operations.


---
## Project Structure

```text
StudentManagementSystem-CRUD/
└── src/
    └── main/
        ├── java/
        │   └── org/
        │       └── jsp/
        │           └── student_rest/
        │               ├── controller/                   # Handles incoming REST API requests
        │               │   └── StudentController.java
        │               ├── service/                      # Business logic layer
        │               │   └── StudentService.java
        │               ├── repository/                   # Interfaces for database operations
        │               │   └── StudentRepository.java
        │               ├── dto/                          # Data Transfer Objects for request/response
        │               │   └── StudentDTO.java
        │               ├── exception/                    # Centralized exception handling
        │               │   ├── DataAlreadyExistsException.java
        │               │   ├── DataNotFoundException.java
        │               │   └── MyExceptionHandler.java
        │               └── StudentRestApplication.java   # Main Spring Boot application
        └── resources/
            └── application.properties                    # Configuration for DB and Spring Boot setup

```
## Features

1. **RESTful API Design:**
     + Follows REST principles for building scalable and maintainable APIs
3. **Layered Architecture:**
     + Organized into Controller, Service, and Repository layers for clean separation of concerns
3. **CRUD Operations:**
     + Supports Create, Read, Update, and Delete operations on student entities
5. **Swagger Integration:**
    + Provides interactive API documentation for easy visualization of endpoints using Swagger UI.
5. **Centralized Exception Handling:**
    + Uses custom exceptions and a global handler for consistent error responses
6. **Pagination and Sorting:**
    + Enables efficient data retrieval with page and sort query support
7. **MySQL Database Integration:**
    + Persists student data using Spring Data JPA with MySQL

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger
- Lombok

## Swagger UI Preview

![image](https://github.com/user-attachments/assets/9db18f08-28c2-4ce2-a117-dc07dd64ec68)
