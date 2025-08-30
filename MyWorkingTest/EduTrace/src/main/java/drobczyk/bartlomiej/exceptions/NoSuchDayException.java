package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchDayException extends RuntimeException {
    public NoSuchDayException() {
        super("Brak wskazanego dnia");
        super.printStackTrace();
    }
}
