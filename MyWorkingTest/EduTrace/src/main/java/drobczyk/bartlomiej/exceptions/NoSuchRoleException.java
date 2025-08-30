package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchRoleException extends RuntimeException {
    public NoSuchRoleException() {
        super("Brak wskazanego uprawnienia");
        super.printStackTrace();
    }
}
