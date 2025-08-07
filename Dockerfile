# Stage 1: Build the jar with Maven
FROM maven:3.9.0-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the project and skip tests to speed up
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the jar from the builder stage
COPY --from=builder /app/target/bweb-0.0.1-SNAPSHOT.jar app.jar

# Expose port if needed (default 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
