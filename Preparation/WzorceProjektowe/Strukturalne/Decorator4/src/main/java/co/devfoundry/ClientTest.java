package co.devfoundry;

import co.devfoundry.meal.*;
import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        System.out.println("Nowy posiłek: ");
        //bazowy posiłem: ryż
        Meal rice = new RiceMeal();
        rice.prepareMeal();

        System.out.println("\nNowy posiłek: ");
        // dorzucamy  krewetki
        Meal riceAndShrimp = new ShrimpMealDecorator(rice);
        riceAndShrimp.prepareMeal();

        // a teraz wszystko za jednym razem: potato and  Chicken and Sauce
        System.out.println("\nNowy posiłek: ");
        Meal potatoMealWithChickenAndSauce = new SauceMealDecorator(new ChickenMealDecorator(new PotatoMeal()));
        potatoMealWithChickenAndSauce.prepareMeal();

    }

}
