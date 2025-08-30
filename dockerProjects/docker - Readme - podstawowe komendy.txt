https://docs.docker.com/engine/reference/commandline/docker/

$ docker ps -a shows all containers (the ones that are running and the stopped ones), so that is the reason you are not seeing your stopped container listed.

ubicie procesu dockera:
root@BERLIN:/var/log# ps -ef | grep docker
root      3131  3038  0 11:23 ?        00:00:22 /usr/bin/dockerd -p /var/run/docker.pid
root      3141  3131  0 11:23 ?        00:00:11 containerd --config /var/run/docker/containerd/containerd.toml --log-level info
root      5339  3053  0 15:13 pts/0    00:00:00 grep --color=auto docker
root@BERLIN:/var/log# kill -9 3131
root@BERLIN:/var/log# ps -ef | grep docker
root      5341  3053  0 15:20 pts/0    00:00:00 grep --color=auto docker

wystartowanie dockera:
$ dockerd

jacek@BERLIN:~$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
jacek@BERLIN:~$ docker images
REPOSITORY    TAG       IMAGE ID       CREATED         SIZE
hello-world   latest    feb5d9fea6a5   13 months ago   13.3kB
jacek@BERLIN:~$


https://www.youtube.com/watch?v=2sBIT3dOTuw
sudo apt-get update
sudo apt-get install docker -y
sudo apt-get install docker-compose -y
sudo usermod -aG docker $USER
sudo vi docker-compose.yml

version: "3"
services:
  nexus:
    image: sonatype/nexus3
	restart: always
	volumes:
	  - "nexus-data;/sonatype-work"
	ports:
      - "8081:8081"

volumes:
   nexus-data: {}
   
   
   
sudo docker-compose up -d
sudo docker-compose logs --follow

około 5 min:

nexus_1  | 2022-11-12 19:35:01,694+0000 INFO  [jetty-main-1] *SYSTEM org.sonatype.nexus.bootstrap.jetty.JettyServer -
nexus_1  | -------------------------------------------------
nexus_1  |
nexus_1  | Started Sonatype Nexus OSS 3.43.0-01
nexus_1  |
nexus_1  | -------------------------------------------------

odpalenie:  localhost:8081

our admin user password is located in /nexus-data/admin.password on the server.
   
sudo docker exec -it jacek_nexus_1 bash
cat /nexus-data/admin.password
ed61c282-6a6f-438c-b7f5-0c3ecc5fb748bash-4.4$
 
 
 lub sudo docker exec -it jacek_nexus_1 cat /nexus-data/admin.password
ed61c282-6a6f-438c-b7f5-0c3ecc5fb748bash-4.4$

hasło zmienione na: admin

====================================================================================================

fajne szkolenia oparte na Gradle: https://www.youtube.com/watch?v=hc3sw-njQuA&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=2


===================================https://labs.play-with-docker.com=====================================================
https://www.youtube.com/watch?v=eIu3ZkNhGy4&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=26

$ docker run -it -p 8080:80 -d nginx:latest

$ docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED         STATUS         PORTS                  NAMES
9ffcb7c2e095   nginx     "/docker-entrypoint.…"   6 seconds ago   Up 5 seconds   0.0.0.0:8081->80/tcp   relaxed_swartz

$ docker container start [id]
$ docker container stop [id]
$ docker rm $(docker ps -aq)            lub       $ docker run --rm nginx

$ docker ps -a
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

docker exec -it [id]
docker attach [id]

[node2] (local) root@192.168.0.27 ~
$ docker exec -it 04c bash

 
[node2] (local) root@192.168.0.27 ~
$ docker exec -it 04c bash
root@04c0e5df89cd:/# bash
root@04c0e5df89cd:/#  


tworzymy plik Dockerfile

