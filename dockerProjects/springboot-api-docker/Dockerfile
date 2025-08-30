FROM openjdk:8-jdk-alpine
ADD target/*.jar api.jar
EXPOSE 10101
ENTRYPOINT ["java","-jar","api.jar"]