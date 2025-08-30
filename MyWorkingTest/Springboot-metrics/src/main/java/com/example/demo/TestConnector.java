package com.example.demo;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="test-connector")
public class TestConnector {

     @ReadOperation
    public Map<String, String> get() {
        Map<String, String> myMap = new HashMap();
         RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.exchange("http://localhost:8081/test1", HttpMethod.GET, HttpEntity.EMPTY, String.class);
            //jeżeli uda się połączyć zewnętrzną aplikację - to zwracamy success
            //uruchamiamy zewnętrzy Rest: apka jest w: c:\Users\Jacek\Documents\JAVA\SpringBoot\MyWorkingTest\   działa na porcie 8081
            //uruchom go przy użyciu jara (najpierw go wygeneruj w target a potem uruchom)
//            2.sposób:
//            $ ./mvnw package           (rapper mavena, można też użyć ./mvnw install)
//            $ cd  target
//            Jacek@BERLIN MINGW64 /C/Users/Jacek/git/Local_05-spring-boot-properties-demo/05-spring-boot-properties-demo/target (master)
//            $ java -jar 05-spring-boot-properties-demo-0.0.1-SNAPSHOT.jar
//            $ java -jar rest-test-0.0.1-SNAPSHOT.jar
            myMap.put("status", "success");
        } catch (Exception e) {
            System.out.println("Nie udało się podłączyć zewnętrzej apoliacji!!!!");
            e.getMessage();
            myMap.put("status", "faild");
        }
       return myMap;
   }
}
