package Lab10.main.java.pr10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import Lab10.main.java.pr10.components.Junior;
import Lab10.main.java.pr10.components.Middle;
import Lab10.main.java.pr10.components.Senior;

@Configuration
public class BeanConfig {
    @Bean
    public Junior junior() {
        return new Junior();
    }

    @Bean
    public Middle middle() {
        return new Middle();
    }

    @Bean
    public Senior senior() {
        return new Senior();
    }
}
