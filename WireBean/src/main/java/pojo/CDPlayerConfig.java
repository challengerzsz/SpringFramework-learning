package pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pojo.impls.NewPeppers;
import pojo.impls.SgtPeppers;

@Configuration
@ComponentScan
public class CDPlayerConfig {

    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CompactDisc randomCD() {
        int choice = (int) Math.floor(Math.random() * 2);
        if (choice == 0) {
            return new SgtPeppers();
        } else {
            return new NewPeppers();
        }
    }
}
