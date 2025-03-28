FROM maven:3.8-openjdk-17-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire project to the container
COPY src /app/src

# Build the application (creates a JAR file)
RUN mvn clean package -DskipTests





# Stage 2: Create a smaller runtime image
FROM openjdk:17-slim

# Set the working directory in the runtime image
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/springboot-docker-ec2-0.0.1-SNAPSHOT.jar /app/springboot-docker-ec2-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8089

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/springboot-docker-ec2-0.0.1-SNAPSHOT.jar"]