import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mvc.xml")
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

//    @Autowired
//    private ShoppingCart shoppingCart;

    @Autowired
    @Qualifier("cold")
    private Dessert dessert;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
//    @Profile("test")
    public void play() {
        //测试cd已经成功自动装配为SgtPeppers的实例
        //cd.play();
//        player.play();
//        assertEquals("Playing Sgt. MixSound by zsz", log.getLog());
        dessert.showName();
        assertEquals("IceCream" , log.getLog());
    }

//    @Test
//    public void printShoppingCart() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//        ShoppingCart shoppingCart = (ShoppingCart) context.getBean("shoppingCart");
//        shoppingCart.print();
//    }
}
