# Stage 1: Build the Java application
# Use a slim, stable version of Maven and JDK 21 for building
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project folder structure
# The '.' means copy everything from the root directory set on Render
COPY . .

# Run the Maven build command
# '-DskipTests' is important to avoid running JUnit tests during deployment
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lean runtime image
# Use a small JRE (Java Runtime Environment) for faster startup and smaller image size
FROM eclipse-temurin:21-jre-alpine

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the 'build' stage
# The JAR file is in the target/ folder of the build stage
COPY --from=build /app/target/service-registry-0.0.1-SNAPSHOT.jar app.jar

# Define the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]