package com.example.demo.rest;

import com.example.demo.port.in.TestInPort;
import com.example.demo.port.in.TestInRequest;
import com.example.demo.port.in.TestInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
// @RequestMapping("/api/v1")  // w properitasach zmienna:  server.servlet.context-path
@RequiredArgsConstructor
public
class TestController {

    private final TestInPort testPort;

    @GetMapping("/strings")
    //@ExceptionHandler(AsyncRequestTimeoutException.class)
    //@ResponseStatus(HttpStatus.OK)
    public
    Callable<TestInResponse> getDemoByNameAndName(@RequestParam String[] u) {
        return new Callable<TestInResponse>() {
            @Override
            public
            TestInResponse call() {
                TestInRequest testInRequest = new TestInRequest(u);
                return testPort.getTestData(testInRequest);
            }
        };
    }
}