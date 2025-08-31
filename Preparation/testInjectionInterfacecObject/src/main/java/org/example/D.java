package org.example;

import org.springframework.stereotype.Component;

//@Component
public class D implements IC {

    @Override
    public void sendMessage(String message) {
        System.out.println("Message-->" + message);
    }
}
