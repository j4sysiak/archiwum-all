package pl.jaceksysiak;

public class Main {

    public static void main(String[] args) {
        Blog blog = new Blog();

        IObserver user1 = new Observer("Jacek");
        blog.addToSubscribents(user1);

        IObserver user2 = new Observer("Adam");
        blog.addToSubscribents(user2);

        IObserver user3 = new Observer("Wacek");
        blog.addToSubscribents(user3);

        blog.startWork1();
        blog.startWork2();
    }
}
