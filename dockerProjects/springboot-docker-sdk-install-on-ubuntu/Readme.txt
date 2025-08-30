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

