package co.devfoundry.order;

import co.devfoundry.notification.IObserver;

import java.util.HashSet;
import java.util.Set;


// klasa agregująca obserwatorów: Email, MobileApp, TextMessage

public class Order implements IObservable {

    private Long orderNumber;
    private OrderStatus orderStatus;
    private Set<IObserver> registeredIObservers = new HashSet<>();

    public Order(Long orderNumber, OrderStatus orderStatus) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
    }

    public void registerObserver(IObserver IObserver) {
        registeredIObservers.add(IObserver);
    }

    public void unregisterObserver(IObserver IObserver) {
        registeredIObservers.remove(IObserver);
    }

    public void notifyObservers() {
        for(IObserver IObserver : registeredIObservers) {
            IObserver.update(this);
        }
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        setOrderStatus(orderStatus);
        notifyObservers();
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
