uruchamiaj w gitBaszu:  w lokalizacji projektu: ~/Documents/JAVA/SpringBoot/dockerProjects/01-hello-world-rest-api (master)
---------------------------------------------------------------------
1.
tworzymy Container:
docker container exec crazy_wu ls /tmp

wrzucamy fizyczny plik jar do Contenera:
docker container cp target/hello-world-rest-api.jar crazy_wu:/tmp

tworzymy image w Contenerze:
docker container commit crazy_wu j4sysiak/hello-world-rest-api:manual1

Uruchamiamy image:
docker run j4sysiak/hello-world-rest-api:manual1

sprawdzamy:
docker container ls

2. inny sposób uruchomienia:
docker container commit --change='CMD ["java","-jar","/tmp/hello-world-rest-api.jar"]' crazy_wu j4sysiak/hello-world-rest-api:manual3
docker run -p 8080:8080 j4sysiak/hello-world-rest-api:manual3

3. uruchomienie przy pomocy pliku Dockerfile:

dodajemy plik Dockerfile:
EXPOSE 8080
ADD target/hello-world-rest-api.jar hello-world-rest-api.jar
ENTRYPOINT ["sh", "-c", "java -jar /hello-world-rest-api.jar"]

#mvn clean package

tworzymy image z pliku Dockerfile:
Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/01-hello-world-rest-api (master)
$ docker build -t j4sysiak/hello-world-rest-api:dockerfile1 .
/.../
#7 DONE 0.4s

uruchamiamy image:
docker run -p 8080:8080 j4sysiak/hello-world-rest-api:dockerfile1