package drobczyk.bartlomiej.model.dto.api.weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherMapper {

    public static WeatherDto toAppWeather(OpenWeatherDto openWeatherDto) {
        return new WeatherDto(openWeatherDto.getMain().getTemp(),
                openWeatherDto.getMain().getFeelsLike(),
                openWeatherDto.getWind().getSpeed(),
                openWeatherDto.getWeather().get(0).getDescription(),
                openWeatherDto.getWeather().get(0).getIcon(),
                formatToReadableTime(openWeatherDto.getSys().getSunrise()),
                formatToReadableTime(openWeatherDto.getSys().getSunset()));
    }

    private static String formatToReadableTime(long time) {
        Date date = new Date(time * 1000);
        DateFormat format = new SimpleDateFormat("HH : mm");
        return format.format(date);
    }
}