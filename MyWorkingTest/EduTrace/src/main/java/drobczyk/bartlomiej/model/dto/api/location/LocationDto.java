package drobczyk.bartlomiej.model.dto.api.location;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDto {
    private String ip;
    private String region;
    @JsonProperty("country_name")
    private String country;
    private double latitude;
    private double longitude;

    public String getIp() {
        return ip;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}