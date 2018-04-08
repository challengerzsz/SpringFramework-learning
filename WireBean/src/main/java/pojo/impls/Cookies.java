package pojo.impls;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pojo.Dessert;

import java.lang.annotation.Repeatable;

@Component
@Qualifier("cookies")

public class Cookies implements Dessert {
    public void showName() {
        System.out.println("Cookies");
    }
}
