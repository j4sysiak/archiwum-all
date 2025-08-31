package com.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubsciberVip implements ISubsciber {

    public String subscriberName;

    public SubsciberVip(String name) {
        this.subscriberName = name;
    }

    @Override
    public void notify(String message) {
        System.out.println("Królu nie musisz placić: " + subscriberName + ": " + message);
    }
}
