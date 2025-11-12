# Use OpenJDK for Java app
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR
COPY target/*.jar app.jar

# Expose port
EXPOSE 8081

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
