package jaceksysiak.model;

public class Book {
    private String title;
    private Double price;

    public Book(String title, Double price) {
        this.title=title;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
