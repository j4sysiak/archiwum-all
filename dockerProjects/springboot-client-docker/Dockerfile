FROM openjdk:8-jdk-alpine
ADD target/*.jar client.jar
EXPOSE 12121
ENTRYPOINT ["java","-jar","client.jar"]
