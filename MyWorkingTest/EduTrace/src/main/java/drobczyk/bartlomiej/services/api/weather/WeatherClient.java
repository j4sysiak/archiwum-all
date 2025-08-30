package drobczyk.bartlomiej.services.api.weather;

import drobczyk.bartlomiej.exceptions.WeatherClientException;
import drobczyk.bartlomiej.model.dto.api.weather.OpenWeatherDto;
import drobczyk.bartlomiej.model.dto.api.weather.WeatherDto;
import drobczyk.bartlomiej.model.dto.api.weather.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherClient {
    public static final String API_KEY = "5a013a59a9de75639c72f77ed1f05a4a";
    private final RestTemplate restTemplate;

    @Autowired
    public WeatherClient(RestTemplate template) {
        this.restTemplate = template;
    }


    public WeatherDto getWeatherByLatAndLon(double lat, double lon) {
        String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
        OpenWeatherDto openWeatherDto = Optional.ofNullable(restTemplate.getForObject
                (WEATHER_URL + "weather?lat={lat}&lon={lon}&appid={apiKey}&units=metric&lang=PL",
                        OpenWeatherDto.class, lat, lon, API_KEY))
                .orElseThrow(WeatherClientException::new);
        return WeatherMapper.toAppWeather(openWeatherDto);
    }
}