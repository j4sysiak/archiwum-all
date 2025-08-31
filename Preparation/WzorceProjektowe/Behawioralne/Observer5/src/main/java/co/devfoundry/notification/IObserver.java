package co.devfoundry.notification;

import co.devfoundry.weather_forecast.WeatherForecast;

public interface IObserver {

    void updateForecast(WeatherForecast weatherForecast);

}
