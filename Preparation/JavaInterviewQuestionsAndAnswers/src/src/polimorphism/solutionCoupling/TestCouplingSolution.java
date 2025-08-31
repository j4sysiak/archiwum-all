package src.polimorphism.solutionCoupling;

class ShoppingCartEntry {
    float price;
    int quantity;

    public float getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    ShoppingCartEntry[] items;

    public float getTotalPrice() {
        float totalPrice = 0;
        for (ShoppingCartEntry item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}

class Order {
    private ShoppingCart cart;
    private float salesTax;

    public Order(ShoppingCart cart, float salesTax) {
        this.cart = cart;
        this.salesTax = salesTax;
    }

    public float totalPrice() {
        return cart.getTotalPrice() * (1.0f + salesTax);
    }
}

public class TestCouplingSolution {

    public static void main(String[] args) {

    }
}

