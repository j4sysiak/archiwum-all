package src.exceptionhandling.mytest;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

         List<String> list = new Exceptions().loadAllPlayers("TEST");
    }

}
