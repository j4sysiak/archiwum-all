package com.example.springbootk6.space;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NavigationRestController {

    @GetMapping("/api/navigation")
    public String destination(){
        return "Mars";
    }

//    @GetMapping("/api/navigation")
//    public ResponseEntity<String> destination(){
//        int i = new Random().nextInt()%3;
//        if (i == 1)
//            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
//
//        return new ResponseEntity<>("Mars", HttpStatus.OK);
//    }
}
