package drobczyk.bartlomiej.model.dto.api.weather;

import org.decimal4j.util.DoubleRounder;

public class WeatherDto {
    private double temperature;
    private double feelsLikeTemperature;
    private double windSpeed;
    private String description;
    private String icon;
    private String sunrise;
    private String sunset;

    public WeatherDto() {
    }

    public WeatherDto(double temperature, double feelsLikeTemperature, double windSpeed, String description,
                      String icon, String sunrise, String sunset) {
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.windSpeed = windSpeed;
        this.description = description;
        this.icon = icon;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public double getTemperature() {
        return DoubleRounder.round(temperature, 1);
    }

    public double getFeelsLikeTemperature() {
        return DoubleRounder.round(feelsLikeTemperature, 1);
    }

    public double getWindSpeed() {
        return DoubleRounder.round(windSpeed, 1);
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String provideIconAdress() {
        return "http://openweathermap.org/img/wn/" + icon + "@2x.png";
    }
}