# Stage 1: Build using Maven with Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY lib ./lib
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run the application using Java 21
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
