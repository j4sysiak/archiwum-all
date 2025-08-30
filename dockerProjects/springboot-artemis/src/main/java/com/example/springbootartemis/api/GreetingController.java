package com.example.springbootartemis.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/greeting")
@Slf4j
public class GreetingController {

    // dzięki temu, że mamy adnotację @RequiredArgsConstructor  to wstrzykujemy automatycznie do konstruktowa tą zależność
    // jest private, więc Lombok automatycznie wstrzyknie do konstruktora jmsTemplate
    private final JmsTemplate jmsTemplate;

    // http://localhost:8080/greeting/
//    @GetMapping("/")
//    public String test() {
//        log.info("Send this message to jms queue");
//        return "test: GreetingController from GetMapping";
//    }


    //   http://localhost:8080/greeting/  - w body podajemy jakiś string np "bla-bla-bla"
    @PostMapping("/")
    public String sendMessage(@RequestBody String message) {
        log.info("Send this message to jms queue: " + message);
        jmsTemplate.convertAndSend("myqueue2", message);
        return "Message sent " + message;
    }

}































































































