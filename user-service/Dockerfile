#FROM maven:3.8-openjdk-17 as builder
#LABEL authors="flisc"
#ARG JAR_FILE=target/*.jar
#COPY ./target/user-service-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]
FROM maven:3.8-openjdk-17 as builder
EXPOSE 8080

COPY src /usr/app/src
COPY pom.xml /usr/app

RUN mvn -f /usr/app/pom.xml clean package


FROM openjdk:17-alpine

COPY --from=builder /usr/app/target/*.jar /usr/app/app.jar

ENTRYPOINT ["java", "-jar", "/usr/app/app.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]