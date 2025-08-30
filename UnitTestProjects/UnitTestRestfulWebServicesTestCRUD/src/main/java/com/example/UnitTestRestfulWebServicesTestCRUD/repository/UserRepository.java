package com.example.UnitTestRestfulWebServicesTestCRUD.repository;

import com.example.UnitTestRestfulWebServicesTestCRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
