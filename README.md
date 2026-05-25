# Creator-Store

A full-stack backend application built with **Spring Boot** and **Supabase PostgreSQL**, designed to power an e-commerce style platform for managing products, orders, and order items efficiently.

---

# Features

* Product management system
* Order creation and tracking
* Order item handling for multiple products per order
* RESTful API architecture
* PostgreSQL database integration using Supabase
* Layered backend architecture
* Spring Data JPA for ORM
* Secure and scalable backend design
* Environment-based configuration support

---

# Tech Stack

## Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

## Database

* Supabase PostgreSQL

## Tools & Utilities

* IntelliJ IDEA
* Postman
* Git & GitHub

---

# Project Structure

```bash
Creator-Store/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/creatorstore/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       └── config/
│   │   │
│   │   └── resources/
│   │       ├── application.yml
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

# Database Design

The application follows a relational database design with three main entities.

## Tables

### Product

Stores information related to products available in the store.

#### Example Fields

* id
* product_name
* description
* price
* stock_quantity
* image_url

---

### Orders

Stores customer order details.

#### Example Fields

* id
* customer_name
* order_date
* total_amount
* order_status

---

### OrderItem

Acts as a bridge table between Products and Orders.

#### Example Fields

* id
* order_id
* product_id
* quantity
* subtotal

---

# Entity Relationship

```text
Orders
   |
   | One-to-Many
   v
OrderItem
   ^
   | Many-to-One
   |
Products
```

---

# API Endpoints

## Product APIs

| Method | Endpoint       | Description         |
| ------ | -------------- | ------------------- |
| GET    | /products      | Fetch all products  |
| GET    | /products/{id} | Fetch product by ID |
| POST   | /products      | Add new product     |
| PUT    | /products/{id} | Update product      |
| DELETE | /products/{id} | Delete product      |

---

## Order APIs

| Method | Endpoint     | Description       |
| ------ | ------------ | ----------------- |
| GET    | /orders      | Fetch all orders  |
| GET    | /orders/{id} | Fetch order by ID |
| POST   | /orders      | Create order      |
| DELETE | /orders/{id} | Delete order      |

---

# Getting Started

## Prerequisites

Make sure you have installed:

* Java 17+
* Maven
* Git
* PostgreSQL / Supabase account

---

# Installation

## Clone the Repository

```bash
git clone https://github.com/your-username/Creator-Store.git
cd Creator-Store
```

---

## Configure Environment Variables

Update your `application.yml` file:

```yml
spring:
  application:
    name: CreatorStore

  datasource:
    url: ${DATABASE_URL}
    username: ${DATABASE_USERNAME}
    password: ${DATABASE_PASSWORD}

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

---

## Run the Application

```bash
mvn spring-boot:run
```

Application will start on:

```bash
http://localhost:8080
```

---

# Sample JSON

## Create Product

```json
{
  "productName": "Wireless Mouse",
  "description": "Ergonomic wireless mouse",
  "price": 799,
  "stockQuantity": 20
}
```

---

## Create Order

```json
{
  "customerName": "John Doe",
  "orderStatus": "PLACED",
  "totalAmount": 1598
}
```

---

# Future Improvements

* JWT Authentication & Authorization
* Payment Gateway Integration
* User management system
* Shopping cart functionality
* Product image uploads
* Docker support
* CI/CD pipeline
* Swagger/OpenAPI documentation
* Microservices architecture

---

# Learning Outcomes

This project helped in understanding:

* Spring Boot backend development
* REST API design
* Database relationship modeling
* JPA & Hibernate ORM
* PostgreSQL integration with Supabase
* Backend project structuring
* CRUD operation handling

---

# Contributing

Contributions are welcome.

1. Fork the repository
2. Create a new branch
3. Commit your changes
4. Push the branch
5. Open a Pull Request

---

# License

This project is licensed under the MIT License.

---

# Author

**Navoneel Dey**

Backend Developer | Java & Spring Boot Enthusiast
