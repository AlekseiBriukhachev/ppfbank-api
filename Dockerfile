FROM openjdk:17-jdk-slim

WORKDIR /ppfbank-api

COPY build/libs/*.jar ppfbank-api.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "ppfbank-api.jar"]