FROM alpine
WORKDIR /my_application
RUN touch myfile.txt ; \
touch otherfile.txt
COPY echo_hello_once.sh myapp.sh
RUN chmod 777 *
ENTRYPOINT [ "sh", "-c", "/my_application/myapp.sh"

uruchamiamy build z pliku Dockerfile
$ docker build . -t mikes-demo:firstversion


$ docker images
REPOSITORY   TAG            IMAGE ID       CREATED          SIZE
mikes-demo   firstversion   408753ce86e4   12 minutes ago   5.54MB
nginx        latest         51086ed63d8c   8 days ago       142MB
alpine       latest         9c6f07244728   2 months ago     5.54MB

uruchamiamy kontener:
$ docker run -it mikes-demo3:latest
  _   _      _ _        __        __         _     _ 
 | | | | ___| | | ___   \ \      / /__  _ __| | __| |
 | |_| |/ _ \ | |/ _ \   \ \ /\ / / _ \| '__| |/ _` |
 |  _  |  __/ | | (_) |   \ V  V / (_) | |  | | (_| |
 |_| |_|\___|_|_|\___/     \_/\_/ \___/|_|  |_|\__,_|



===================================================================================================================================

https://www.youtube.com/watch?v=uhqfzkgTxAo&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=10

https://github.com/ekim197711/springboot-docker-sdkman/blob/master/apprun.sh

ścieśka:
C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-docker-sdk-install-on-ubuntu>

$ docker rmi $(docker images -q)
$ docker build .

$ docker images
REPOSITORY   TAG       IMAGE ID       CREATED          SIZE
<none>       <none>    0bcccc1d1e4c   29 seconds ago   942MB


$ docker build -t mysdkman:latest .

$ docker images
REPOSITORY   TAG       IMAGE ID       CREATED         SIZE
mysdkman     latest    0bcccc1d1e4c   2 minutes ago   942MB


$ docker run -it --rm mysdkman:latest

$ docker run -it --rm mysdkman:latest
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



lub uruchamianie z cmd:

root@e2741a2f8de2:/# ls -ls
total 17292
    4 -rwxrwx---   1 root root      111 Sep 18 18:18 apprun.sh     <---------------  to ciekawe
    4 drwxr-xr-x   1 root root     4096 Sep 18 16:20 bin
    4 drwxr-xr-x   2 root root     4096 Apr 24  2018 boot
    0 drwxr-xr-x   5 root root      360 Sep 18 18:46 dev
    4 drwxr-xr-x   1 root root     4096 Sep 18 18:46 etc
    4 drwxr-xr-x   2 root root     4096 Apr 24  2018 home
    8 drwxr-xr-x   1 root root     4096 May 23  2017 lib
    4 drwxr-xr-x   2 root root     4096 Sep  2 08:52 lib64
    4 drwxr-xr-x   2 root root     4096 Sep  2 08:51 media
    4 drwxr-xr-x   2 root root     4096 Sep  2 08:51 mnt
17204 -rwxr-xr-x   1 root root 17613791 Sep 18 18:43 myapp.jar      <---------------  to ciekawe
    4 drwxr-xr-x   2 root root     4096 Sep  2 08:51 opt
    0 dr-xr-xr-x 209 root root        0 Sep 18 18:46 proc
    8 drwx------   1 root root     4096 Sep 18 16:25 root
    4 drwxr-xr-x   5 root root     4096 Sep  2 08:52 run
    4 drwxr-xr-x   2 root root     4096 Sep  2 08:52 sbin
    4 drwxr-xr-x   2 root root     4096 Sep  2 08:51 srv
    0 dr-xr-xr-x  11 root root        0 Sep 18 18:46 sys
    8 drwxrwxrwt   1 root root     4096 Sep 18 18:47 tmp
    8 drwxr-xr-x   1 root root     4096 Sep  2 08:51 usr
    8 drwxr-xr-x   1 root root     4096 Sep  2 08:52 var


$ chmod 777 apprun.sh
$ ./apprun.sh



$ docker ps

CONTAINER ID   IMAGE             COMMAND                  CREATED              STATUS              PORTS     NAMES
e2741a2f8de2   mysdkman:latest   "/bin/bash /apprun.sh"   About a minute ago   Up About a minute             modest_heisenberg




==============================================================================================================================    

https://www.youtube.com/watch?v=OSM8aw8G1kk
instalacja i uruchomienie Ubuntu

C:\Users\Jacek>docker pull ubuntu
Using default tag: latest
latest: Pulling from library/ubuntu
2b55860d4c66: Pull complete
Digest: sha256:20fa2d7bb4de7723f542be5923b06c4d704370f0390e4ae9e1c833c8785644c1
Status: Downloaded newer image for ubuntu:latest
docker.io/library/ubuntu:latest

C:\Users\Jacek>docker images
REPOSITORY   TAG       IMAGE ID       CREATED       SIZE
ubuntu       latest    2dc39ba059dc   11 days ago   77.8MB

C:\Users\Jacek>docker run -it 2dc39ba059dc /bin/sh
# ls
bin  boot  dev  etc  home  lib  lib32  lib64  libx32  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var
# bash
root@9b664debe444:/# apt-get update   <-----------------  najpierw to , a dopiero pozostałe.
root@9b664debe444:/# apt-get install iputils-ping
root@9b664debe444:/# apt-get install vim -y
root@9b664debe444:/# apt install curl
root@9b664debe444:/# apt install unzip zip
root@9b664debe444:/# curl -s https://get.sdkman.io | bash            ---------> java sdk
root@9b664debe444:/# apt-get install mysql-server

root@9b664debe444:/# apt-get install docker.io
root@9b664debe444:/# service docker start
root@9b664debe444:/# docker version
root@9b664debe444:/# docker images
root@9b664debe444:/# docker pull alpine
root@9b664debe444:/# docker images

root@9b664debe444:/# docker run -it alpine
/ # ps -ef
PID   USER     TIME  COMMAND
    1 root      0:00 /bin/sh
    7 root      0:00 ps -ef


============================NGINX=======================================
https://www.youtube.com/watch?v=9y0EEwEnMfU
instalacja i uruchomienie nginx 

#docker pull nginx

#docker run -p 8081:80 -d nginx

odpalamy: curl --head "http://localhost:8081"
HTTP/1.1 200 OK
Server: nginx/1.23.1
Date: Thu, 15 Sep 2022 06:26:00 GMT
Content-Type: text/html
Content-Length: 615
Last-Modified: Tue, 19 Jul 2022 14:05:27 GMT
Connection: keep-alive
ETag: "62d6ba27-267"
Accept-Ranges: bytes


#docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED              STATUS              PORTS                  NAMES
1a70cc1ec9bb   nginx     "/docker-entrypoint.…"   About a minute ago   Up About a minute   0.0.0.0:8081->80/tcp   kind_stonebraker

#docker exec -it 1a70cc /bin/sh

root@1a70cc1ec9bb:/etc/nginx/conf.d# nginx -t
nginx: the configuration file /etc/nginx/nginx.conf syntax is ok
nginx: configuration file /etc/nginx/nginx.conf test is successful
root@1a70cc1ec9bb:/etc/nginx/conf.d# cat /etc/nginx/nginx.conf

/.../

include /etc/nginx/conf.d/*.conf;                 <-------------------   tutaj jest konfiguracja NGINX

root@1a70cc1ec9bb:/etc/nginx/conf.d# vi /etc/nginx/conf.d/default.conf   (a w osobnej instancji NGINX na Ubuntu:  )
lokacja index.html w pliku default.conf

 location / {
        root   /usr/share/nginx/html;
        index  index.html index.htm;
    
	
	
	idziemy do pliku index.htm
	
	
root@1a70cc1ec9bb:/etc/nginx/conf.d#cd /usr/share/nginx/html


root@1a70cc1ec9bb:/etc/nginx/conf.d# cd /usr/share/nginx/html
root@1a70cc1ec9bb:/usr/share/nginx/html# ls
50x.html  index.html
root@1a70cc1ec9bb:/usr/share/nginx/html# cat index.html
<!DOCTYPE html>
<html>
/.../
</body>
</html>


root@9b664debe444:/etc/nginx/sites-available# service nginx status
 * nginx is not running
root@9b664debe444:/etc/nginx/sites-available# service nginx start
 * Starting nginx nginx
 

podmieniamy treść w index.html:

root@1a70cc1ec9bb:/usr/share/nginx/html# echo "xxxxxxxxxxxxxxxxxxxxxxxxxx" > index.html

odpalamy:  http://localhost:8081/
i widzimy: xxxxxxxxxxxxxxxxxxxxxxxxxx




location / {
      #  root   /usr/share/nginx/html;
      #  index  index.html index.htm;
         proxy_pass http://localhost:8081;
         proxy_set_header  X-Real-IP $remote_addr;
         proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
         proxy_set_header  Host $http_host;
    }


================================================================




https://bykowski.pl/docker-lista-komand-twoja-podreczna-sciaga/

Kontenery
Użyj:

1
docker container nazwa_komendy nazwa_kontenera
komendy:

start – uruchom istniejący kontener.
run – utwórz nowy kontener i uruchom go.
ls – wyświetla listę działających kontenerów.
inspect – zobacz informacje o kontenerze.
logs – pokaż logi kontenera.
stop – zatrzymaj działanie kontenera.
kill – gwałtownie zatrzymuje główny proces w kontenerze.
rm – usuń zatrzymany kontener.
Obrazy
Użyj:

1
docker image nazwa_komendy nazwa_obrazu
komendy:

build – zbuduj obraz.
push – wrzuć obraz do zdalnego repozytorium.
history – zobacz informacje o historii obrazu.
inspect – zobacz informacje o obrazie i jego warstwach.
rm – usuń obraz.
Budowanie
Budowanie obrazu na podstawie Dockerfile znajdującym się bieżącym katalogu:

1
docker build -t myimage:1.0 .
Lista wszystkich obrazów:

1
docker image ls
Uruchamianie
Uruchomienie kontenera „web” w wersji Alpine 3.9 z wystawieniem zewnętrznego portu 5000 przy wewnętrznym porcie 80:

1
docker container run --name web -p 5000:80 alpine:3.9
Zatrzymanie uruchomionego kontenera:

1
docker container stop web
Natychmiastowe (zabicie) zatrzymanie kontenera:

1
docker container kill web
Lista sieci:

1
docker network ls
Usuwanie
Usuwanie pojedynczego obrazu:

1
docker image rm alpine:3.4
Usuwanie wszystkich kontenerów:

1
docker rm -f $(docker ps -a -q)
Usuwanie wszystkich obrazów:

1
docker rmi -f $(docker images -a -q)
Czyszczenie wszystkich wolumenów:

1
docker volume rm $(docker volume ls -q)
Czyszczenie sieci:

1
docker network rm $(docker network ls | tail -n+2 | awk '{if($2 !~ /bridge|none|host/){ print $1 }}')
Jeśli znasz interesujące komendy to podrzuć je, dla wzbogacenia bazy wiedzy 🙂

----------------------------------------------------------------

Tworzenie obrazu bazy danych mysql - Ważne przejdź to jak montujesz bazę po raz pierwszy:

#docker run -p 3307:3306 --name my-mysql -e MYSQL_ROOT_PASSWORD=Warszawa5584 -d mysql/mysql-server:8.0.30

UWAGA - odczekaj kilka minut zanim mysql server stanie na porcie 3307 w dockerze.
/.../
2022-09-14T06:22:56.091772Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
2022-09-14T06:22:56.091906Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.



podłączenie się do bazy:
#docker exec -it my-mysql /bin/bash

bash-4.4# mysql -u root -p            (lub  mysql -h localhost -P 3307 -u root -p)
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 35
Server version: 8.0.30 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> select user, host from mysql.user;
+------------------+-----------+
| user             | host      |
+------------------+-----------+
| healthchecker    | localhost |
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| root             | localhost |
+------------------+-----------+
5 rows in set (0.00 sec)


mysql> update mysql.user set host='%' where user='root';
Query OK, 1 row affected (1.18 sec)
Rows matched: 1  Changed: 1  Warnings: 0


mysql> flush privileges;
Query OK, 0 rows affected (0.46 sec)



mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| test               |
+--------------------+
5 rows in set (0.00 sec)

mysql> use test;
Database changed
mysql>

mysql> show tables in test;
Empty set (0.00 sec)

CREATE TABLE samochody(id int auto_increment, marka varchar(30), model varchar(30), rocznik int, pojemnosc float, przyspieszenie float, PRIMARY KEY(id));
INSERT INTO samochody VALUES(NULL, "Bugatti", "Veyron", 2018, 7993.0, 2.5);
INSERT INTO samochody VALUES(NULL, "Lamborghini", "Aventador", 2018, 6498.0, 2.9);
SELECT * FROM samochody;

SELECT * FROM product;


===================================================================================================
https://www.youtube.com/watch?v=PAQvxqocb6A

#docker pull mysql:latest

#docker images
REPOSITORY   TAG            IMAGE ID       CREATED       SIZE
mysql        latest         ff3b5098b416   2 days ago    447MB
openjdk      8-jdk-alpine   a3562aa0b991   3 years ago   105MB

Tworzenie container mysqldb (najpierw usuwamy, jeżeli jakiś taki jest)
#docker rm -f mysqldb
#docker run -d -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test -v "C:/tmp/01-Data/mysqldb":/var/lib/mysql mysql

UWAGA - to się łąduje pare minut, na końcu musi być coś takiego.
na koncu zawsze sprawdź, czy możesz zalogować się do bazy.   localhost:3307  login/hasło  root/root
#docker logs mysqldb
/.../
2022-09-02T11:38:44.644219Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.

budujemy aplikację na dokerze:
17:20' #docker build -t app .

#docker images
REPOSITORY   TAG            IMAGE ID       CREATED         SIZE
app          latest         88b2af70bd61   3 minutes ago   143MB
mysql        latest         ff3b5098b416   2 days ago      447MB
openjdk      8-jdk-alpine   a3562aa0b991   3 years ago     105MB

#docker rm app

tworzenie kontenera z tego image'a app (id=88b2af70bd61)
#docker run -p 9090:8080 --name app -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app

ERROR - musimy poprawić
robimy network:

usuń jeżeli jest: #docker network rm spring-net
#docker network create spring-net
e04c6df27835063cbeb336fd1f597f8505ae8d5a25c2bc13bbf1d6fba409187f


#docker network ls
NETWORK ID     NAME         DRIVER    SCOPE
d862d4bfb9e8   bridge       bridge    local
d4712a93f8b9   host         host      local
8bae8e4c0a6d   none         null      local
e04c6df27835   spring-net   bridge    local

#docker network inspect spring-net

 "Containers": {
            "3c8a7fb357b347c27489b0bf9fec2d271b31be3fd956d305cca4ba7e24911d69": {
                "Name": "mysqldb",
                "EndpointID": "3407d680b3b170249238c4b377cd9bfecac40f978e2ed89453e1994ef222ece5",
                "MacAddress": "02:42:ac:13:00:04",
                "IPv4Address": "172.19.0.4/16",
                "IPv6Address": ""
            }
        }
		

łaczymy nasz nowy network spring-net z kontenerem mysqldb:
#docker network connect spring-net mysqldb

sprawdzamy połączenie:
#docker container inspect mysqldb

                "spring-net": {
                    "IPAMConfig": {},
                    "Links": null,
                    "Aliases": [
                        "70ffedae7fa0"
                    ],
                    "NetworkID": "e04c6df27835063cbeb336fd1f597f8505ae8d5a25c2bc13bbf1d6fba409187f",
                    "EndpointID": "337bb86cdc06f209e71edccabec8fe0a3eb3800c1cd3ea1b6a637f71868541a9",
                    "Gateway": "172.18.0.1",
                    "IPAddress": "172.18.0.2",
                    "IPPrefixLen": 16,
                    "IPv6Gateway": "",
                    "GlobalIPv6Address": "",
                    "GlobalIPv6PrefixLen": 0,
                    "MacAddress": "02:42:ac:12:00:02",
                    "DriverOpts": {}
                }




#docker rm app
#docker build -t app .
#docker run -p 9090:8080 --name app --net spring-net -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app

lub trorzymy plik env
#docker run -p 9090:8080 --name app --net spring-net --env-file env app

odpalamy aplikację: http://localhost:9090/products

[
{
"id": 1,
"name": "aaaa",
"price": 11
},
{
"id": 2,
"name": "dddd",
"price": 234
},
]


tylko restarty przywracają dane


===================================================================================================
https://www.youtube.com/watch?v=PAQvxqocb6A

#docker pull mysql:latest

#docker images
REPOSITORY   TAG            IMAGE ID       CREATED       SIZE
mysql        latest         ff3b5098b416   2 days ago    447MB
openjdk      8-jdk-alpine   a3562aa0b991   3 years ago   105MB

Tworzenie container mysqldb (najpierw usuwamy, jeżeli jakiś taki jest)
#docker rm -f mysqldb
#docker run -d -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test -v "C:/tmp/01-Data/mysqldb":/var/lib/mysql mysql
UWAGA - to się łąduje pare minut, na końcu musi być coś takiego.
na koncu zawsze sprawdź, czy możesz zalogować się do bazy.   localhost:3307  login/hasło  root/root
#docker logs mysqldb
/.../
2022-09-02T11:38:44.644219Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.

budujemy aplikację na dokerze:
17:20' #docker build -t app .

#docker images
REPOSITORY   TAG            IMAGE ID       CREATED         SIZE
app          latest         88b2af70bd61   3 minutes ago   143MB
mysql        latest         ff3b5098b416   2 days ago      447MB
openjdk      8-jdk-alpine   a3562aa0b991   3 years ago     105MB

#docker rm app

tworzenie kontenera z tego image'a app (id=88b2af70bd61)
#docker run -p 9090:8080 --name app -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app

ERROR - musimy poprawić
robimy network:

usuń jeżeli jest: #docker network rm spring-net
#docker network create spring-net
e04c6df27835063cbeb336fd1f597f8505ae8d5a25c2bc13bbf1d6fba409187f


#docker network ls
NETWORK ID     NAME         DRIVER    SCOPE
d862d4bfb9e8   bridge       bridge    local
d4712a93f8b9   host         host      local
8bae8e4c0a6d   none         null      local
e04c6df27835   spring-net   bridge    local


łaczymy nasz nowy network spring-net z kontenerem mysqldb:
#docker network connect spring-net mysqldb

sprawdzamy połączenie:
#docker container inspect mysqldb

                "spring-net": {
                    "IPAMConfig": {},
                    "Links": null,
                    "Aliases": [
                        "70ffedae7fa0"
                    ],
                    "NetworkID": "e04c6df27835063cbeb336fd1f597f8505ae8d5a25c2bc13bbf1d6fba409187f",
                    "EndpointID": "337bb86cdc06f209e71edccabec8fe0a3eb3800c1cd3ea1b6a637f71868541a9",
                    "Gateway": "172.18.0.1",
                    "IPAddress": "172.18.0.2",
                    "IPPrefixLen": 16,
                    "IPv6Gateway": "",
                    "GlobalIPv6Address": "",
                    "GlobalIPv6PrefixLen": 0,
                    "MacAddress": "02:42:ac:12:00:02",
                    "DriverOpts": {}
                }




#docker rm app
#docker build -t app .
#docker run -p 9090:8080 --name app --net spring-net -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app

lub trorzymy plik env
#docker run -p 9090:8080 --name app --net spring-net --env-file env app

odpalamy aplikację: http://localhost:9090/products

[
{
"id": 1,
"name": "aaaa",
"price": 11
},
{
"id": 2,
"name": "dddd",
"price": 234
},
]

opcja zapamiętywania danych bazy po restartach:



tylko restarty przywracają dane


====================    docker-compose  ===============================
https://www.youtube.com/watch?v=-ekBqIvAGY4


aplikacja bez bazy (Spring-boot bez połączenia z bazą danych):
nie potrzebujemy na dockerze mysqldb	
docker-compose.yml:

version: '3'
services:
  springboot-app:
    container_name: spring-app
    image: springboot-app
    build: .
    ports:
      - 9090:8080
	


	  
#$ docker-compose up --build                                                                       
Building springboot-app
[+] Building 17.5s (7/7) FINISHED
 => [internal] load build definition from Dockerfile                                                                                                                                                     3.7s 
 => => transferring dockerfile: 31B                                                                                                                                                                      0.3s 
 => [internal] load .dockerignore                                                                                                                                                                        2.7s 
 => => transferring context: 2B                                                                                                                                                                          0.1s 
 => [internal] load metadata for docker.io/library/openjdk:8-jdk-alpine                                                                                                                                  0.0s 
 => [internal] load build context                                                                                                                                                                        5.3s 
 => => transferring context: 17.63MB                                                                                                                                                                     4.2s 
 => CACHED [1/2] FROM docker.io/library/openjdk:8-jdk-alpine                                                                                                                                             0.0s 
 => [2/2] ADD target/*.jar app.jar                                                                                                                                                                       3.5s 
 => exporting to image                                                                                                                                                                                   3.2s 
 => => exporting layers                                                                                                                                                                                  2.3s 
 => => writing image sha256:fa8e6ce83be1cf12aa1900c3b9fd3e912eeccc594ce2a1f514d1f1fc3c746b4e                                                                                                             0.3s 
 => => naming to docker.io/library/springboot-app                                                                                                                                                        0.2s 

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them
Creating springboot-docker-compose_springboot-app_1 ... done
Attaching to springboot-docker-compose_springboot-app_1
springboot-app_1  | 
springboot-app_1  |   .   ____          _            __ _ _
springboot-app_1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
springboot-app_1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
springboot-app_1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
springboot-app_1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
springboot-app_1  |  =========|_|==============|___/=/_/_/_/
springboot-app_1  |  :: Spring Boot ::                (v2.7.3)
springboot-app_1  |
springboot-app_1  | 2022-09-03 19:39:51.913  INFO 1 --- [           main] c.e.s.SpringbootDockerComposeApplication : Starting SpringbootDockerComposeApplication v0.0.1-SNAPSHOT using Java 1.8.0_212 on ba915
de6ad44 with PID 1 (/app.jar started by root in /)
springboot-app_1  | 2022-09-03 19:39:51.930  INFO 1 --- [           main] c.e.s.SpringbootDockerComposeApplication : No active profile set, falling back to 1 default profile: "default"
springboot-app_1  | 2022-09-03 19:39:54.788  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
springboot-app_1  | 2022-09-03 19:39:54.817  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
springboot-app_1  | 2022-09-03 19:39:54.817  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.65]
springboot-app_1  | 2022-09-03 19:39:55.017  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
springboot-app_1  | 2022-09-03 19:39:55.018  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2777 ms
springboot-app_1  | 2022-09-03 19:39:55.777  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
springboot-app_1  | 2022-09-03 19:39:55.805  INFO 1 --- [           main] c.e.s.SpringbootDockerComposeApplication : Started SpringbootDockerComposeApplication in 4.899 seconds (JVM running for 5.794)
springboot-app_1  | 2022-09-03 19:40:40.189  INFO 1 --- [nio-8080-exec-3] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
springboot-app_1  | 2022-09-03 19:40:40.189  INFO 1 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
springboot-app_1  | 2022-09-03 19:40:40.191  INFO 1 --- [nio-8080-exec-3] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms



$ docker ps
CONTAINER ID   IMAGE            COMMAND               CREATED       STATUS              PORTS                    NAMES
942b7a953643   springboot-app   "java -jar app.jar"   9 hours ago   Up About a minute   0.0.0.0:9090->8080/tcp   spring-app

 

(usuwa kontenery)
$ docker-compose down
Stopping spring-app ... done
Removing spring-app ... done
Removing network springboot-docker-compose_default

$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES


version: '3'
services:
  springboot-app:
    # container_name: spring-app
    image: springboot-app
    build: .
    ports:
      - 9000-9999:8080


#$ docker-compose up -d --scale springboot-app=5    (tworzy 5 instancji kontenerów springboot-app)

$ docker ps
CONTAINER ID   IMAGE            COMMAND               CREATED         STATUS         PORTS                    NAMES
f618f9515a6d   springboot-app   "java -jar app.jar"   2 minutes ago   Up 2 minutes   0.0.0.0:9006->8080/tcp   springboot-docker-compose_springboot-app_6
c947673302d2   springboot-app   "java -jar app.jar"   4 minutes ago   Up 3 minutes   0.0.0.0:9005->8080/tcp   springboot-docker-compose_springboot-app_5
7f9eefa92bf5   springboot-app   "java -jar app.jar"   4 minutes ago   Up 4 minutes   0.0.0.0:9004->8080/tcp   springboot-docker-compose_springboot-app_4
89ce3ed93b02   springboot-app   "java -jar app.jar"   5 minutes ago   Up 4 minutes   0.0.0.0:9003->8080/tcp   springboot-docker-compose_springboot-app_3
fd2eea3b3300   springboot-app   "java -jar app.jar"   5 minutes ago   Up 5 minutes   0.0.0.0:9002->8080/tcp   springboot-docker-compose_springboot-app_2
e1f1d3a4fb6f   springboot-app   "java -jar app.jar"   6 minutes ago   Up 5 minutes   0.0.0.0:9001->8080/tcp   springboot-docker-compose_springboot-app_1





$ docker-compose down

version: '3'
services:
  springboot-app:
    container_name: spring-app
    image: springboot-app
    build: .
    ports:
      - 9000:8080

  mysqldb:
    container_name: mysqldb
    image: mysql
    ports:
      - 3307:3306
    environment:
      MYSQL_DATABASE: test
      MYSQL_ROOT_PASSWORD: root
	  
	  
	  
#$ docker-compose up

UWAGA: musimy trochę poczekać bo baza mysqldb2 się długo może ładować

/.../
mysqldb2          | 2022-09-04T05:12:09.622664Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Socket: /var/run/mysqld/mysqlx.sock
mysqldb2          | 2022-09-04T05:12:09.623080Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 0  MySQL Community Se
rver - GPL.
mysqldb2          | 2022-09-04 05:12:09+00:00 [Note] [Entrypoint]: Temporary server started.
mysqldb2          | '/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'
mysqldb2          | 2022-09-04T05:13:30.822106Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
mysqldb2          | 2022-09-04T05:13:30.822317Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community
 Server - GPL.


- włączamy aplikację do bazy (tj. aplikacja musi korzystać z bazy)

1. dodajemy w pom.xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>


2. application-properitas:
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/test
spring.datasource.username=${MYSQL_USER:laravel}
spring.datasource.password=${MYSQL_PASSWORD:laravel}

3. to wywalamy z Environment variables w Intelij: MYSQL_USER=root;MYSQL_PASSWORD=root;MYSQL_PORT=3307

4. modyfikujemy plik yml:

version: '3'
services:
  springboot-app:
    # container_name: spring-app
    image: springboot-app
    restart: always
    build: .
    ports:
      - 9000:8080
    environment:
      MYSQL_HOST: mysqldb
      MYSQL_USER: root
      MYSQL_PASSWORD: root
      MYSQL_PORT: 3306

  mysqldb:
    container_name: mysqldb
    image: mysql
    ports:
      - 3307:3306
    environment:
      MYSQL_DATABASE: test
      MYSQL_ROOT_PASSWORD: root


	  
	  
4. usuwamy kontener spring-app, od nowa budujemy kontener:
#$ docker-compose down
#$ docker-compose up


i UWAGA, po to daliśmy w ymlu taga: restart, żeby spring-app ciągle się restartował, aż wstanie baza:

2022-09-04T05:58:13.067019Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
2022-09-04T05:58:13.067179Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.

i teraz dopiero spring-app wstanie:

springboot-app_1  | 2022-09-04 05:58:22.525  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
springboot-app_1  | 2022-09-04 05:58:22.547  INFO 1 --- [           main] c.e.s.SpringbootDockerComposeApplication : Started SpringbootDockerComposeApplication in 8.264 seconds (JVM running for 9.945)



tworzy się baza: test   pod 3307
można odpalić aplikację localhost:9000


dodajemy klasę Product do Springa
#$ docker-compose up --build 

po kilku minutach (restarty):

$ docker ps
CONTAINER ID   IMAGE            COMMAND                  CREATED          STATUS          PORTS                               NAMES
666103878f66   springboot-app   "java -jar app.jar"      12 minutes ago   Up 5 minutes    0.0.0.0:9000->8080/tcp              springboot-docker-compose_springboot-app_1
3f512b450471   mysql            "docker-entrypoint.s…"   12 minutes ago   Up 12 minutes   33060/tcp, 0.0.0.0:3307->3306/tcp   mysqldb


powstanie baza test i tabela Product

select * from test.product;


#$ docker-compose down
#$ docker-compose up -d

lub
 
#$ docker-compose restart






===================================================================================================



https://www.youtube.com/watch?v=zLgFYXMrXjQ  50:15''
docker run -p 9090:9090 prom/prometheus
docker run -p 3000:3000 grafana/grafana


uruchamiaj w gitBasza:  w lokalizacji projektu: ~/Documents/JAVA/SpringBoot/dockerProjects/01-hello-world-rest-api (master)
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

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\01-hello-world-rest-api>docker build -f Dockerfile -t stream:v1 .
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



C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\01-hello-world-rest-api>docker container ls
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS                              NAMES
542ebc35bd77   c959efd40db9   "/bin/sh -c 'java -j…"   5 minutes ago   Up 5 minutes   8000/tcp, 0.0.0.0:8000->8080/tcp   thirsty_mccarthy



odpalenie:
http://localhost:8000/hello-world

=================================================================================
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

    możemy też uruchomić:  docker run -p j4sysiak/hello-world-rest-api:dockerfile1
 

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
docker run -p 8080:8080 j4sysiak/hello-world-rest-api:dockerfile1

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
docker run -p 8080:8080 j4sysiak/hello-world-rest-api:dockerfile1

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
7. Using Dockerfile Mavin plugin.





===================================  docker compose =================
https://www.youtube.com/watch?v=6c4-XJkDqC0&t=987s

konfiguracja w pliku: docker-compose.yml

version: '3'
services:
  api:
    build: ./demo8
    ports:
    - "9091:9091"
  database:
   container_name: 'database'
   image: mysql
   environment:
     MYSQL_ROOT_PASSWORD: Warszawa5584
     MYSQL_PASSWORD: jacek
     MYSQL_DATABASE: animalsdb
     MYSQL_USER: jacek
   ports:
   - "3307:3306"


--------

#docker-compose up
   
   
   