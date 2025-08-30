https://www.youtube.com/watch?v=1xpgfwA5l3Q&t=188s


# $docker-compose up
UWAGA: odczekaj kilka minut zanom mysql wstanie ...
2022-09-06T05:59:57.525422Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.
2022-09-06T05:59:57.530146Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock

... i dopiero później odpali się Springboot:c  (ale musibyć w pliku docker-compose.yml zapis:  restart)

easy-eat-service-app | 2022-09-06 06:00:13.145  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be perf
ormed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
easy-eat-service-app | 2022-09-06 06:00:15.890  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
easy-eat-service-app | 2022-09-06 06:00:15.914  INFO 1 --- [           main] com.example.demo11.Demo11Application     : Started Demo11Application in 20.97 seconds (JVM running for 21.945)



Jacek@BERLIN MINGW64 /C/Users/Jacek/Documents/JAVA/SpringBoot/dockerProjects/demo11 (master)
$ docker network ls
NETWORK ID     NAME             DRIVER    SCOPE
38962cd6d517   bridge           bridge    local
1f67be9ad98c   demo11_default   bridge    local
45c68d37f9dd   host             host      local
77e5b7df2312   none             null      local

Jacek@BERLIN MINGW64 /C/Users/Jacek/Documents/JAVA/SpringBoot/dockerProjects/demo11 (master)
$ docker network inspect demo11_default

 "Containers": {
            "3c8a7fb357b347c27489b0bf9fec2d271b31be3fd956d305cca4ba7e24911d69": {
                "Name": "mysql-db4",
                "EndpointID": "3407d680b3b170249238c4b377cd9bfecac40f978e2ed89453e1994ef222ece5",
                "MacAddress": "02:42:ac:13:00:04",
                "IPv4Address": "172.19.0.4/16",
                "IPv6Address": ""
            },
            "c1aaa27f6fa64b2617158d389cbae184379c262cc31c83bbd3ff39708da13212": {
                "Name": "my-php-myadmin",
                "EndpointID": "5abeaccc46ff3a7a2992b34d267236f588c59a2c3ec73d7cfc231a22cabdcdeb",
                "MacAddress": "02:42:ac:13:00:03",
                "IPv4Address": "172.19.0.3/16",
                "IPv6Address": ""
            },
            "cc65fb26eedf3463821b9091c50d1ec1166f004441b15e10d6edae2cbd959ac1": {
                "Name": "backend-service-app",
                "EndpointID": "b6bc0fc5cee69d6f04d28522b0a626e52339d72747e3cfa5e04acb3df0a1b345",
                "MacAddress": "02:42:ac:13:00:02",
                "IPv4Address": "172.19.0.2/16",
                "IPv6Address": ""
            }
        },
