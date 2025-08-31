package com.company;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<ISubsciber> listOfISubscibers = new ArrayList();

    public void subscribe(ISubsciber iSubsciber) {
        this.listOfISubscibers.add(iSubsciber);
    }

    public void unsubscribe(ISubsciber iSubsciber) {
        this.listOfISubscibers.remove(iSubsciber);
    }

    public void notify(String messageToSubscribers) {
        this.listOfISubscibers.forEach(s -> s.notify(messageToSubscribers));
    }

}
