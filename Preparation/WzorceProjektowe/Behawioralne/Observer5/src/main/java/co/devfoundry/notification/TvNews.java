package co.devfoundry.notification;

import co.devfoundry.weather_forecast.WeatherForecast;

// obserwator3

public class TvNews implements IObserver {

    public void updateForecast(WeatherForecast weatherForecast) {
        System.out.println("Telewizja - nowa prognoza pogody: temperatura: " +
                weatherForecast.getTemperature() + " stopni, ciśnienie: " +
                weatherForecast.getPressure() + "hPa");
    }

}
