FROM maven:3.5-jdk-8

MAINTAINER "agustinservat@gmail.com"

COPY ./ ./

RUN mvn package

EXPOSE 8080

CMD ["java", "-jar", "./target/url-shortener-0.0.1-SNAPSHOT.jar"]

