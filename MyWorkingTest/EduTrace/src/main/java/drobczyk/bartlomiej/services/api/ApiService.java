package drobczyk.bartlomiej.services.api;

import drobczyk.bartlomiej.model.dto.api.location.LocationDto;
import drobczyk.bartlomiej.model.dto.api.quote.QuoteDto;
import drobczyk.bartlomiej.model.dto.api.weather.WeatherDto;
import drobczyk.bartlomiej.services.api.location.LocationClient;
import drobczyk.bartlomiej.services.api.quote.QuoteClient;
import drobczyk.bartlomiej.services.api.weather.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ApiService {
    private final LocationClient locationClient;
    private final WeatherClient weatherClient;
    private final QuoteClient quoteClient;
    private List<QuoteDto> quotes = new ArrayList<>();
    private final Random randomQuoteSelector = new Random();

    @Autowired
    public ApiService(LocationClient locationClient, WeatherClient weatherClient, QuoteClient quoteClient) {
        this.locationClient = locationClient;
        this.weatherClient = weatherClient;
        this.quoteClient = quoteClient;
    }

    @Cacheable(cacheNames = "weather", key = "#location.ip")
    public WeatherDto provideWeather(LocationDto location) {
        return weatherClient.getWeatherByLatAndLon(
                location.getLatitude(),
                location.getLongitude());
    }

    @Cacheable(cacheNames = "quote")
    public List<QuoteDto> provideQuotes() {
        return quoteClient.provideQuotes();
    }

    public QuoteDto provideRandomQuote() {
        if (quotes.isEmpty()) {
            quotes = provideQuotes();
        }
        return quotes.get(randomQuoteSelector.nextInt(quotes.size()));
    }

    public LocationDto provideLocationDto() {
        return locationClient.getLocationInfo();
    }
}