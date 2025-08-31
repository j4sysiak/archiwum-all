package co.devfoundry;

import co.devfoundry.notification.InternetNews;
import co.devfoundry.notification.RadioNews;
import co.devfoundry.notification.TvNews;
import co.devfoundry.weather_forecast.WeatherForecast;

public class ClientTest {

    @org.junit.Test
    public void test() {

        WeatherForecast weatherForecast = new WeatherForecast(25, 1003);

        RadioNews radioNews = new RadioNews();
        InternetNews internetNews = new InternetNews();
        TvNews tvNews = new TvNews();

        weatherForecast.registerObserver(radioNews);
        weatherForecast.registerObserver(internetNews);
        weatherForecast.registerObserver(tvNews);

        weatherForecast.notifyObservers();

        weatherForecast.unregisterObserver(tvNews);
        weatherForecast.unregisterObserver(radioNews);

        System.out.println("\nNowa prognoza - będzie powiadomienie tylko dla serwisu internetowego:");
        weatherForecast.notifyObservers();
            // lub też tą drogą notyfikacja będzie (tylko dla pozostałego internetu)
        weatherForecast.setForecast(18, 1007);

    }

}
