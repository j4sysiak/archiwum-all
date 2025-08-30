package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {

    @GetMapping("/test1")
    public String test() {
        return "HELLO";
    }
}
