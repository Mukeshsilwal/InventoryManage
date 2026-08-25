# Inventory Management System

A **RESTful inventory management API** built with Java Spring Boot, demonstrating clean architecture, SOLID principles, and JPA-based data persistence.

## Features

- Full CRUD operations for products and inventory
- Category management and stock tracking
- Low-stock alerts via threshold configuration
- Pagination and sorting on all list endpoints
- Input validation and global exception handling
- REST API with proper HTTP status codes

## Tech Stack

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data-JPA-6DB33F)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white)

## API Endpoints

```
GET    /api/products          - List all products (paginated)
POST   /api/products          - Create new product
GET    /api/products/{id}     - Get product by ID
PUT    /api/products/{id}     - Update product
DELETE /api/products/{id}     - Delete product
GET    /api/inventory/low-stock - Get low stock items
```

## How to Run

```bash
git clone https://github.com/Mukeshsilwal/InventoryManage
# Configure database in application.properties
mvn spring-boot:run
# API available at http://localhost:8080
```

## Design Principles Applied

- **SOLID** - Each class has a single responsibility, open for extension
- **Repository Pattern** - Data access layer abstracted via Spring Data JPA
- **DTO Pattern** - Clean separation between API contracts and domain models
- **Global Exception Handling** - Centralized error responses with @ControllerAdvice