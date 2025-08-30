ARG MYTAG=latest
FROM ubuntu:${MYTAG}
LABEL CompanyName="CodeInvestigator"
LABEL Location="Berlin"
MAINTAINER "Jacek Sysiak"
ENV MYVARIABLE="TEST123"
#RUN apt-get update -y
#RUN apt-get install vim -y
#RUN apt install curl -y
WORKDIR /tmp
COPY mytextfile.txt newnamemytextfile.txt
RUN echo "A joke ${MYVARIABLE}" > joke1.txt; \
 echo "A joke ${MYVARIABLE}" > joke2.txt; \
 echo "A joke ${MYVARIABLE}" > joke3.txt
EXPOSE 8080/tcp
#EXPOSE 8090
#CMD ["My first argument", "Standard argument no 2"]
#ENTRYPOINT ["echo", "hello our container is running"]
ENTRYPOINT ["java", "-jar", "myspringapp.jar"]