package co.devfoundry;

import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        WeekDay day = new MyDay();
        day.everyDayIsExaclyTheSame(TypeOfTransport.BIKE);

    }

}
