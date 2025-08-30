package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired  //wstrzyknięcie beana
    private PersonReposiory personReposiory;

    // przez konstruktor
    public PersonService(PersonReposiory personReposiory) {
        this.personReposiory = personReposiory;
    }
}
