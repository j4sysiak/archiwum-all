https://www.youtube.com/watch?v=6c4-XJkDqC0&t=987s

Warunki wstępne (muszą być dwa obrazy: openjdk i mysql):
#docker images

REPOSITORY              TAG            IMAGE ID       CREATED        SIZE
mysql                   latest         ff3b5098b416   8 days ago     447MB
openjdk                 8-jdk-alpine   a3562aa0b991   3 years ago    105MB


1. ---  odpalenie z Dockerfile ---
#docker build -t api .
#docker run -p 10101:10101 --name api api

/.../
2022-09-06 17:21:04.944  INFO 1 --- [nio-9090-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-09-06 17:21:04.946  INFO 1 --- [nio-9090-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms

http://localhost:10101/animals

2. ---  odpalenie z pliku docker-compos.yml ---
cd C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>
#docker-compose up
... czekamy klika minut na uruchomienie mysql
/.../
2022-09-06 17:21:04.944  INFO 1 --- [nio-9090-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-09-06 17:21:04.946  INFO 1 --- [nio-9090-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network ls
NETWORK ID     NAME                            DRIVER    SCOPE
922b316ab58e   bridge                          bridge    local
45c68d37f9dd   host                            host      local
77e5b7df2312   none                            null      local
408252bfed92   springboot-api-docker_default   bridge    local

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network inspect springboot-api-docker_default

        "Containers": {
            "5aff958da3db427e6532010d4df89168e2513f29748c9cab49574664e7054f97": {
                "Name": "api",
                "EndpointID": "c9b207d32befb7b458627244df737a6d7410a29d470b56d5a0cbf9750209d79b",
                "MacAddress": "02:42:ac:18:00:03",
                "IPv4Address": "172.24.0.3/16",
                "IPv6Address": ""
            },




działa:  http://localhost:10101/animals

[
{
"id": 1,
"name": "Dog"
},
{
"id": 2,
"name": "Cat"
},
{
"id": 3,
"name": "Horse"
}
]



nie działa:  http://localhost:12121/showForGui



 UWAGA: jeżeli włączymy aplikację client, to ona nie będzie widziała api, bo jest w innej sieci.
 Aplikację client, trzeba wpiąć w sieć aplikacji api: springboot-api-docker_default


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network ls
NETWORK ID     NAME                               DRIVER    SCOPE
922b316ab58e   bridge                             bridge    local
45c68d37f9dd   host                               host      local
77e5b7df2312   none                               null      local
408252bfed92   springboot-api-docker_default      bridge    local
e95b8a3322d9   springboot-client-docker_default   bridge    local


C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network inspect springboot-client-docker_default

        "Containers": {
            "ccff20f22a82b836c58639b1b6956e1e0bef4afad0c8333c852898468983daeb": {
                "Name": "client",
                "EndpointID": "b25f88cbefadd5732df02c1cac13d87c6e325509699d331ab1d36a1f96659a0e",
                "MacAddress": "02:42:ac:19:00:02",
                "IPv4Address": "172.25.0.2/16",
                "IPv6Address": ""



Wpinamy kontener client (springboot-client-docker) do sieci api (springboot-api-docker_default):
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network connect springboot-api-docker_default client

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network inspect springboot-api-docker_default

        "Containers": {
            "5aff958da3db427e6532010d4df89168e2513f29748c9cab49574664e7054f97": {
                "Name": "api",
                "EndpointID": "c9b207d32befb7b458627244df737a6d7410a29d470b56d5a0cbf9750209d79b",
                "MacAddress": "02:42:ac:18:00:03",
                "IPv4Address": "172.24.0.3/16",
                "IPv6Address": ""
            },
            "a198ce08a988fa03ea14296434ba006e1d1966977df6dbb193ea6f106d8d9359": {
                "Name": "mysql-db6",
                "EndpointID": "eb5e521f850045a13822fc5a29975d59b074ca641dc6b22307fcad644a56eba4",
                "MacAddress": "02:42:ac:18:00:02",
                "IPv4Address": "172.24.0.2/16",
                "IPv6Address": ""
            },
            "ccff20f22a82b836c58639b1b6956e1e0bef4afad0c8333c852898468983daeb": {
                "Name": "client",
                "EndpointID": "4af1700d9b86e60bf7157036a6cc2186c8cb8a22614e03726c5b076c2bc98cbd",
                "MacAddress": "02:42:ac:18:00:04",
                "IPv4Address": "172.24.0.4/16",
                "IPv6Address": ""
            }
        },



Teraz aplikacja api będzie widziała aplikację client:

http://localhost:10101/animals

[
{
"id": 1,
"name": "Dog"
},
{
"id": 2,
"name": "Cat"
},
{
"id": 3,
"name": "Horse"
}
]


http://localhost:12121/showForGui

[
{
"id": 1,
"name": "Dog"
},
{
"id": 2,
"name": "Cat"
},
{
"id": 3,
"name": "Horse"
}
]







3. --- odpalenie zbiorczego pliku docker-compos.yml
cd C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\

uruchamiają się 3 services: mysql, api, client

#docker-compose up
... czekamy klika minut na uruchomienie mysql
/.../
2022-09-06 17:21:04.944  INFO 1 --- [nio-9090-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-09-06 17:21:04.946  INFO 1 --- [nio-9090-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms


http://localhost:10101/animals
http://localhost:12121/showForGui



żeby to działało  (żeby api i client gadały ze sobą), wszystkie obrazy powinny być w jednym kontenerze - a to znaczy, że są w jednej sieci.

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network ls
NETWORK ID     NAME                     DRIVER    SCOPE
922b316ab58e   bridge                   bridge    local
b056cef0d565   dockerprojects_default   bridge    local
45c68d37f9dd   host                     host      local
77e5b7df2312   none                     null      local

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-api-docker>docker network inspect dockerprojects_default

       "Containers": {
            "0dd40b62382dcea4a320038e1e23e6dedae40b914565e1b400a928106b1485ec": {
                "Name": "client",
                "EndpointID": "ca3eeede4df24f14f3f3576f0311bf8ff534809333d6db05c19e8a0af80fc484",
                "MacAddress": "02:42:ac:17:00:04",
                "IPv4Address": "172.23.0.4/16",
                "IPv6Address": ""
            },
            "729b68175ff9042e0272c7b09f5aacdc81d0308928829246cf7fd6b978145e2c": {
                "Name": "api",
                "EndpointID": "ef66371a687d4238a24072245ae1e4e1b4002a542e6aa257ad0470ea4943ee57",
                "MacAddress": "02:42:ac:17:00:03",
                "IPv4Address": "172.23.0.3/16",
                "IPv6Address": ""
            },
            "fb4a2fd08e2a80b97aad4ec05d1e7767af841c9150208e11908375638213fddc": {
                "Name": "mysql-db6",
                "EndpointID": "abcb59b494bc7a6f6706f6d8c195992a4c875bff12eabcf270d4a33573bfd707",
                "MacAddress": "02:42:ac:17:00:02",
                "IPv4Address": "172.23.0.2/16",
                "IPv6Address": ""
            }
        },
