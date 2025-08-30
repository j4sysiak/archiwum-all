package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(String login) {
        super("Brak wskazanego nauczyciela o wskazanym loginie" + login);
        super.printStackTrace();
    }
}
