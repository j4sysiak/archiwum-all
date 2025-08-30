
https://www.youtube.com/watch?v=T8LqONZzMQI




C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\SimpleFormExample__WithDocker>docker build -f Dockerfile -t simple-form-example:v1 .
[+] Building 114.8s (7/7) FINISHED
 => [internal] load build definition from Dockerfile                                                                                                                                                                                    1.4s
 => => transferring dockerfile: 224B                                                                                                                                                                                                    0.4s
 => [internal] load .dockerignore                                                                                                                                                                                                       1.0s
 => => transferring context: 2B                                                                                                                                                                                                         0.3s
 => [internal] load metadata for docker.io/library/openjdk:17                                                                                                                                                                           7.5s
 => [internal] load build context                                                                                                                                                                                                       4.5s
 => => transferring context: 19.06MB                                                                                                                                                                                                    3.5s
 => [1/2] FROM docker.io/library/openjdk:17@sha256:528707081fdb9562eb819128a9f85ae7fe000e2fbaeaf9f87662e7b3f38cb7d8                                                                                                                    93.2s
 => => resolve docker.io/library/openjdk:17@sha256:528707081fdb9562eb819128a9f85ae7fe000e2fbaeaf9f87662e7b3f38cb7d8                                                                                                                     0.8s
 => => sha256:528707081fdb9562eb819128a9f85ae7fe000e2fbaeaf9f87662e7b3f38cb7d8 1.04kB / 1.04kB                                                                                                                                          0.0s
 => => sha256:98f0304b3a3b7c12ce641177a99d1f3be56f532473a528fda38d53d519cafb13 954B / 954B                                                                                                                                              0.0s
 => => sha256:5e28ba2b4cdb3a7c3bd0ee2e635a5f6481682b77eabf8b51a17ea8bfe1c05697 4.45kB / 4.45kB                                                                                                                                          0.0s
 => => sha256:38a980f2cc8accf69c23deae6743d42a87eb34a54f02396f3fcfd7c2d06e2c5b 42.11MB / 42.11MB                                                                                                                                       35.7s
 => => sha256:de849f1cfbe60b1c06a1db83a3129ab0ea397c4852b98e3e4300b12ee57ba111 13.53MB / 13.53MB                                                                                                                                       13.1s
 => => sha256:a7203ca35e75e068651c9907d659adc721dba823441b78639fde66fc988f042f 187.53MB / 187.53MB                                                                                                                                     67.4s
 => => extracting sha256:38a980f2cc8accf69c23deae6743d42a87eb34a54f02396f3fcfd7c2d06e2c5b                                                                                                                                               5.4s
 => => extracting sha256:de849f1cfbe60b1c06a1db83a3129ab0ea397c4852b98e3e4300b12ee57ba111                                                                                                                                               1.4s
 => => extracting sha256:a7203ca35e75e068651c9907d659adc721dba823441b78639fde66fc988f042f                                                                                                                                              13.5s
 => [2/2] COPY target/SimpleFormExample-0.0.1-SNAPSHOT.war SimpleFormExample-0.0.1-SNAPSHOT.war                                                                                                                                         9.0s
 => exporting to image                                                                                                                                                                                                                  1.7s
 => => exporting layers                                                                                                                                                                                                                 1.4s
 => => writing image sha256:56c82812780b27d62558dc29357bdef54e745f0d643d689ccc6d1a41d900b3d8                                                                                                                                            0.1s
 => => naming to docker.io/library/simple-form-example:v1                                                                                                                                                                               0.1s

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them





C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\SimpleFormExample__WithDocker>docker images
REPOSITORY                      TAG              IMAGE ID       CREATED             SIZE
simple-form-example             v1               56c82812780b   39 seconds ago      491MB
stream                          v2               c959efd40db9   49 minutes ago      122MB
helloworld                      latest           bc88cec09f98   About an hour ago   122MB
01-hello-world-rest-api         0.0.1-SNAPSHOT   f60a46f853da   2 hours ago         147MB
<none>                          <none>           139d0c9a9efe   2 hours ago         147MB
ubuntu                          latest           df5de72bdb3b   3 weeks ago         77.8MB
grafana/grafana                 latest           c4b778290339   2 months ago        292MB
prom/prometheus                 latest           0c33456baaaa   2 months ago        211MB
<none>                          <none>           ccf9f10bc4a9   3 months ago        147MB
<none>                          <none>           e0eae122aa83   3 months ago        147MB
j4sysiak/hello-world-rest-api   dockerfile1      acfc108c7b3e   3 months ago        122MB
<none>                          <none>           dd8960418ca8   3 months ago        122MB
j4sysiak/hello-world-rest-api   0.0.1-SNAPSHOT   bebb537d4e70   3 months ago        122MB
<none>                          <none>           18ea67d1665f   3 months ago        122MB
<none>                          <none>           e3f4ddf615a2   3 months ago        122MB
<none>                          <none>           ac576d8ec56f   3 months ago        122MB
j4sysiak/hello-world-rest-api   manual2          2b89973d5761   3 months ago        122MB
j4sysiak/hello-world-rest-api   manual1          404033c6e81a   3 months ago        122MB
nginx                           latest           de2543b9436b   3 months ago        142MB
hello-world                     latest           feb5d9fea6a5   11 months ago       13.3kB
openjdk                         8-jdk-alpine     a3562aa0b991   3 years ago         105MB



C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\SimpleFormExample__WithDocker>docker run -p 8000:8080 56c82812780b

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.7)

2022-08-28 16:22:34.022  INFO 1 --- [           main] c.e.



C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\SimpleFormExample__WithDocker>docker container ls
CONTAINER ID   IMAGE     COMMAND                  CREATED              STATUS              PORTS                              NAMES
bc7b3f43d624   56c       "java -jar /SimpleFo…"   About a minute ago   Up About a minute   8000/tcp, 0.0.0.0:8000->8080/tcp   sleepy_euclid



uruchomienie:
http://localhost:8000/index