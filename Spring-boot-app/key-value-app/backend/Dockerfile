#Build stage 1 to copy dependencies and copy src code for compilation

FROM maven:3.9-eclipse-temurin-21 AS build


WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package


#Build stage 2 to only copy jre and app.jar

FROM eclipse-temurin:21-jre

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]