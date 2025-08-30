package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// zadanie servisu - wyciąganie użytkowników z bazy danych

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepo appUserRepo;

    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    // na podstawie loginu będzie pobierać użytkownika z bazy danych
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return appUserRepo.findByUsername(s);
    }

}
