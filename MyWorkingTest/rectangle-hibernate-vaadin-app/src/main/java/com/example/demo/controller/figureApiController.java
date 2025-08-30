package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class figureApiController {

    //  localhost:8080/cal-circumference?figure=RECTANGLE&siteA=10&siteB=11&siteC=22
    //  localhost:8080/cal-circumference?figure=TRIANGLE&siteA=4&siteB=3&siteC=2
    @GetMapping("/cal-circumference")
    public int calculate(@RequestParam String figure,
                         @RequestParam int siteA,
                         @RequestParam int siteB,
                         @RequestParam(required = false) Integer siteC) {
        if (figure.equalsIgnoreCase("RECTANGLE")) {
            return 2 * siteA + 2 * siteB;
        } else if (figure.equalsIgnoreCase("TRIANGLE")) {
            return siteA + siteB + siteC;
        }
        return -1;
    }
}
