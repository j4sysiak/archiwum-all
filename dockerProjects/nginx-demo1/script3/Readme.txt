https://www.youtube.com/watch?v=x7nrGLJLN5U&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=1

https://github.com/palantir/gradle-docker


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1> gradle tasks
widać, że pojawił się w zakładce Gradle nowy katalog zadań:  docker z taskami gradlowymi

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1> gradle clean build
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1> gradle clean docker

jak z tego będzie błąd to odpal taski gradlowe (na to samo w sumie wyjdzie):
1. application/clean
2. application/build
3. application/bootJar

i potem:
docker/docker


powstaje plik app.jar w lokalizacji:  C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\build\docker\app.jar

C:\Users\Jacek>docker images
REPOSITORY    TAG       IMAGE ID       CREATED         SIZE
nginx-demo1   latest    f959df681326   7 minutes ago   122MB



C:\Users\Jacek>docker run -it -p 9000:8080 nginx-demo1:latest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2022-09-17 13:01:24.900  INFO 1 --- [           main] c.e.nginxdemo1.NginxDemo1Application     : Starting NginxDemo1Application on d57b0938910f with PID 1 (/app.jar started by root in /)
2022-09-17 13:01:24.907  INFO 1 --- [           main] c.e.nginxdemo1.NginxDemo1Application     : No active profile set, falling back to default profiles: default
2022-09-17 13:01:27.282  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-09-17 13:01:27.336  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-09-17 13:01:27.337  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.33]
2022-09-17 13:01:27.559  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-09-17 13:01:27.559  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2478 ms
2022-09-17 13:01:28.387  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-09-17 13:01:29.303  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-09-17 13:01:29.309  INFO 1 --- [           main] c.e.nginxdemo1.NginxDemo1Application     : Started NginxDemo1Application in 5.902 seconds (JVM running for 7.404)


odpalamy:  http://localhost:9000/api/timetable



