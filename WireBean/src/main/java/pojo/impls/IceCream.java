package pojo.impls;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pojo.Dessert;

@Component
@Primary
public class IceCream implements Dessert {
    public void showName() {
        System.out.print("IceCream");
    }
}
