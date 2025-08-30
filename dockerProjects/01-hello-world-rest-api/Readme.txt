uruchamiaj w gitBaszu:  w lokalizacji projektu: ~/Documents/JAVA/SpringBoot/dockerProjects/01-hello-world-rest-api (master)
---------------------------------------------------------------------
1. Tworzymy Container - <d> detached    <it> - interactive shell:
docker run -dit openjdk:8-jdk-alpine

sprawdzamy images:
docker images

sprawdzamy jakie Containers pracują:
docker container ls

listowanie co siężńą€ęąąłó€tworzymy folder /tmp w kontenerze:
docker container exec intelligent_zhukovsky ls /tmp

wrzucamy fizyczny plik jar do Contenera do katalogu /tmp:
docker container cp target/hello-world-rest-api.jar intelligent_zhukovsky:/tmp

tworzymy image w Contenerze:
docker container commit intelligent_zhukovsky j4sysiak/hello-world-rest-api:manual1

usuwanie Image:
docker rmi <your-image-id>

Uruchamiamy image:  - ale musimy attach do niego coś jeszcze
docker run j4sysiak/hello-world-rest-api:manual1

sprawdzamy:  (na tym etapie ten image manual nie będzie diałać)
docker container ls

2. prawidłowe utworzenie obrazu
docker container commit --change='CMD ["java","-jar","/tmp/hello-world-rest-api.jar"]' intelligent_zhukovsky j4sysiak/hello-world-rest-api:manual2

2b.  i uruchomienie image w kontenerze:
docker run -p 8080:8080 j4sysiak/hello-world-rest-api:manual2

2c. Zatrzymanie:  Ctrl+Z  - lub z klienta wyłączamy image
lub
docker container stop [id]


===============================================================================
Bykowski
2.  https://www.youtube.com/watch?v=cqIu1h8FkMw&list=PLUtcRmGoaP24JStlolGq1wqjCC0YbMHKC

w cmd:

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\01-hello-world-rest-api>docker build -f Dockerfile -t stream:v2 .
[+] Building 4.3s (7/7) FINISHED
 => [internal] load build definition from Dockerfile                                                                                                                0.7s
 => => transferring dockerfile: 156B                                                                                                                                0.0s
 => [internal] load .dockerignore                                                                                                                                   0.9s
 => => transferring context: 2B                                                                                                                                     0.0s
 => [internal] load metadata for docker.io/library/openjdk:8-jdk-alpine                                                                                             0.0s
 => [internal] load build context                                                                                                                                   0.4s
 => => transferring context: 81B                                                                                                                                    0.0s
 => CACHED [1/2] FROM docker.io/library/openjdk:8-jdk-alpine                                                                                                        0.0s
 => [2/2] ADD target/hello-world-rest-api.jar .                                                                                                                     1.5s
 => exporting to image                                                                                                                                              0.8s
 => => exporting layers                                                                                                                                             0.5s
 => => writing image sha256:c959efd40db91f9f2cac4ccd40eac543ee595f8af0486ca27c9bd36a19c63210                                                                        0.1s
 => => naming to docker.io/library/stream:v2                                                                                                                        0.1s

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\01-hello-world-rest-api>docker images
REPOSITORY                      TAG              IMAGE ID       CREATED          SIZE
stream                          v2               c959efd40db9   2 minutes ago    122MB
helloworld                      latest           bc88cec09f98   22 minutes ago   122MB
01-hello-world-rest-api         0.0.1-SNAPSHOT   f60a46f853da   47 minutes ago   147MB
<none>                          <none>           139d0c9a9efe   51 minutes ago   147MB
ubuntu                          latest           df5de72bdb3b   3 weeks ago      77.8MB
grafana/grafana                 latest           c4b778290339   2 months ago     292MB
prom/prometheus                 latest           0c33456baaaa   2 months ago     211MB
<none>                          <none>           ccf9f10bc4a9   3 months ago     147MB
<none>                          <none>           e0eae122aa83   3 months ago     147MB
j4sysiak/hello-world-rest-api   dockerfile1      acfc108c7b3e   3 months ago     122MB
<none>                          <none>           dd8960418ca8   3 months ago     122MB
j4sysiak/hello-world-rest-api   0.0.1-SNAPSHOT   bebb537d4e70   3 months ago     122MB
<none>                          <none>           18ea67d1665f   3 months ago     122MB
<none>                          <none>           e3f4ddf615a2   3 months ago     122MB
<none>                          <none>           ac576d8ec56f   3 months ago     122MB
j4sysiak/hello-world-rest-api   manual2          2b89973d5761   3 months ago     122MB
j4sysiak/hello-world-rest-api   manual1          404033c6e81a   3 months ago     122MB
nginx                           latest           de2543b9436b   3 months ago     142MB
hello-world                     latest           feb5d9fea6a5   11 months ago    13.3kB
openjdk                         8-jdk-alpine     a3562aa0b991   3 years ago      105MB




