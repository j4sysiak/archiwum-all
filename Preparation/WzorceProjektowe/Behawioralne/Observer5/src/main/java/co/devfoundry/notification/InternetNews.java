package co.devfoundry.notification;

import co.devfoundry.weather_forecast.WeatherForecast;

// obserwator1

public class InternetNews implements IObserver {

    public void updateForecast(WeatherForecast weatherForecast) {
        System.out.println("Internet - nowa prognoza pogody: temperatura: " +
                weatherForecast.getTemperature() + " stopni, ciśnienie: " +
                weatherForecast.getPressure() + "hPa");
    }

}
