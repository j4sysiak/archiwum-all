package com.example.UnitTestRestfulWebServicesTestCRUD.service;

import com.example.UnitTestRestfulWebServicesTestCRUD.entity.User;

public interface UserService {

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteById(Integer id);
}
