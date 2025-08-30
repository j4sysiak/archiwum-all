package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchLessonToEdit extends RuntimeException {
    public NoSuchLessonToEdit() {
        super("Brak takiej lekcji do edycji");
        super.printStackTrace();
    }
}
