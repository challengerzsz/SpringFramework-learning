package pojo.impls;

import org.springframework.stereotype.Component;
import pojo.Dessert;

@Component
public class Cookies implements Dessert {
    public void showName() {
        System.out.println("Cookies");
    }
}
