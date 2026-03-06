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
