package co.devfoundry.notification;

import co.devfoundry.weather_forecast.WeatherForecast;

// obserwator2

public class RadioNews implements IObserver {

    public void updateForecast(WeatherForecast weatherForecast) {
        System.out.println("Radio - nowa prognoza pogody: temperatura: " +
                weatherForecast.getTemperature() + " stopni, ciśnienie: " +
                weatherForecast.getPressure() + "hPa");
    }

}
