package src.polimorphism;

//        What is Coupling?
//        Coupling is a measure of how much a class is dependent on other classes. There should minimal
//        dependencies between classes. So, we should always aim for low coupling between classes.


class ShoppingCartEntry {
    public float price;
    public int quantity;
}

class ShoppingCart {
    public ShoppingCartEntry[] items;
}


class Order {
    private ShoppingCart cart;
    private float salesTax;

    public Order(ShoppingCart cart, float salesTax) {
        this.cart = cart;
        this.salesTax = salesTax;
    }

    // This method know the internal details of ShoppingCartEntry and
    // ShoppingCart classes. If there is any change in any of those
    // classes, this method also needs to change.
    // Method orderTotalPrice in Order class is coupled heavily with ShoppingCartEntry and
    // ShoppingCart classes.
    // It uses different properties (items, price, quantity) from these classes. If any of
    // these properties change, orderTotalPrice will also change. This is not good for Maintenance.
    public float orderTotalPrice() {
        float cartTotalPrice = 0;
        for (int i = 0; i < cart.items.length; i++) {
            cartTotalPrice += cart.items[i].price
                    * cart.items[i].quantity;
        }
        cartTotalPrice += cartTotalPrice * salesTax;
        return cartTotalPrice;
    }
}

public class TestCoupling {}


////////////////////////   SOLUTION
/*

class ShoppingCartEntry
{
    float price;
    int quantity;
    public float getTotalPrice()
    {
        return price *	quantity;
    }
}

class CartContents
{
    ShoppingCartEntry[]	items;
    public float getTotalPrice()
    {
        float totalPrice	=	0;
        for (ShoppingCartEntry	item:items)
        {
            totalPrice	+=	item.getTotalPrice();
        }
        return totalPrice;
    }
}

class Order
{
    private CartContents	cart;
    private float salesTax;
    public Order(CartContents	cart,	float salesTax)
    {
        this.cart =	cart;
        this.salesTax =	salesTax;
    }
    public float totalPrice()
    {
        return cart.getTotalPrice()	*	(1.0f	+	salesTax);
    }
}

*/