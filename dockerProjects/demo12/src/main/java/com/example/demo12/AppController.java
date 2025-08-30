package com.example.demo12;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class AppController {

    @Value("${user}")
    private String user;

    @GetMapping("/test")
    public String get() {
        return "Hello: " + user;
    }

    @GetMapping("/data1")
    public String getField1() throws IOException {
        String filename = "src/data1/file.txt";
        Path path = Paths.get(filename);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    @GetMapping("/data2")
    public String getField2() throws IOException {
        String filename = "src/data2/file.txt";
        Path path = Paths.get(filename);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}































