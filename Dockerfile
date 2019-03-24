# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
MAINTAINER "agustinservat@gmail.com"


# Make port 8080 available to the world outside this container
EXPOSE 8080

# Add the application's jar to the container
ADD target/url-shortener-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

