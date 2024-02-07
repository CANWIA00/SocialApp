# SocialMedia Application

Welcome to our SocialMedia application! This application is built with Spring Boot and utilizes JWT for authentication, Spring Security 3.0 for secure endpoints, and WebSocket for real-time communication.

## Features

- User Authentication: JWT-based authentication system for secure user login and access control.
- Real-time Messaging: Utilizes WebSocket for real-time messaging between users.
- CRUD Operations: Enables users to create, read, update, and delete posts and interact with other users' posts.

## Technologies Used
- Java: 17
- Spring Boot: Framework for building Java-based enterprise applications.
- JWT (JSON Web Tokens): Authentication mechanism for securing API endpoints.
- Spring Security 3.0: Provides comprehensive security services for Java EE-based enterprise software applications.
- WebSocket: Protocol for full-duplex communication channels over a single TCP connection.

## Setup Instructions

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/your-username/socialmedia-app.git
    ```

2. **Navigate to the Project Directory:**

    ```bash
    cd socialmedia-app
    ```

3. **Build the Application:**

    ```bash
    ./mvnw clean package
    ```

4. **Run the Application:**

    ```bash
    java -jar target/socialmedia-app.jar
    ```

5. **Access the Application:**

    Open your web browser and go to [http://localhost:8080](http://localhost:8080).

## Configuration

- `application.properties`: Configuration file for Spring Boot properties.
- `security-config.xml`: Configuration file for Spring Security settings.
- `WebSocketConfig.java`: Configuration class for WebSocket.


## Usage

- Register a new user account or log in with existing credentials.
- Explore the application features such as creating posts, commenting on posts, and messaging other users.
- Log out when you're finished using the application.


## Contact

If you have any questions or feedback, feel free to reach out:

- Your Name
- Email: your@email.com
- GitHub: [your-username](https://github.com/your-username)
