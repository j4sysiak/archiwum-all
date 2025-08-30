package com.example.UnitTestRestfulWebServicesTestCRUD.controller;

import com.example.UnitTestRestfulWebServicesTestCRUD.entity.Country;
import com.example.UnitTestRestfulWebServicesTestCRUD.entity.User;
import com.example.UnitTestRestfulWebServicesTestCRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        System.out.println("GetUserById REST API is invoked ... ");
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        System.out.println("SaveUser REST API is invoked ... ");
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        System.out.println("DeleteUser REST API is invoked ... ");
        userService.deleteById(id);
    }
}
