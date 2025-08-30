package com.codeinvestigator.spaceship.status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpaceshipController {

    @GetMapping(path="/")
    public String status(){
        String destination;
        String status = "(Spaceship) Everything is fine. We are on our way to: ";
        RestTemplate rt = new RestTemplate();
        destination = rt.getForObject("http://commandcenter:8080/", String.class);
        return status + destination;
    }

}
