package co.devfoundry.notification;

import co.devfoundry.order.Order;

// Obserwator1

public class Email implements IObserver {


    public void update(Order order) {
        System.out.println("E-mail - zamówienie numer: " +
                order.getOrderNumber() + " zmieniło status na: " +
                order.getOrderStatus());
    }

}
