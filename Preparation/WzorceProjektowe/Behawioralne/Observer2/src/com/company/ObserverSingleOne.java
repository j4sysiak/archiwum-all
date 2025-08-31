package com.company;

// ta klasa agregująca nie ma co agregować, opiera się tylko na jednym z obserwatorów:  ObserverOne lub ObserverTwo lub ObserverThree

public class ObserverSingleOne {

    private IObserver  iObserver;

    public ObserverSingleOne(IObserver iObserver) {
        this.iObserver = iObserver;
    }


    // wątkowi zarządzanemu przez ObserverSingleOne przekazujemy element Observatora

    // Wstrzykujemy obiekt Observera - który jest jednocześnie Clientem
    // ten obiekt observera będzie obserwował stan wykonania wątku
    // i jeżeli np. wątek zakończy się
    // to observer poinformuje o tym
    public void startWork() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(11);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.iObserver.notifyMe();
        });
        thread.start();
    }
}










































