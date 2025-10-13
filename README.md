# Automobile Fleet Management System 

A RESTful API built with Spring Boot for managing automobile fleet data with comprehensive CRUD operations, automated validation, and persistent MySQL storage.

## Overview

This system demonstrates modern enterprise application architecture using Object-Relational Mapping (ORM) to eliminate manual SQL querying. Designed for supply chain and logistics operations, it provides scalable vehicle tracking and management capabilities. It also provides full CRUD (Create, Read, Update, Delete) functionality for managing automobile objects, backed by a MySQL database. The application allows users to add, view, update, and delete automobile entries through a RESTful API. It uses Spring Data JPA for efficient database operations and is structured
for scalability and maintainability following standard Spring Boot best practices.

## Features

- **Complete CRUD Operations**: Create, read, update, and delete products
- **Custom Validation**: Enforces business rules for product data integrity
- **Exception Handling**: Centralized error handling with meaningful HTTP responses
- **Filtered Queries**: Built-in support for filtering test products via configuration
- **RESTful Design**: Follows REST API best practices

## Technologies Used

- Java 21
- Spring Boot 3.2.8
- Maven
- Spring Web
- MySQL

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
