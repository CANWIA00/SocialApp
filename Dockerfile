FROM openjdk:17
WORKDIR /app
ADD target/security30jwt-0.0.1-SNAPSHOT.jar security30jwt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","security30jwt-0.0.1-SNAPSHOT.jar"]

# Use the official MySQL image as a parent image
FROM mysql:latest

# Set the root password for MySQL
ENV MYSQL_ROOT_PASSWORD=root

# Create a database and user for your Spring Boot API
ENV MYSQL_DATABASE=security
ENV MYSQL_USER=canwia
ENV MYSQL_PASSWORD=UNDERground35

# Copy the SQL script to initialize the database schema
#COPY init.sql /docker-entrypoint-initdb.d/