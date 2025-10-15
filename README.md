# MSP Backend

This is the backend service for the MSP (Member Service Portal) application, built with Spring Boot.

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Security with JWT Authentication
- Spring Data JPA
- MySQL Database
- Maven

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── msp/
│   │           └── backend/
│   │               ├── config/      # Configuration files (JWT, Security)
│   │               ├── controller/  # REST API endpoints
│   │               ├── model/       # Data models/entities
│   │               ├── repository/  # Database repositories
│   │               └── service/     # Business logic
│   └── resources/
│       └── application.properties  # Application configuration
```

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/wxuan00/msp-backend.git
   ```

2. Configure MySQL database in `application.properties`

3. Build the project:
   ```bash
   ./mvnw clean install
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The server will start on port 8081 by default.

## Features

- User Authentication with JWT
- Role-based Authorization
- Transaction Management
- User Management
- Refund Processing

## API Endpoints

- `POST /api/auth/login` - User authentication
- `GET /api/users` - Get all users (Admin only)
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user
- `GET /api/transactions` - Get transactions
- `GET /api/refunds` - Get refund information

## Security

- JWT-based authentication
- Role-based access control
- Password encryption
- Secure session management