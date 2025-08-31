package src.exceptionhandling.mytest;

import java.io.IOException;
import java.util.List;

public class Exceptions {

    public List<String> loadAllPlayers(String playersFile) throws TimeoutException {
        // ... potentially long operation
        throw new TimeoutException("This operation took too long");
       // throw new IllegalArgumentException("Filename isn't valid!");
        //throw new Exception("Currencies	 don't	 match");/
    }
}
