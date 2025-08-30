https://www.youtube.com/watch?v=tVPej_vnlcc&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=6

https://github.com/ekim197711/springboot-docker-compose


C:\Users\Jacek\Documents\GitHub\springboot-docker-compose\docker-compose>docker-compose build
C:\Users\Jacek\Documents\GitHub\springboot-docker-compose\docker-compose>docker-compose up

... startują dwie instancje: commandcenter i spaceship:

docker-compose-spaceship-1      | 2022-09-18 05:41:17.437  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
docker-compose-spaceship-1      | 2022-09-18 05:41:17.460  INFO 1 --- [           main] c.c.spaceship.SpaceshipApplication       : Started SpaceshipApplication in 14.215 seconds (JVM running for 17.201)
docker-compose-commandcenter-1  | 2022-09-18 05:41:17.514  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
docker-compose-commandcenter-1  | 2022-09-18 05:41:17.544  INFO 1 --- [           main] c.c.c.CommandcenterApplication           : Started CommandcenterApplication in 14.255 seconds (JVM running for 17.285)


odpalamy:
http://localhost:8060                    to uruchamia controlera na projekcie Spaceship, a ten projekt posiada RestTemplate, który
przekierowuje na localhosta 8080, który odwołuje się na Commandcenter do coltrollera.


C:\Users\Jacek\Documents\GitHub\springboot-docker-compose\docker-compose>docker ps
CONTAINER ID   IMAGE                          COMMAND                  CREATED          STATUS         PORTS                    NAMES
759e34380183   docker-compose-commandcenter   "java -jar commandce…"   10 minutes ago   Up 9 minutes   0.0.0.0:8050->8080/tcp   docker-compose-commandcenter-1
65b632fa29b9   docker-compose-spaceship       "java -jar spaceship…"   10 minutes ago   Up 9 minutes   0.0.0.0:8060->8080/tcp   docker-compose-spaceship-1



