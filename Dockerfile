FROM eclipse-temurin:17-jdk-alpine

COPY target/example-deployment-1.0.0-SNAPSHOT-runner.jar example-deployment.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","example-deployment.jar"]

