package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository <AppUser, Long> {

    AppUser findByUsername(String username);
}
