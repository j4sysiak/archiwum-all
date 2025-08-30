Spring Boot Nginx Reverse Proxy on Localhost Development
https://www.youtube.com/watch?v=O7nfg4URAyo

https://github.com/ekim197711/springboot-nginx-localhost-development/tree/master/script



Tworzymy jara:
c:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\gradlew clean
c:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\gradlew bootJar

uruchamiamy dwie instancje (defaultową i super):
cd /bin/libs
java -jar nginx-demo1-0.0.1-SNAPSHOT.jar
java -jar -Dspring.profiles.active=super nginx-demo1-0.0.1-SNAPSHOT.jar


odpalamy:

http://localhost:8080/api/timetable
http://localhost:9080/api/timetable

uruchamiamy nginx na dockerze:
c:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\nginx-demo1\script\docker-compose up






