# Use the official Maven image as the parent image
FROM maven:3.8.4-openjdk-17 AS build-env

# Set the working directory in the container
WORKDIR /app

# Copy the source code
COPY src/ ./src/

# Copy the Maven project file
COPY pom.xml .

# Setting Java Environment Options

# Build the application skip tests and only show errors in log
RUN mvn clean install -DskipTests -q

# Run the unit tests
RUN mvn test surefire:test -B -ntp | egrep -v "(^\[INFO\] --- |^\[INFO\] Nothing|^\[INFO\] Copying|^\[INFO\] Skipping|^\[INFO\] Using|OpenJDK 64)"

# Use the official OpenJDK image with Alpine Linux
FROM openjdk:17-jdk-alpine AS app-env

# Set ENV
ENV DBNAME=""
ENV PGPASSWORD=""
ENV PGUSER=""
ENV PGHOST=""

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=build-env /app/target/*.jar /app/backend.jar

# Expose the port the app runs on
EXPOSE 8080

# Define the command to run the application #
CMD ["java", "-jar", "backend.jar"]
