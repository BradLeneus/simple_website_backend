# image naven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app


COPY pom.xml ./pom.xml
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q -DskipTests package

#Image java 21
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar

# Variables d'environnement 
ENV DB_HOST=localhost \
    DB_PORT=3306 \
    DB_NAME=maintenance \
    DB_USER=user \
    DB_PASS=password \
    JAVA_OPTS=""

EXPOSE 8182
ENTRYPOINT ["/bin/sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
