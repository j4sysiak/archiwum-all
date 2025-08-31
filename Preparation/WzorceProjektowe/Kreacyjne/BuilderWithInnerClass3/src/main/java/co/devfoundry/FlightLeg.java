package co.devfoundry;

public class FlightLeg {

    private final String from;
    private final String to;
    private int price;
    private boolean delayed;


    private FlightLeg(FlightLegBuilder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.delayed = builder.delayed;
        this.price = builder.price;
    }

//    public void setDelayed(boolean delayed) {
//        this.delayed = delayed;
//    }

//    public void setPrice(int price) {
//        this.price = price;
//    }

    @Override
    public String toString() {
        return "FlightLeg{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", price=" + price +
                ", delayed=" + delayed +
                '}';
    }





    // Immer class
    public static class FlightLegBuilder {
        private final String from;
        private final String to;
        private final boolean delayed;
        private int price;

        public FlightLegBuilder(String from, String to) {
            this.from = from;
            this.to = to;
            this.delayed = false;
        }

         //  nie może być bo from jest final, tak samo to i delayed
//        public FlightLegBuilder from(String from) {
//            this.from = from;
//            return this;
//        }

        //  price nie jest final więc można go wyciągać stąd:
        public FlightLegBuilder price(int price) {
            this.price = price;
            return this;
        }

        public FlightLeg build() {
            if (this.price == 0) {
                throw new IllegalStateException("Brak wymaganego pola - cena");
            }
            return new FlightLeg(this);
        }
    }
}