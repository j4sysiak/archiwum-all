package de.jaceksysiak;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


class SimpleCalculatorTest {

    @Test
    void twoPlusOneShouldBeThree() {

        SimpleCalculator simpleCalculator = new SimpleCalculator();

        assertEquals(3, simpleCalculator.add(2, 1));
        assertNotEquals(31, simpleCalculator.add(2, 1));
        assertTrue(simpleCalculator.add(2, 1) == 3);
    }
}