# Use Java 17 as base image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy Maven build artifact (jar)
COPY target/*SNAPSHOT.jar app.jar

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]