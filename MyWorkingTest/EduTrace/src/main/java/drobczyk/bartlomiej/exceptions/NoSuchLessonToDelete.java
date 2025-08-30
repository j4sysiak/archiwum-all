package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchLessonToDelete extends RuntimeException {
    public NoSuchLessonToDelete() {
        super("Brak takiej lekcji do usnięcia");
        super.printStackTrace();
    }
}
