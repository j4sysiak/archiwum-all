package com.company;

import org.junit.Test;

public class ClientTest {

    @Test
    public void test() {

        var start = new Coordinate();
        var stop = new Coordinate();

        // Obrazowo Google map - trzy strategie wyboru drogi do jednego celu: samochód, pieszo, rower
        // Zaproponowano wzorzec strategii w kontekście klasy MapCreator
        // W zależlości od wyboru jaki ma uzytkownik, klasa ta dostanie konkretną implementację dla samochód, pieszo, rower
        // Dla klasy MapCreator nie ma znaczenia jaką strategię dostanie
        // strategia zostaje wstrzyknięta poprzez konstruktor do MapCreator
        // strategia pozwala na używanie różnych wariantów jednego algorytmu
        // w obrębie danego obiektu w trakcie działania programu
        // oddziela szczegóły implementacyjne od warstwy biznesowej


        /* pierwszy sposób - SOLID DependencyInversion */
        MapCreator.builder()
                .iRouteStrategy(new WalkStrategy())
                .build()
                .creatingRoute(start, stop);


        /* drugi sposób - na to samo wychodzi  */
        IRouteStrategy bikeRouteStrategy = new BikeStrategy();
        var mapCreator1 = new MapCreator(bikeRouteStrategy);
        mapCreator1.creatingRoute(start, stop);

        var mapCreator2 = new MapCreator(new CarStrategy());
        mapCreator2.creatingRoute(start, stop);

        var mapCreator3 = new MapCreator(new WalkStrategy());
        mapCreator3.creatingRoute(start, stop);
}
}
