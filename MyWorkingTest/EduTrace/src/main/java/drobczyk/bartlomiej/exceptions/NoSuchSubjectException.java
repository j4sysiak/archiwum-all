package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchSubjectException extends RuntimeException {
    public NoSuchSubjectException() {
        super("Brak wskazanego przedmiotu");
        super.printStackTrace();
    }
}
