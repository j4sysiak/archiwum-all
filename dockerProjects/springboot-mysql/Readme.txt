Play With Docker:
- https://labs.play-with-docker.com
- Ngrok

https://www.youtube.com/watch?v=PhaBPxx8k5k&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=28

https://github.com/ekim197711/springboot-mysql/blob/main/docker/docker-compose.yml


---------------------------------------------------------------------------------------------

UWAGA:  wklejanie w terminalu play-with-docker za pomocą ctrl+SHITF+V

ctrl + insert (copy)
shitft + insert (paste)

---------------------------------------------------------------------------------------------

uruchamiamy:
https://labs.play-with-docker.com
i Start ...

------------------------------> krok 1:  dodanie pliku
$ vi docker-compose.yml

wklejamy zawartość:

version: '3.1'

services:

  db:
    image: mysql
    command: --default-authentication-plugin=mysql_native_password
    restart: always
    ports:
      - 3306:3306
    environment:
      MYSQL_ROOT_PASSWORD: test1234

  adminer:
    image: adminer
    restart: always
    ports:
      - 8080:8080


------------------------------> krok 2: uruchomienie
$ docker-compose up -d
$ docker ps
$ docker images

na stronie otwarej sesji https://labs.play-with-docker.com - klikamy na port "8080" -  otwiera się strona:
 - lob klikamy 'OPEN PORT' i wpisujemy 8080

 otwiera się strona logowania do bazy:
http://ip172-18-0-13-cd33k8n91rrg00djegrg-8080.direct.labs.play-with-docker.com


logowanie do bazy:
login: root
hasło: test1234      (takie wpisaliśmy w docker-compose.yml)
baza: db

Wersja MySQL: 8.0.31 za pomocą MySQLi
Zalogowany jako: root@172.20.0.3

niby się zalogowałem do bazy ale schematu db nie ma jeszcze.


------------------------------> krok 3: uruchomienie ngrok
https://gist.github.com/SalahHamza/799cac56b8c2cd20e6bfeb8886f18455

in case you don't have unzip installed, you can do that like this
$ sudo apt install unzip

$ wget https://bin.equinox.io/c/4VmDzA7iaHb/ngrok-stable-linux-amd64.zip
$ unzip ngrok-stable-linux-amd64.zip
$ ./ngrok version
ngrok version 2.3.40


dodajemy token (token pobieramy ze strony): https://dashboard.ngrok.com/get-started/your-authtoken
$ ./ngrok authtoken 2G0CCcJUPnOErUyrnN1aHAmRiq3_5E2ZKp6oeVSoFka5nXz1E
Authtoken saved to configuration file: /root/.ngrok2/ngrok.yml



-----------------> podłączamy się pod aplikację (Spring boota)
all you need to do is specify a port where your website is servered so that you expose it to the internet. Example
./ngrok http 8000
passing the above command will produce this output

ngrok by @inconshreveable                                                                                                                                 (Ctrl+C to quit)

Session Status                online
Session Expires               1 hour, 56 minutes
Version                       2.3.40
Region                        United States (us)
Web Interface                 http://127.0.0.1:4040
Forwarding                    http://f4df-20-25-0-130.ngrok.io -> http://localhost:8000
Forwarding                    https://f4df-20-25-0-130.ngrok.io -> http://localhost:8000

Connections                   ttl     opn     rt1     rt5     p50     p90
                              2       0       0.02    0.01    0.00    0.00


na przegląarce mamy:
Failed to complete tunnel connection
The connection to https://f4df-20-25-0-130.ngrok.io
was successfully tunneled to your ngrok client, but the client failed to establish a connection to the local address
localhost:8000.

Make sure that a web service is running on localhost:8000 and that it is a valid address.

The error encountered was: dial tcp 127.0.0.1:8000: connect: connection refused


czyli trzeba uruchomić moją aplikację Springbootową na porcie 8000:
http://localhost:8000


--------------------->  podłączanie się do bazy
możemy też uruchomić bazę:
./ngrok tcp 3306

ngrok by @inconshreveable                                                                                                                                 (Ctrl+C to quit)

Session Status                online
Account                       j4sysiak@gmail.com (Plan: Free)
Version                       2.3.40
Region                        United States (us)
Web Interface                 http://127.0.0.1:4040
Forwarding                    tcp://8.tcp.ngrok.io:15408 -> localhost:3306

Connections                   ttl     opn     rt1     rt5     p50     p90
                              0       0       0.00    0.00    0.00    0.00


teraz korzystając z jakiegoś klienta sql podpinamy się pod tą bazę:
host:  8.tcp.ngrok.io
port:  15408
login: root
hasło: test1234

tworzymy schemat: space
CREATE SCHEMA `space`;

tworzymy jakąś tabelkę:

CREATE TABLE `space`.`Test` (
  `idTest` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idTest`))
COMMENT = 'test table';

select * from `space`.`Test`;



----------------------------  testy
ssh ip172-18-0-13-cd33k8n91rrg00djegrg@direct.labs.play-with-docker.com

ngrok-stable-linux-amd64.zip

#! /bin/bash
echo pppppppppppppppp

