package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cloud.openfeign.EnableFeignClient;

//@EnableFeignClient
@SpringBootApplication
public
class RestApiFullExampleApplication extends SpringBootServletInitializer {

    public static
    void main(String[] args) {
        SpringApplication.run(RestApiFullExampleApplication.class, args);
    }

}
