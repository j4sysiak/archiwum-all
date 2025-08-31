package co.devfoundry.weather_forecast;

import co.devfoundry.notification.IObserver;

public interface IObservable {

    void registerObserver(IObserver IObserver);

    void unregisterObserver(IObserver IObserver);

    void notifyObservers();

}
