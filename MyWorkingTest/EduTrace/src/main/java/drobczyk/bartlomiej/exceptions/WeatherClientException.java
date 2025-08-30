package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WeatherClientException extends RuntimeException {
    public WeatherClientException() {
        super("Błąd komunikacji z klientem HTTP dostaraczającym cytaty");
        super.printStackTrace();
    }
}
