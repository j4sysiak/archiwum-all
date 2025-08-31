public class Program {

    static IPrinter getPrinter(Boolean x) {
        if (x){
            return new HP();
        }
        return new Cannon();
    }


    public static void main(String[] args) {
        IPrinter myUsedPrinter = getPrinter(false);
        System.out.println("myUsedPrinter: " + myUsedPrinter.getClass());

        myUsedPrinter.print("bla bla bla ...");
    }
}