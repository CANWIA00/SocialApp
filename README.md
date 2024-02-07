# SocialMedia Application

Welcome to our SocialMedia application! This application is built with Spring Boot and utilizes JWT for authentication, Spring Security 3.0 for secure endpoints, and WebSocket for real-time communication.

---

## Usage

1. **Register/Login**: Create a new user account or log in using existing credentials to access the application.
2. **Explore Features**: Discover various application features such as creating posts, commenting, liking, following other users, and real-time messaging.
3. **Logout**: Always remember to log out when you're finished using the application to ensure the security of your account.

---

## Features

- **User Authentication**: JWT-based authentication system ensures secure user login and access control.
- **Real-time Messaging**: Utilizes WebSocket for instant messaging between users.
- **CRUD Operations**: Enables users to create, read, update, and delete posts.

---

## Technologies Used

- Java: 17
- Spring Boot: Framework for building Java-based enterprise applications.
- JWT (JSON Web Tokens): Authentication mechanism for securing API endpoints.
- Spring Security 3.0: Provides comprehensive security services for Java EE-based enterprise software applications.
- WebSocket: Protocol for full-duplex communication channels over a single TCP connection.

---

## Project Scale

### Database Tables and Relations

We have designed the following database tables and their relations to efficiently manage our application's data:

![Database Schema](https://github.com/CANWIA00/SocialApp/assets/88516058/d0ff95c9-b6da-4296-b802-35bf24ed0e9a)

This database schema illustrates the structure and relationships between different entities in our application.

### JWT - JSON Web Token

We leverage JSON Web Tokens (JWT) for user authentication, enabling secure access to our application:

![JWT Authentication](https://github.com/CANWIA00/SocialApp/assets/88516058/3b3e5ad7-e742-41aa-904e-9675c17601a8)

JWT allows seamless user authentication and access management. 

### WebSocket

We utilize WebSocket technology to enable real-time communication between users:

![WebSocket Communication](https://github.com/CANWIA00/SocialApp/assets/88516058/b95ab61f-2455-4323-8541-6783d33d55db)

WebSocket ensures efficient real-time messaging, enhancing user engagement.

---

## Configuration

- `application.properties`: Configuration file for Spring Boot properties.
- `ApplicationConfig.java`: Custom application configuration class.
- `SecurityConfig.java`: Configuration file for Spring Security settings.
- `WebSocketConfig.java`: Configuration class for WebSocket.
- `OpenApiConfig.java`: Configuration class for Swagger/OpenAPI integration.

These configuration files provide flexibility and control over various aspects of our application.

---


