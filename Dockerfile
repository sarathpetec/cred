# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 as build

# Set the working directory in the Docker image
WORKDIR /app

# Copy your project files into the Docker image
COPY . .

# Run Maven clean install to build your application
RUN mvn clean install

# Stage 2: Create the final image with just the JAR file
FROM openjdk:17

# Expose port 8080 for the application
EXPOSE 8080

# Copy the JAR file from the build stage into this new image
COPY --from=build /app/target/spring-boot-cred.jar /spring-boot-cred.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/spring-boot-cred.jar"]
