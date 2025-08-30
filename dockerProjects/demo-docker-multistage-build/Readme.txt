https://www.youtube.com/watch?v=wjRdq0IbWvA&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=5

https://github.com/ekim197711/docker-multistage-build

https://twitter.com/MikeMoelNielsen

======================================================================

odpalamy task buildForDocke z build.gradle  (zielona strzałka)
tworzy się folder z plikiem app.jar:
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\demo-docker-multistage-build\build\libs\docker\app.jar

budujemy z zakładki Services/Docker --> zielona strzałka w pliku Dockerfile

/.../
Step 8/8 : RUN ./gradlew buildForDocker
 ---> Running in a75443d7e7b1
Downloading https://services.gradle.org/distributions/gradle-7.5-bin.zip
...........10%............20%...........30%............40%...........50%............60%...........70%............80%...........90%............100%

Welcome to Gradle 7.5!

Here are the highlights of this release:
 - Support for Java 18
 - Support for building with Groovy 4
 - Much more responsive continuous builds
 - Improved diagnostics for dependency resolution

For more details see https://docs.gradle.org/7.5/release-notes.html

Starting a Gradle Daemon (subsequent builds will be faster)
> Task :compileJava
> Task :processResources
> Task :classes
> Task :bootJar
> Task :jar SKIPPED
> Task :assemble
> Task :compileTestJava NO-SOURCE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
> Task :test NO-SOURCE
> Task :check UP-TO-DATE
> Task :build
> Task :buildForDocker

BUILD SUCCESSFUL in 4m
4 actionable tasks: 4 executed
Removing intermediate container a75443d7e7b1
 ---> b417c500befe

Successfully built b417c500befe
Successfully tagged myapp:latest
'myapp:latest Dockerfile: Dockerfile' has been deployed successfully.


Run:  zielona strzałka w pliku Dockerfile:

Successfully built b417c500befe
Successfully tagged myapp:latest
Creating container…
Container Id: 200e8302092cf6d352b3ced3003587bef5432c12f6f3b489463fd2b4ba501746
Container name: '/fervent_banzai'
Starting container '/fervent_banzai'
'<unknown> Dockerfile: Dockerfile' has been deployed successfully.


/opt/project # ls -ltr
total 24
-rwxr-xr-x    1 root     root          8188 Sep 19 02:44 gradlew
-rwxr-xr-x    1 root     root           706 Sep 19 05:03 build.gradle
drwxr-xr-x    3 root     root          4096 Sep 20 18:45 src
drwxr-xr-x    3 root     root          4096 Sep 20 18:46 gradle
drwxr-xr-x    7 root     root          4096 Sep 20 18:50 build



:\Users\Jacek>docker images
REPOSITORY                 TAG            IMAGE ID       CREATED          SIZE
myapp                      latest         8bdab85b868d   7 minutes ago    140MB
<none>                     <none>         33b2840dc5ac   8 minutes ago    428MB
azul/zulu-openjdk-alpine   8-jre          6bf89dd63f82   57 minutes ago   123MB
openjdk                    8-jdk-alpine   a3562aa0b991   3 years ago      105MB


C:\Users\Jacek>docker run -it --rm 8bdab85b868d /bin/sh

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.7.RELEASE)

2022-09-21 05:05:06.773  INFO 1 --- [           main] e.d.DemoDockerMultistageBuildApplication : Starting DemoDockerMultistageBuildApplication on 1d2c6205814b with PID 1 (/app.jar started by root in /)
2022-09-21 05:05:06.789  INFO 1 --- [           main] e.d.DemoDockerMultistageBuildApplication : No active profile set, falling back to default profiles: default
2022-09-21 05:05:10.517  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-09-21 05:05:10.621  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-09-21 05:05:10.622  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.22]
2022-09-21 05:05:10.875  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-09-21 05:05:10.876  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 3791 ms
2022-09-21 05:05:11.395  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-09-21 05:05:11.933  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-09-21 05:05:11.949  INFO 1 --- [           main] e.d.DemoDockerMultistageBuildApplication : Started DemoDockerMultistageBuildApplication in 6.404 seconds (JVM running for 7.209)


