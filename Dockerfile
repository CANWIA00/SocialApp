FROM openjdk:17
WORKDIR /app
ADD target/security30jwt-0.0.1-SNAPSHOT.jar security30jwt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","security30jwt-0.0.1-SNAPSHOT.jar"]