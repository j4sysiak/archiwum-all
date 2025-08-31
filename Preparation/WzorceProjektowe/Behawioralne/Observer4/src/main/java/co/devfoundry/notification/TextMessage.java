package co.devfoundry.notification;

import co.devfoundry.order.Order;

// Obserwator3

public class TextMessage implements IObserver {

    public void update(Order order) {
        System.out.println("SMS - zamówienie numer: " +
                order.getOrderNumber() + " zmieniło status na: " +
                order.getOrderStatus());
    }

}
