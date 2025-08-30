package com.example.nginxdemo1;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class MyTrainRestController {

    // end point: http://localhost:8080/api/timetable
    @GetMapping("/timetable")
    public String timetable(){
        log.info("Serve timetable...");
        return "Train comes soon!";
    }
}
