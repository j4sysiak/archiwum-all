How to Dockerize apps such as phpMyAdmin with MySQL database.

https://www.youtube.com/watch?v=DjoWDN2BUCg



version: '3.1'
services:
  #service 1: definition of mysql
  db:
    image: mysql
    container_name: mysql-db2
    restart: always
    environment:
          MYSQL_ROOT_PASSWORD: root
          MYSQL_DATABASE: easyeat
    ports:
      - "3307:3306"
    volumes:
      - C:/tmp/02-Data/MySQLData/mysql-db2:/var/lib/mysql

#$ docker-compose up --build

czekamy ....
2022-09-04T10:01:43.606742Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
2022-09-04T10:01:43.608433Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.30'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL

teraz możemy odpalić bazę easyeat na localhost::3307


dorzucamy myphpAdmina:

version: '3.1'
services:
  #service 1: definition of mysql
  db:
    image: mysql
    container_name: mysql-db2
    restart: always
    environment:
          MYSQL_ROOT_PASSWORD: root
          MYSQL_DATABASE: easyeat
    ports:
      - "3307:3306"
    volumes:
      - C:/tmp/02-Data/MySQLData/mysql-db2:/var/lib/mysql

#service 2: definition of phpMyAdmin
  phpmyadmin:
        image: phpmyadmin/phpmyadmin:latest
        container_name: my-php-myadmin
        ports:
              - "8082:80"
        restart: always

        depends_on:
              - db
        environment:
              SPRING_DATASOURCE_USERNAME: root
              SPRING_DATASOURCE_PASSWORD: root



C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\demo10>docker network ls
NETWORK ID     NAME             DRIVER    SCOPE
e0efcaae032b   bridge           bridge    local
f8fc6ce422f7   demo10_default   bridge    local
d4712a93f8b9   host             host      local
8bae8e4c0a6d   none             null      local

#$ docker-compose down

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\demo10>docker network ls   
NETWORK ID     NAME      DRIVER    SCOPE
e0efcaae032b   bridge    bridge    local
d4712a93f8b9   host      host      local
8bae8e4c0a6d   none      null      local


#$ docker-compose up

odpalamy myphpAdmina:
localhost:8082    root/root

CREATE TABLE samochody(id int auto_increment, marka varchar(30), model varchar(30), rocznik int, pojemnosc float, przyspieszenie float, PRIMARY KEY(id));
INSERT INTO samochody VALUES(NULL, "Bugatti", "Veyron", 2018, 7993.0, 2.5);
INSERT INTO samochody VALUES(NULL, "Lamborghini", "Aventador", 2018, 6498.0, 2.9);
SELECT * FROM `samochody` WHERE 1;

id	marka	model	rocznik	pojemnosc	przyspieszenie	
1	Bugatti	Veyron	2018	7993	2.5	
2	Lamborghini	Aventador	2018	6498	2.9	

SELECT count(*) FROM samochody; 
------
2



#$ docker-compose down

C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\demo10>docker network ls   
NETWORK ID     NAME      DRIVER    SCOPE
e0efcaae032b   bridge    bridge    local
d4712a93f8b9   host      host      local
8bae8e4c0a6d   none      null      local

#$ docker-compose up

SELECT * FROM `samochody` WHERE 1;

id	marka	model	rocznik	pojemnosc	przyspieszenie	
1	Bugatti	Veyron	2018	7993	2.5	
2	Lamborghini	Aventador	2018	6498	2.9	

SELECT count(*) FROM samochody;  - nie tracimy wartości z bazy danych
------
2

 

===================================================
https://www.youtube.com/watch?v=329YT1wPyOo&t=1246s



























