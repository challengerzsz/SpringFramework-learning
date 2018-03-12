package pojo.impls;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pojo.Dessert;

//使用Component注解的Bean会将类名的首字母小写作为bean的id

@Component
@Qualifier("cold")
public class IceCream implements Dessert {
    public void showName() {
        System.out.print("IceCream");
    }
}
