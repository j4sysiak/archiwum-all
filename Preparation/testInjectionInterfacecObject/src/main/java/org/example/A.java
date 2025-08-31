package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class A {

    @Autowired
    IC ic;

    @Autowired
    A a;

    public void sendMessage(String s) {
        a.sendMessage("Hello from A");
    }

}
