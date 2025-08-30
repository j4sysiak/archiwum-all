Spring Boot 2.7.4 build image with buildpack feature using Maven
------------------------------------------------------------------
UWAGA, żeby używać  buildpacka:
musi być wersja javy: 17
musi być wersja SpringBoot > 2.7.1 najlepiej 2.7.4



https://www.youtube.com/watch?v=V17fzpmu2Bs&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=20

https://github.com/ekim197711/springboot-buildimage-maven/blob/master/pom.xml

 utworzenie image:
 - odpalamy z POM.XML: myspringapp/Plugins/spring-boot/spring-bootbuild-image
  lub uruchamiamy: mvn clean install spring-boot:repackage  i potem: mvn spring-boot:build-image -e
  lub:  mvn spring-boot:build-image -DskipTests=true
  lub:  mvn spring-boot:build-image -Dspring-boot.build-image.imageName=my-app -e

Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/springboot-buildimage-mongo/script (master)
$ docker images
REPOSITORY                         TAG                     IMAGE ID       CREATED        SIZE
paketobuildpacks/run               base-cnb                320a67ab6606   2 weeks ago    87.8MB
paketobuildpacks/builder           base                    de7c03469c46   42 years ago   1.24GB
gcr.io/paketo-buildpacks/builder   base-platform-api-0.3   de7c03469c46   42 years ago   1.24GB
<none>                             <none>                  eaea30b69ac1   42 years ago   274MB
myspringapp                        0.0.1-SNAPSHOT          38a7911b8caf   42 years ago   280MB



 uruchomienie image 'myspringapp':
$ docker run -it myspringapp:0.0.1-SNAPSHOT

ale mamy błąd z mongodb:

com.mongodb.MongoSocketOpenException: Exception opening socket
        at com.mongodb.internal.connection.SocketStream.open(SocketStream.java:70) ~[mongodb-driver-core-4.6.1.jar:na]
        at com.mongodb.internal.connection.InternalStreamConnection.open(InternalStreamConnection.java:180) ~[mongodb-driver-core-4.6.1.jar:na]
        at com.mongodb.internal.connection.DefaultServerMonitor$ServerMonitorRu

$ docker-compose build
$ docker-compose up

trzeba restartować np. w kliencie dockera, bo mongodb może dłużej wstawać (jak mysql)
po kilku minutach Springboot pięknie wstaje ....

.   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.4)

2022-10-09 18:08:00.414  INFO 1 --- [           main] e.s.SpringbootBuildimageMongoApplication : Starting SpringbootBuildimageMongoApplication v0.0.1-SNAPSHOT using Java 17.0.4.1 on 2a947dfeec17 with PID 1 (/workspace/BOOT-INF/classes started by cnb in /workspace)
2022-10-09 18:08:00.445  INFO 1 --- [           main] e.s.SpringbootBuildimageMongoApplication : The following 1 profile is active: "test"
2022-10-09 18:08:02.161  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2022-10-09 18:08:02.188  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 16 ms. Found 0 MongoDB repository interfaces.
2022-10-09 18:08:03.384  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-10-09 18:08:03.418  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-10-09 18:08:03.419  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.65]
2022-10-09 18:08:03.713  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-10-09 18:08:03.718  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2888 ms
2022-10-09 18:08:04.912  INFO 1 --- [           main] org.mongodb.driver.client                : MongoClient with metadata {"driver": {"name": "mongo-java-driver|sync|spring-boot", "version": "4.6.1"}, "os": {"type": "Linux", "name": "Linux", "architecture": "amd64", "version": "5.10.102.1-microsoft-standard-WSL2"}, "platform": "Java/BellSoft/17.0.4.1+1-LTS"} created with settings MongoClientSettings{readPreference=primary, writeConcern=WriteConcern{w=null, wTimeout=null ms, journal=null}, retryWrites=true, retryReads=true, readConcern=ReadConcern{level=null}, credential=null, streamFactoryFactory=null, commandListeners=[], codecRegistry=ProvidersCodecRegistry{codecProviders=[ValueCodecProvider{}, BsonValueCodecProvider{}, DBRefCodecProvider{}, DBObjectCodecProvider{}, DocumentCodecProvider{}, IterableCodecProvider{}, MapCodecProvider{}, GeoJsonCodecProvider{}, GridFSFileCodecProvider{}, Jsr310CodecProvider{}, JsonObjectCodecProvider{}, BsonCodecProvider{}, EnumCodecProvider{}, com.mongodb.Jep395RecordCodecProvider@45e9b12d]}, clusterSettings={hosts=[mymongo:27017], srvServiceName=mongodb, mode=SINGLE, requiredClusterType=UNKNOWN, requiredReplicaSetName='null', serverSelector='null', clusterListeners='[]', serverSelectionTimeout='30000 ms', localThreshold='30000 ms'}, socketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=0, receiveBufferSize=0, sendBufferSize=0}, heartbeatSocketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=10000, receiveBufferSize=0, sendBufferSize=0}, connectionPoolSettings=ConnectionPoolSettings{maxSize=100, minSize=0, maxWaitTimeMS=120000, maxConnectionLifeTimeMS=0, maxConnectionIdleTimeMS=0, maintenanceInitialDelayMS=0, maintenanceFrequencyMS=60000, connectionPoolListeners=[], maxConnecting=2}, serverSettings=ServerSettings{heartbeatFrequencyMS=10000, minHeartbeatFrequencyMS=500, serverListeners='[]', serverMonitorListeners='[]'}, sslSettings=SslSettings{enabled=false, invalidHostNameAllowed=false, context=null}, applicationName='null', compressorList=[], uuidRepresentation=JAVA_LEGACY, serverApi=null, autoEncryptionSettings=null, contextProvider=null}
2022-10-09 18:08:05.007  INFO 1 --- [}-mymongo:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:6}] to mymongo:27017
2022-10-09 18:08:05.008  INFO 1 --- [}-mymongo:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:7}] to mymongo:27017
2022-10-09 18:08:05.009  INFO 1 --- [}-mymongo:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=mymongo:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=17, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=87204000}
2022-10-09 18:08:05.900  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-10-09 18:08:05.931  INFO 1 --- [           main] e.s.SpringbootBuildimageMongoApplication : Started SpringbootBuildimageMongoApplication in 6.716 seconds (JVM running for 7.94)

===================  jeżeli są błędy




For me, the trick was reinstalling all dependencies.

This can be done in two ways:

using mvn dependency:purge-local-repository to delete all local dependencies
just deleting everything in the m2/repository folder, I suggest you use the mvn command.
Then, follow it up by a mvn clean install to load all the dependencies again.