========================== cz.1. tworzenie projektu Vue =================
https://www.youtube.com/watch?v=PcdaxF452b0&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=15

https://github.com/ekim197711/springboot-vuejs-gradle/blob/master/Dockerfile


Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/springboot-vuejs/src/myvuejs (master)
$ npm run build

Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/springboot-vuejs/src/myvuejs (master)
$ npm run serve

> myvuejs@0.1.0 serve
> vue-cli-service serve
  App running at:
  - Local:   http://localhost:8080/
  - Network: http://192.168.1.104:8080/



narzędzie do zarządzania projektami Vue. Można lokalny projekt budować uruchamiać etc
Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/springboot-vuejs/src/myvuejs (master)
$ vue ui    (odpaloamy localhost:8000)



==============================   cz.2.  Spring Boot and VueJS in same jar with gradle

Uwaga: tutaj jest taka zagwozdka. Jeżeli uruchamiamy npm z Widowsa, to w pliku build.gradle powinno być:

task npmBuild(type: Exec) {
	workingDir './src/myvuejs/'
	commandLine 'npm.cmd', 'run', 'build'
}


https://www.youtube.com/watch?v=eVUiDsq7PaY

https://github.com/ekim197711/springboot-vuejs-gradle

--  nie buduje tylko sprawdza, czy wszystko jest ok
Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/springboot-vuejs (master)
$ gradle clean build --dry-run
Starting a Gradle Daemon (subsequent builds will be faster)
:clean SKIPPED
:compileJava SKIPPED
:npmBuild SKIPPED
:copyFrontendToBuild SKIPPED
:processResources SKIPPED
:classes SKIPPED
:bootJar SKIPPED
:jar SKIPPED
:assemble SKIPPED
:compileTestJava SKIPPED
:processTestResources SKIPPED
:testClasses SKIPPED
:test SKIPPED
:check SKIPPED
:build SKIPPED

BUILD SUCCESSFUL in 44s



--  właściwy cean/build
$ gradle clean build

w wyniku tego w lokalizacji C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-vuejs\build\resources\main\static
tj. w lokalizacji plików wynikowych Springboota pojawiły się pliki
wynikowe z Vue.

odpalamy całość:

$ cd C:\Users\Jacek\Documents\JAVA\SpringBoot\dockerProjects\springboot-vuejs\build\libs

Jacek@BERLIN MINGW64 ~/Documents/JAVA/SpringBoot/dockerProjects/springboot-vuejs/build/libs (master)
$ java -jar ./app.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.0.RELEASE)

2022-10-06 06:29:39.795  INFO 8080 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.35]
2022-10-06 06:29:39.798  INFO 8080 --- [           main] o.a.catalina.core.AprLifecycleListener   : Loaded Apache Tomcat Native library [1.2.23] using APR version [1.7.0].
2022-10-06 06:29:39.807  INFO 8080 --- [           main] o.a.catalina.core.AprLifecycleListener   : APR capabilities: IPv6 [true], sendfile [true], accept filters [false], random [true].
2022-10-06 06:29:39.807  INFO 8080 --- [           main] o.a.catalina.core.AprLifecycleListener   : APR/OpenSSL configuration: useAprConnector [false], useOpenSSL [true]
2022-10-06 06:29:39.855  INFO 8080 --- [           main] o.a.catalina.core.AprLifecycleListener   : OpenSSL successfully initialized [OpenSSL 1.1.1c  28 May 2019]
2022-10-06 06:29:40.222  INFO 8080 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-10-06 06:29:40.224  INFO 8080 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 7925 ms
2022-10-06 06:29:41.175  INFO 8080 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-10-06 06:29:41.345  INFO 8080 --- [           main] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page: class path resource [static/index.html]
2022-10-06 06:29:41.626  INFO 8080 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-10-06 06:29:41.649  INFO 8080 --- [           main] c.e.s.SpringbootVuejsApplication         : Started SpringbootVuejsApplication in 10.726 seconds (JVM running for 11.975)

odpalamy Vue:  http://localhost:8080
odpalamy Springboota:  http://localhost:8080/api/test/greeting






========================== cz.3. łączenie SpringBoota restem z  Vue i jeszcze do tego na Dockerze :) =================
Spring Boot and VueJS and Docker multistage build
https://www.youtube.com/watch?v=PcdaxF452b0&list=PLF5X0J2bZ_k44MMIJvncXgJkzy0KxBGMB&index=18


https://github.com/ekim197711/springboot-vuejs-gradle


Uwaga: tutaj jest taka zagwozdka. Jeżeli uruchamiamy npm z Dockera (czyli z Linuxa), to w pliku build.gradle powinno być:

task npmBuild(type: Exec) {
	workingDir './src/myvuejs/'
	commandLine 'npm', 'run', 'build'
}

uruchamiamy: docker-compose up
odpalenie backendu:   http://localhost:9000/api/test/greeting
odpalenie frontu (Vue):   http://localhost:9000




