# 🏋️‍♂️ Gym Management System API

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED)
![Security](https://img.shields.io/badge/Spring_Security-JWT-red)

## 📖 About the Project

This is a **RESTful API** designed for managing a Gym ecosystem. It handles the registration and management of **Members**, **Instructors**, **Membership Plans**, **Gym Equipment**, and **Physical Evaluations**.

The project was built with a focus on **Software Architecture**, **Security**, and **Scalability**, implementing modern practices such as **Stateless Authentication (JWT)**, **Database Migrations (Flyway)**, and **Containerization (Docker)**.

## 🚀 Tech Stack

- **Language:** Java 21 (LTS)
- **Framework:** Spring Boot 3.3.0
- **Database:** PostgreSQL 16
- **Migrations:** Flyway
- **Security:** Spring Security + JWT (JSON Web Tokens) + BCrypt
- **Containerization:** Docker & Docker Compose
- **Documentation:** Swagger UI (OpenAPI 3.0)
- **Utilities:** Lombok, Bean Validation

## 🏗️ Architecture & Patterns

This project follows a strict **Layered Architecture** to ensure separation of concerns:

- **Controllers:** Handle HTTP requests and responses (REST).
- **Services:** Contain business logic, transaction management (`@Transactional`), and password encryption.
- **Repositories:** Manage data persistence using **Spring Data JPA** and custom **JPQL** queries.
- **DTOs:** Data Transfer Objects to decouple internal entities from the API layer.
- **Domain Models:** Mapped with JPA, using **UUIDs** for secure primary keys.

### Key Technical Features
* **Global Exception Handling:** Centralized error management using `@RestControllerAdvice` returning standardized `ProblemDetail` JSON responses.
* **Custom Validation:** Implementation of custom annotations (e.g., `@CpfValido`) for Brazilian document validation.
* **Pagination & Sorting:** Optimized endpoints using `Pageable` and `Page<T>` to handle large datasets efficiently.
* **Observability:** Custom Servlet Filter that injects a unique **Correlation-ID** into logs (MDC) to trace requests from start to finish.
* **Secure Authentication:** Stateless login flow issuing signed JWTs with expiration.

## 🛠️ Getting Started

### Prerequisites
* **Docker Desktop** (running)
* **Java 21 JDK** (optional if running via IDE wrapper, but recommended)
* **Git**

### 1. Clone the repository
```bash
git clone [https://github.com/danielacvmelo/gym-management-system.git](https://github.com/danielacvmelo/gym-management-system.git)
cd gym-management-system

2. Start the Database
The project includes a docker-compose.yml file to set up the PostgreSQL database automatically.

Bash

docker compose up -d
This will start PostgreSQL on port 5434.

3. Run the Application
You can run the application using Maven or your IDE (IntelliJ IDEA recommended).

Via Terminal:

Bash

./mvnw spring-boot:run
Via IntelliJ: Run the AcademiaApplication.java class.

4. Database Seeding
On the first run, Flyway will automatically:

Create the database schema (V1__create_tables.sql).

Populate the database with seed data (V2__insert_data.sql), including test users and plans.

🔌 API Documentation (Swagger)
Once the application is running, access the interactive API documentation at:

👉 http://localhost:8080/swagger-ui/index.html

How to Authenticate
The API is secured. To test endpoints, you must obtain a JWT:

Go to POST /login.

Use the default admin credentials:

Email: arnold@gym.com

Password: 123456

Copy the returned Token.

Click the Authorize 🔓 button at the top of the Swagger page.

Paste the token (e.g., eyJhbGci...) and click Authorize.

📂 Database Schema
The database relies on UUIDs for all primary keys to ensure global uniqueness and security.

usuarios: Centralized authentication table (Admin/User profiles).

membros: Gym members linked to a User and a Plan.

instrutores: Gym staff linked to a User.

planos_membresia: Subscription tiers.

agendamentos: Scheduling for classes/evaluations.

avaliacoes_fisicas: Health metrics tracking.

🧪 Testing
The project includes:

Unit/Integration Tests: Controllers and Services are tested to ensure business logic correctness.

Filter/Search Endpoints:

GET /usuarios/buscar?nome=X: Keyword search.

GET /instrutores/filtro?especialidade=X: Filter by category.

GET /membros/matriculados-apos?data=X: Date-based filtering.
