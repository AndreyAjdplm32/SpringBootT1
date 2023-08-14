FROM openjdk:17-jdk-alpine
EXPOSE 8081
COPY ./ ./

ENTRYPOINT ["java","-jar","spingBootT1-0.0.1-SNAPSHOT.jar"]