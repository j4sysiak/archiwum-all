package com.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subsciber implements ISubsciber {

    public String subscriberName;

    public Subsciber(String name) {
        this.subscriberName = name;
    }

    @Override
    public void notify(String message) {
        System.out.println("Subscriber notified: " + subscriberName + ": " + message);
    }
}
