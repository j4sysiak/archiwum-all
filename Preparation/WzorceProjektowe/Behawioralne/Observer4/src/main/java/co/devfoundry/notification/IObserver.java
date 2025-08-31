package co.devfoundry.notification;

import co.devfoundry.order.Order;

public interface IObserver {

    void update(Order order);

}
