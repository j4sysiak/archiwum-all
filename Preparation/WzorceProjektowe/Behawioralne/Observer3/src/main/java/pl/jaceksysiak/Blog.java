package pl.jaceksysiak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


// klasa agregująca obserwatorów
// ważne jest, żeby klasa agregująca miała listę obserwatorów i metody agregujące: dodaj do listy , usuń z listy
// i wywołanie notyfikacji do obserwatoró (po jakimś tam zdarzeniu)

public class Blog {

    private List<IObserver> iObservers;

    public Blog() {
        this.iObservers = new ArrayList<>();
    }

    public void addToSubscribents(IObserver observers) {
        this.iObservers.add(observers);
    }

    public void startWork2() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(11);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.iObservers.forEach(s -> s.sendNewsletter("content: " + UUID.randomUUID()));
//            for (IObserver observer : iObservers) {
//                this.observer.newsletter("content: " + UUID.randomUUID());
//            }
        });
        thread.start();
    }

    public void startWork1() {
        Thread thread = new Thread(() -> {
            while (Thread.currentThread().isAlive()) {
                int randomDelay = new Random().nextInt(1000);
                try {
                    Thread.sleep(randomDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.iObservers.forEach(s -> s.sendNewsletter("time: " + randomDelay + ", content: " + UUID.randomUUID()));
//                for (IObserver observer : iObservers) {
//                    this.observer.newsletter("time: " + randomDelay + ", content: " + UUID.randomUUID());
//                }
            }
        });
        thread.start();
    }
}
