FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy Maven descriptor and resolve dependencies first (better layer caching)
COPY pom.xml .
RUN mvn -q -e -B dependency:go-offline

# Copy source and build the application
COPY src ./src
RUN mvn -q -e -B clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

