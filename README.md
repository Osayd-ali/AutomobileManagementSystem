# Automobile Fleet Management System 

A RESTful API built with Spring Boot for managing automobile fleet data with comprehensive CRUD operations, automated validation, and persistent MySQL storage.

## Overview

This system demonstrates modern enterprise application architecture using Object-Relational Mapping (ORM) to eliminate manual SQL querying. Designed for supply chain and logistics operations, it provides scalable vehicle tracking and management capabilities. It also provides full CRUD (Create, Read, Update, Delete) functionality for managing automobile objects, backed by a MySQL database. The application allows users to add, view, update, and delete automobile entries through a RESTful API. It uses Spring Data JPA for efficient database operations and is structured
for scalability and maintainability following standard Spring Boot best practices.

## Features

- **VIN-based Vehicle Tracking**: Unique 17-character identifier for each automobile
- **Full CRUD Operations**: Create, read, update, and delete vehicle records
- **Automated Validation**: Data integrity enforcement at the API level
- **Multi-Location Support**: Track vehicles across distributed operations
- **RESTful Design**: Follows REST API best practices
- **Persistent Storage**: MySQL database for production-grade reliability
- **Custom Exception Handling**: Meaningful error messages and HTTP status codes

## Technologies Used

- Java 21
- Spring Boot 3.2.8
- Spring Data JPA : Data access abstraction
- Hibernate : ORM implementation
- MySQL 8.0: Relational Database
- Maven
- Spring Web
 

## API Endpoints

### Base URL: `/automobile`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/all` | Returns all automobiles in DB as JSON Array of JSON Objects |
| GET | `/vin/{vin}` | Returns the one automobile matching the provided VIN |
| GET | `/make/{make}` | Returns a list of automobiles matching the provided make |
| GET | `/model/{make}/{model}` | Returns a list of automobiles matching the provided model |
| GET | `/color/{color}` | Returns a list of automobiles matching the provided color |
| GET | `/year/{year}` | Returns a list of automobiles matching the provided year |
| GET | `/year/{startYear}/{endYear}` | Returns a list of automobiles with year between the provided start and end year |
| POST | `/create` | Creates a new Automobile object using the JSON automobile object provided in the message body |
| PUT | `/update` | Updates an existing Automobile object using the JSON automobile object provided in the message body, VIN in the JSON object is used to identify the Automobile to update. VIN cannot be changed |
| DELETE | `/delete/{vin}` | Deletes the automobile with the provided VIN |

## Validation Rules
- **VIN**: Must be exactly 17 alphanumeric characters, cannot be null
- **Make**: Cannot be null or empty
- **Model**: Cannot be null or empty
- **Color**: Cannot be null or empty
- **Year**: Must be between minimum allowed year and current year

## Architecture Highlights

## Three-Layer Architecture
1. **Controllter Latyer (@RestController)**
- Handles HTTP requests and responses
- Maps endpoints to service methods
- Manages exception handling

2. **Service Layer (@Service)**
- Contains business logic and validation
- Coordinates between controller and repository
- Implements domain-specific rules

3. **Repository Layer (@Repository)**
- Spring Data JPA interface
- Automatic CRUD implementation
- Custom query methods via naming conventions

## ORM Benefits Demonstrated
- **No Manual SQL**: All database operations through JPA repository methods
- **TypeSafety**: Compile-time checking of data access code
- **Database Independence**: Easy to switch from MySQL to PostgreSQL
- **Automatic Transactions**: Spring manages database transactions
- **Query Optimization**: Hibernate generates optimized SQL

### Testing
Use Postman or any HTTP client to test the endpoints. The application includes:

- Custom exception handling for validation errors
- HTTP status codes (200, 400, 404) for different scenarios
- Structured error responses for debugging
- Set base URL to http://localhost:8080

## Real-World Applications

## Supply Chain & Logistics
- **Fleet Management**: Track delivery vehicles across distribution centers
- **Maintenance Scheduling**: Monitor vehicle service history and upcoming maintenance
- **Compliance Tracking**: Maintain regulatory compliance records
- **Asset Management**: Complete vehicle lifecycle from acquisition to disposal

## Integration Scenarios
- **ERP Systems**: Integrate with enterprise resource planning software
- **Warehouse Management**: Connect with WMS for delivery coordination
- **Analytics Dashboards**: Provide data for fleet performance analysis
- **Third-Party APIs**: Share vehicle data with logistics partners
