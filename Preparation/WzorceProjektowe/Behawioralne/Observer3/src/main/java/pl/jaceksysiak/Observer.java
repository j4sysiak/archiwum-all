package pl.jaceksysiak;

public class Observer implements IObserver {

    private String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void sendNewsletter(String mail) {
        System.out.println(name + " got email! " + mail);
    }
}