C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\01-hello-world-rest-api>docker run -p 8000:8080 c959efd40db9
2022-08-28 15:37:13.929 DEBUG 1 --- [main] .c.l.ClasspathLoggingApplicationListener : Application started with classpath:
/.../
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.7.RELEASE)
/.../
2022-08-28 15:37:20.213  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-08-28 15:37:20.224  INFO 1 --- [           main] c.i.r.w.r.RestfulWebServicesApplication  : Started RestfulWebServicesApplication in 7.367 seconds (JVM running for 8.29)

#docker container ls
CONTAINER ID   IMAGE                                   COMMAND                  CREATED       STATUS         PORTS                    NAMES
3820647876f5   j4sysiak/hello-world-rest-api:manual2   "java -jar /tmp/hell…"   3 hours ago   Up 4 minutes   0.0.0.0:8080->8080/tcp   naughty_hugle

odpalenie:
http://localhost:8000/hello-world
===============================================================================
3. uruchomienie przy pomocy pliku Dockerfile:

dodajemy plik Dockerfile:
EXPOSE 8000
ADD target/hello-world-rest-api.jar hello-world-rest-api.jar
ENTRYPOINT ["sh", "-c", "java -jar /hello-world-rest-api.jar"]

#mvn clean package

tworzymy image z pliku Dockerfile:
Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/01-hello-world-rest-api (master)
$ docker build -t j4sysiak/hello-world-rest-api:dockerfile1 .
/.../
#7 DONE 0.4s

sprawdzamy:  (na tym etapie ten image manual nie będzie diałać)
#docker container ls
CONTAINER ID   IMAGE                                   COMMAND                  CREATED       STATUS         PORTS                    NAMES
3820647876f5   j4sysiak/hello-world-rest-api:manual2   "java -jar /tmp/hell…"   3 hours ago   Up 4 minutes   0.0.0.0:8080->8080/tcp   naughty_hugle
b9073c13a00e   openjdk:8-jdk-alpine                    "/bin/sh"                4 hours ago   Up 4 hours                              intelligent_zhukovsky

jeżeli jakiś chodzi kontener to go zatrzymujemy


#docker container stop 3820647876f5
#docker container stop b9073c13a00e

$ docker container ls
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES


uruchamiamy image:
docker run -p 8000:8080 j4sysiak/hello-world-rest-api:dockerfile1

4. robimy jakąś modyfikację w kodzie aplikacji
i potem:
#mvn clean package

-- zatrzymuje jakieś chodzące kontenery:
docker container ls

patrzę na historię:
docker history j4sysiak/hello-world-rest-api:dockerfile1

