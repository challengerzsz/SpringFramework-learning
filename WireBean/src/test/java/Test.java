import org.springframework.beans.factory.annotation.Autowired;
import pojo.ShoppingCart;

public class Test {

    @Autowired
    private static ShoppingCart shoppingCart;

    public static void main(String[] args) {
        shoppingCart.print();
    }
}
