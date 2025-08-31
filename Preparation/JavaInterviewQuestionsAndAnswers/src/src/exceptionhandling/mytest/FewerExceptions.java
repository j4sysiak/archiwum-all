package src.exceptionhandling.mytest;


import java.util.List;

public class FewerExceptions extends Exceptions {
    @Override
    public List<String> loadAllPlayers(String playersFile)   {
       // throw new IllegalArgumentException("Filename isn't valid!");
        throw new RuntimeException("Currencies	don't	match");
    }
}