IMAGE          CREATED          CREATED BY                                      SIZE      COMMENT
ac576d8ec56f   18 minutes ago   ENTRYPOINT ["sh" "-c" "java -jar /hello-worl…   0B        buildkit.dockerfile.v0
<missing>      18 minutes ago   ADD target/hello-world-rest-api.jar hello-wo…   16.8MB    buildkit.dockerfile.v0
<missing>      18 minutes ago   EXPOSE map[8080/tcp:{}]                         0B        buildkit.dockerfile.v0
<missing>      3 years ago      /bin/sh -c set -x  && apk add --no-cache   o…   99.3MB
<missing>      3 years ago      /bin/sh -c #(nop)  ENV JAVA_ALPINE_VERSION=8…   0B
<missing>      3 years ago      /bin/sh -c #(nop)  ENV JAVA_VERSION=8u212       0B
<missing>      3 years ago      /bin/sh -c #(nop)  ENV PATH=/usr/local/sbin:…   0B
<missing>      3 years ago      /bin/sh -c #(nop)  ENV JAVA_HOME=/usr/lib/jv…   0B
<missing>      3 years ago      /bin/sh -c {   echo '#!/bin/sh';   echo 'set…   87B
<missing>      3 years ago      /bin/sh -c #(nop)  ENV LANG=C.UTF-8             0B
<missing>      3 years ago      /bin/sh -c #(nop)  CMD ["/bin/sh"]              0B
<missing>      3 years ago      /bin/sh -c #(nop) ADD file:a86aea1f3a7d68f6a…   5.53MB


robię ponownie builda z dockerfile1:
docker build -t j4sysiak/hello-world-rest-api:dockerfile1 .

uruchamiamy image:
docker run -p 8000:8080 j4sysiak/hello-world-rest-api:dockerfile1

-- zatrzymuje jakieś chodzące kontenery:
docker container ls


#docker container stop 125fa475ea22

=================================================================================
4. Taki automat - korzystamy z pluginu:
- From Spotify
- https://github.com/spotify/dockerfile-maven

wystarczy zrobić zmianę w kodzie i potem:  (tworzy się image i robi się build)
#mvn clean package

-- zatrzymuje jakieś chodzące kontenery:
docker container ls
#docker container stop 5536ded19e26

teraz wystarczy tylko uruchomić image
#docker run -p 8081:8080 j4sysiak/hello-world-rest-api:0.0.1-SNAPSHOT

docker container ls
CONTAINER ID   IMAGE                                          COMMAND                  CREATED          STATUS          PORTS                              NAMES
d93cd7e6eb13   j4sysiak/hello-world-rest-api:0.0.1-SNAPSHOT   "sh -c 'java -jar /a…"   28 seconds ago   Up 25 seconds   8081/tcp, 0.0.0.0:8081->8080/tcp   vigorous_kepler



=============================================================================
5. Lepszy automatically  - cache całą aplikację

dodajemy do pom.xml

### Maven Dependency Plugin


<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-dependency-plugin</artifactId>
	<executions>
		<execution>
			<id>unpack</id>
			<phase>package</phase>
			<goals>
				<goal>unpack</goal>
			</goals>
			<configuration>
				<artifactItems>
					<artifactItem>
						<groupId>${project.groupId}</groupId>
						<artifactId>${project.artifactId}</artifactId>
						<version>${project.version}</version>
					</artifactItem>
				</artifactItems>
			</configuration>
		</execution>
	</executions>
</plugin>



podmieniamy dockerfile:

```
FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.in28minutes.rest.webservices.restfulwebservices.RestfulWebServicesApplication"]
```

wystarczy zrobić zmianę w kodzie i potem:  (tworzy się image i robi się build)
#mvn clean package

-- zatrzymuje jakieś chodzące kontenery:
docker container ls
#docker container stop 4769737cd53b

robię ponownie builda z dockerfile1:
docker build -t j4sysiak/hello-world-rest-api:dockerfile1 .

uruchamiamy image:
docker run -p 8080:8080 j4sysiak/hello-world-rest-api:dockerfile1


=====================================
6. JIB

usuwam plik Dockfile
dodaje do POM

			<plugin>
				<groupId>com.google.cloud.tools</groupId>
				<artifactId>jib-maven-plugin</artifactId>
				<version>1.6.1</version>
				<configuration>
					<container>
						<creationTime>USE_CURRENT_TIMESTAMP</creationTime>
					</container>
				</configuration>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>dockerBuild</goal>
						</goals>
					</execution>
				</executions>
			</plugin>


wystarczy zrobić zmianę w kodzie i potem:  (tworzy się image i robi się build)
#mvn clean package

Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/01-hello-world-rest-api (master)
$ docker images
REPOSITORY                      TAG              IMAGE ID       CREATED          SIZE
01-hello-world-rest-api         0.0.1-SNAPSHOT   ccf9f10bc4a9   7 minutes ago    147MB


patrzę na historię:
docker history 01-hello-world-rest-api:0.0.1-SNAPSHOT

IMAGE          CREATED         CREATED BY               SIZE      COMMENT
ccf9f10bc4a9   8 minutes ago   jib-maven-plugin:1.6.1   3.31kB    classes
<missing>      8 minutes ago   jib-maven-plugin:1.6.1   43B       resources
<missing>      8 minutes ago   jib-maven-plugin:1.6.1   16.9MB    dependencies


-- zatrzymuje jakieś chodzące kontenery:
docker container ls
#docker container stop 4769737cd53b

uruchamiamy image:
#docker run -p 8080:8080 01-hello-world-rest-api:0.0.1-SNAPSHOT


====================================================================
7. Using  Using XML Configuration: io.fabric8/docker-maven-plugin


<!-- To build the image - "mvn clean package" -->
<!-- TAG - 01-hello-world-rest-api:latest -->
<!-- docker run -p 8080:8080 01-hello-world-rest-api:latest -->
<plugin>
   <groupId>io.fabric8</groupId>
   <artifactId>docker-maven-plugin</artifactId>
   <version>0.26.0</version>
   <extensions>true</extensions>
   <configuration>
      <verbose>true</verbose>
      <images>
         <image>
            <name>${project.artifactId}</name>
            <build>
               <from>java:8-jdk-alpine</from>
               <entryPoint>
                  <exec>
                     <args>java</args>
                     <args>-jar</args>
                     <args>/maven/${project.build.finalName}.jar</args>
                  </exec>
               </entryPoint>
               <assembly>
                  <descriptorRef>artifact</descriptorRef>
               </assembly>
            </build>
         </image>
      </images>
   </configuration>
   <executions>
	<execution>
		<id>docker-build</id>
		<phase>package</phase>
		<goals>
			<goal>build</goal>
		</goals>
	</execution>
   </executions>
</plugin>
