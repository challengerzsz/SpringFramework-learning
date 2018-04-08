package pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import pojo.impls.CDPlayer;
import pojo.impls.MagicExistsCondition;
import pojo.impls.NewPeppers;
import pojo.impls.SgtPeppers;

@Configuration
@ComponentScan
public class CDPlayerConfig {

//    @Bean
//    public CompactDisc sgtPeppers() {
//        return new SgtPeppers();
//    }
//
//    public CompactDisc randomCD() {
//        int choice = (int) Math.floor(Math.random() * 2);
//        if (choice == 0) {
//            return new SgtPeppers();
//        } else {
//            return new NewPeppers();
//        }
//    }
//
//    @Bean
//    public CDPlayer cdPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }

//    @Bean
//    public CDPlayer cdPlayer(CompactDisc compactDisc) {
//        return new CDPlayer(compactDisc);
//    }
//
//    @Bean
//    public CDPlayer cdPlayer(CompactDisc compactDisc) {
//        CDPlayer cdPlayer = new CDPlayer(compactDisc);
//        cdPlayer.setCd(compactDisc);
//        return cdPlayer;
//    }

//    @Bean
//    public CDPlayer anotherCDPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }
//
//    @Bean
//    @Conditional(MagicExistsCondition.class)
//    public MagicBean magicBean() {
//        return new MagicBean();
//    }
}
