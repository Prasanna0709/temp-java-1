FROM eclipse-temurin:17-jdk-alpine

COPY target/quarkus-app/quarkus-run.jar example-deployment.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","example-deployment.jar"]

