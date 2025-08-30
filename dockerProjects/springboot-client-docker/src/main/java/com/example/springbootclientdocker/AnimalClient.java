package com.example.springbootclientdocker;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@Controller
@RestController  //żeby wyświetlić dane w get() musi być RestController a nie Controller
public class AnimalClient {

    //end point 1
    @GetMapping("/showForGui")
    @ResponseBody
    public Animal[] get() {
        RestTemplate restTemplate = new RestTemplate();
		/*  uruchomienie lokalne
        ResponseEntity<Animal[]> exchange = restTemplate.exchange("http://localhost:10101/animals",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Animal[].class);*/
				
		/*  uruchomienie dockerowe */
		ResponseEntity<Animal[]> exchange = restTemplate.exchange("http://api:10101/animals",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Animal[].class);

        Animal[] body = exchange.getBody();
        return body;
    }

    //end point 2
    @GetMapping("/showtest")
    @ResponseBody
    public String showSth() {
        return "showtest";
    }

}






























