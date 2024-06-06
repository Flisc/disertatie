FROM maven:3.8-openjdk-17 as builder
ARG JAR_FILE=target/*.jar
COPY ./target/article-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]