tutaj mamy artefakty:
C:\Users\Jacek>docker run -it --rm 33b2840dc5ac /bin/sh
/opt/project # ls -ls
total 24
     4 drwxr-xr-x    7 root     root          4096 Sep 21 04:52 build
     4 -rwxr-xr-x    1 root     root           706 Sep 19 05:03 build.gradle
     4 drwxr-xr-x    3 root     root          4096 Sep 21 04:50 gradle
     8 -rwxr-xr-x    1 root     root          8188 Sep 19 02:44 gradlew
     4 drwxr-xr-x    3 root     root          4096 Sep 21 04:50 src





-----------------  odpalanie z CMD

$ docker rmi $(docker images -q)
$ docker build .

$ docker images
REPOSITORY   TAG       IMAGE ID       CREATED          SIZE
<none>       <none>    0bed05eb54e1   25 seconds ago   140

$ docker build -t myapp:latest .

$ docker images
REPOSITORY   TAG       IMAGE ID       CREATED         SIZE
myapp        latest    0bed05eb54e1   3 minutes ago   140MB

$ docker run -it --rm myapp:latest
Lets start our application
openjdk version "12.0.2" 2019-07-16
OpenJDK Runtime Environment Zulu12.3+11-CA (build 12.0.2+3)
OpenJDK 64-Bit Server VM Zulu12.3+11-CA (build 12.0.2+3, mixed mode, sharing)

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2022-09-18 18:47:02.335  INFO 49 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-09-18 18:47:02.345  INFO 49 --- [           main] gbootDockerSdkInstallOnUbuntuApplication : Started SpringbootDockerSdkInstallOnUbuntuApplication in 5.184 seconds (JVM running for 6.53)



/ # ls -ls
total 16468
 16412 -rw-r--r--    1 root     root      16805634 Sep 21 04:22 app.jar
     4 drwxr-xr-x    2 root     root          4096 Aug  9 08:58 bin
     0 drwxr-xr-x    5 root     root           360 Sep 21 04:26 dev
     4 drwxr-xr-x    1 root     root          4096 Sep 21 04:26 etc
     4 drwxr-xr-x    2 root     root          4096 Aug  9 08:58 home
     4 drwxr-xr-x    1 root     root          4096 Aug  9 08:58 lib
     4 drwxr-xr-x    5 root     root          4096 Aug  9 08:58 media
     4 drwxr-xr-x    2 root     root          4096 Aug  9 08:58 mnt
     4 drwxr-xr-x    2 root     root          4096 Aug  9 08:58 opt
     0 dr-xr-xr-x  204 root     root             0 Sep 21 04:26 proc
     4 drwx------    1 root     root          4096 Sep 21 04:28 root
     4 drwxr-xr-x    2 root     root          4096 Aug  9 08:58 run
     4 drwxr-xr-x    2 root     root          4096 Aug  9 08:58 sbin
     4 drwxr-xr-x    2 root     root          4096 Aug  9 08:58 srv
     0 dr-xr-xr-x   11 root     root             0 Sep 21 04:26 sys
     4 drwxrwxrwt    1 root     root          4096 Sep 21 04:26 tmp
     4 drwxr-xr-x    1 root     root          4096 Aug  9 08:58 usr
     4 drwxr-xr-x    1 root     root          4096 Aug  9 08:58 var



$ docker ps

CONTAINER ID   IMAGE          COMMAND                CREATED         STATUS         PORTS     NAMES
7636f59d4c1f   myapp:latest   "java -jar /app.jar"   4 minutes ago   Up 4 minutes             confident_brahmagupta



================================ just playing
$ docker images
REPOSITORY   TAG       IMAGE ID       CREATED          SIZE
myapp        latest    0bed05eb54e1   20 minutes ago   140MB


$ docker run -it --rm 0bed05eb54e1 /bin/sh


