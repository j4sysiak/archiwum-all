package co.devfoundry.notification;

import co.devfoundry.order.Order;

// Obserwator2

public class MobileApp implements IObserver {

    public void update(Order order) {
        System.out.println("Aplikacja mobilna - zamówienie numer: " +
                order.getOrderNumber() + " zmieniło status na: " +
                order.getOrderStatus());
    }

}
