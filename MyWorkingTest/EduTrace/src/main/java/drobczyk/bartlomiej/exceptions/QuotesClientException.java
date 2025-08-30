package drobczyk.bartlomiej.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuotesClientException extends RuntimeException {
    public QuotesClientException() {
        super("Błąd komunikacji z klientem HTTP dostaraczającym cytaty");
        super.printStackTrace();
    }
}
