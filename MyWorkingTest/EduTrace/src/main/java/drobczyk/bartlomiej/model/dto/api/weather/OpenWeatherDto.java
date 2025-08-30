package drobczyk.bartlomiej.model.dto.api.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OpenWeatherDto {
    private OpenWeatherDtoMain main;
    private OpenWeatherDtoWind wind;
    private List<OpenWeatherDtoWeather> weather;
    private OpenWeatherDtoSys sys;

    public OpenWeatherDto() {
    }

    public List<OpenWeatherDtoWeather> getWeather() {
        return weather;
    }

    public OpenWeatherDtoMain getMain() {
        return main;
    }

    public OpenWeatherDtoWind getWind() {
        return wind;
    }

    public OpenWeatherDtoSys getSys() {
        return sys;
    }

    public class OpenWeatherDtoMain {
        private double temp;
        @JsonProperty("feels_like")
        private double feelsLike;

        public double getTemp() {
            return temp;
        }

        public double getFeelsLike() {
            return feelsLike;
        }
    }

    public class OpenWeatherDtoWind {
        private double speed;

        public double getSpeed() {
            return speed;
        }
    }

    public static class OpenWeatherDtoWeather {
        private String description;
        private String icon;


        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }

    public class OpenWeatherDtoSys {
        private long sunrise;
        private long sunset;

        public long getSunrise() {
            return sunrise;
        }

        public long getSunset() {
            return sunset;
        }
    }
}