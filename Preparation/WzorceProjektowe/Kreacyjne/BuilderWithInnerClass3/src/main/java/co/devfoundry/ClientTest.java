package co.devfoundry;

import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        FlightLeg leg = new FlightLeg
                .FlightLegBuilder("Las Vegas","Los Angeles")
                .price(100)
                .build();
        System.out.println(leg);
    }
}
