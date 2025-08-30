package com.example.ktordockermultistagebuild;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    //   http://localhost:8080/api/test
    //  docker:   http://localhost:9000/api/test
    @GetMapping(path="/api/test")
    public String destination(){
        return "TEST";
    }
}
