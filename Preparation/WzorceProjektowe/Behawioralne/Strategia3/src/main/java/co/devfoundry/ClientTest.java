package co.devfoundry;

import co.devfoundry.price_calculator.PriceCalculator;
import co.devfoundry.price_calculator.pricing_strategy.RegularPrice;
import co.devfoundry.price_calculator.pricing_strategy.SalePrice;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        PriceCalculator priceCalculator = new PriceCalculator();

        //Użytkownik nie jest zapisany do newslettera - normalna cena
        priceCalculator.setPricingStrategy(new RegularPrice());  // wstrzykujemy abstrakcje
        priceCalculator.calculate(100, false);

        //Użytkownik jest zapisany do newslettera - wybrana błędna strategia
        priceCalculator.setPricingStrategy(new RegularPrice());  // wstrzykujemy abstrakcje
        priceCalculator.calculate(100, true);

        //Użytkownik jest zapisany do newslettera
        priceCalculator.setPricingStrategy(new SalePrice());  // wstrzykujemy abstrakcje
        priceCalculator.calculate(100, true);

        //Użytkownik jest zapisany do newslettera - wybrana błędna strategia
        priceCalculator.setPricingStrategy(new SalePrice());  // wstrzykujemy abstrakcje
        priceCalculator.calculate(100, false);

    }

}
