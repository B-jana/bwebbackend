# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file to the image
COPY target/bweb-0.0.1-SNAPSHOT.jar app.jar

# Expose port (change if your app uses a different port)
EXPOSE 8081

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
