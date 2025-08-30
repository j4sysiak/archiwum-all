FROM openjdk:8-jdk-alpine as mybuilder
RUN mkdir /opt/project
WORKDIR /opt/project
COPY src ./src
COPY build.gradle .
COPY gradlew .
COPY gradle ./gradle
RUN ./gradlew buildForDocker

FROM azul/zulu-openjdk-alpine:8-jre
COPY --from=mybuilder /opt/project/build/libs/docker/app.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
