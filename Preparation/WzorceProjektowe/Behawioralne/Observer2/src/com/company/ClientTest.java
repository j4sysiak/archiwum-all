package com.company;

public class ClientTest {

    @org.junit.Test
    public void test() {
        // uruchamiamy wątek jakiegoś zadania i czekamy kiedy się zakończy wątek z pracy (działania) jakiejś maszynerii ObserverSingleOne
        // powiadomianie po kolei każdego klienta po zakończeniu wątku

        // var cli = new ObserverOne();
        IObserver cli1 = new ObserverOne();
        ObserverSingleOne observerSingleOne1 = new ObserverSingleOne(cli1);  // wrzucamy tyklo jednego klienta
        observerSingleOne1.startWork();

        new ObserverSingleOne(new ObserverTwo()).startWork();
        new ObserverSingleOne(new ObserverThree()).startWork();


        // hurtowe powiadamianie obserwatorów (czyli klientów) kiedy skończy się wątek z pracy (działania) jakiejś maszynerii ObserverSingleOne
        // powiadomianie hurtowo wszystkich klientów po zakończeniu wątku
        ObserversAgregator observersAgregator = new ObserversAgregator();
        observersAgregator.subscribe(new ObserverOne());   // dodajemy do listy klientów
        observersAgregator.subscribe(new ObserverTwo());   // dodajemy do listy klientów
        observersAgregator.subscribe(new ObserverThree());   // dodajemy do listy klientów
        observersAgregator.startWork();
    }
}
