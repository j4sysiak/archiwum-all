package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ArchivedPositionBeyondBoundriesException extends RuntimeException {
    public ArchivedPositionBeyondBoundriesException() {
        super("Zarchiwizona pozycja lekcji jest spoza zakresu zapisanych lekcji");
        super.getStackTrace();
    }
}
