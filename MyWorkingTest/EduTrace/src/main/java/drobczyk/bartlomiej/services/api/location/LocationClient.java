package drobczyk.bartlomiej.services.api.location;

import drobczyk.bartlomiej.model.dto.api.location.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationClient {
    private final RestTemplate restTemplate;

    @Autowired
    public LocationClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public LocationDto getLocationInfo() {
        return restTemplate.getForObject("https://ipapi.co/json", LocationDto.class);
    }
}