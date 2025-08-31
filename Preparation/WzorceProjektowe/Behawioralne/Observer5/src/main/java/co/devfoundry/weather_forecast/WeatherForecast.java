package co.devfoundry.weather_forecast;

import co.devfoundry.notification.IObserver;

import java.util.HashSet;
import java.util.Set;

// klasa agregująca

public class WeatherForecast implements IObservable {

    private int temperature;
    private int pressure;
    private Set<IObserver> registeredIObservers = new HashSet<>();

    public WeatherForecast(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public void registerObserver(IObserver IObserver) {
        registeredIObservers.add(IObserver);
    }

    public void unregisterObserver(IObserver IObserver) {
        registeredIObservers.remove(IObserver);
    }

    public void notifyObservers() {
        for (IObserver IObserver : registeredIObservers) {
            IObserver.updateForecast(this);
        }
    }

    public void setForecast(int temperature, int pressure) {
        setTemperature(temperature);
        setPressure(pressure);
        notifyObservers();
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    private void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    private void setPressure(int pressure) {
        this.pressure = pressure;
    }

}
