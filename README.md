# Auth System API (Spring Boot + JWT)

A production-style REST API for authentication and product management built using **Spring Boot, Spring Security, JWT, and JPA**.  
This project demonstrates secure authentication, role-based authorization, and scalable API design.

---

## Features

### Authentication & Authorization
- User Registration
- User Login
- JWT Token Generation
- Role-Based Access Control (ADMIN / USER)
- Secure Password Hashing with BCrypt

### Product Management
- Create Product (Admin only)
- Get All Products (Pagination + Sorting)
- Get Product by ID
- Update Product (Admin only)
- Delete Product (Admin only)

### Security
- Spring Security Integration
- JWT Authentication Filter
- Stateless API Security
- Protected Endpoints

### API Quality
- DTO-based architecture
- Global Exception Handling
- Standard API Response structure
- Validation using Jakarta Validation
- Swagger/OpenAPI documentation

### Deployment
- Dockerized Spring Boot application
- Deployed on Render

---

## Tech Stack

Backend:
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (io.jsonwebtoken)

Database:
- H2 Database (Development)

API Documentation:
- Swagger / OpenAPI

Deployment:
- Docker
- Render

---

## Project Architecture

src/main/java/com/preetam/authsystem

config
├── SecurityConfig
├── JwtAuthenticationFilter

controller
├── UserController
├── ProductController

service
├── UserService
├── ProductService
├── JwtService

repository
├── UserRepository
├── ProductRepository

entity
├── User
├── Product
├── Role

dto
├── LoginRequest
├── LoginResponse
├── RegisterRequest
├── ProductRequest
├── ProductResponse
├── ApiResponse

exception
├── GlobalExceptionHandler
├── ErrorResponse
├── ResourceNotFoundException


---

## API Endpoints

### Authentication

| Method | Endpoint | Description |
|------|------|------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and receive JWT |

---

### Products

| Method | Endpoint | Access |
|------|------|------|
| GET | /api/products | Public |
| GET | /api/products/{id} | Public |
| POST | /api/products | ADMIN |
| PUT | /api/products/{id} | ADMIN |
| DELETE | /api/products/{id} | ADMIN |

---

## Example JWT Authentication
Authorization: Bearer <your_token>
---

## Swagger Documentation
http://localhost:8080/swagger-ui/index.html

Deployed API Docs:


https://your-deployed-url/swagger-ui/index.html


---

## Running the Project

### Clone


git clone https://github.com/yourusername/auth-system-api.git


### Build


mvn clean install


### Run


mvn spring-boot:run


---

## Author

Preetam
Java Backend Developer
