#FROM maven:3.8-openjdk-17 as builder
#ARG JAR_FILE=target/*.jar
#COPY ./target/article-service-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8081
#ENTRYPOINT ["java", "-jar", "/app.jar"]
FROM maven:3.8-openjdk-17 as builder

COPY src /usr/app/src
COPY pom.xml /usr/app

RUN mvn -f /usr/app/pom.xml clean package
#EXPOSE 8081

FROM openjdk:17-alpine

COPY --from=builder /usr/app/target/*.jar /usr/app/app.jar

ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]