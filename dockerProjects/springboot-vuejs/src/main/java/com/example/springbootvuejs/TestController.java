package com.example.springbootvuejs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {


    //   http://localhost:8080/api/test/greeting
    //   docker:   http://localhost:9000/api/test/greeting
    @GetMapping(path="greeting")
    public String greeting(){
        return "Hello from TestController";
    }
}


























