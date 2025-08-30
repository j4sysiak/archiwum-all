package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Brak wskazanego studenta o id: " + id);
        super.printStackTrace();
    }
}
