package Lab10.main.java.pr10;

import Lab10.main.java.pr10.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Lab10.main.java.pr10.components.Junior;
import Lab10.main.java.pr10.components.Middle;
import Lab10.main.java.pr10.components.Senior;
import Lab10.main.java.pr10.config.BeanConfig;
import Lab10.main.java.pr10.interfaces.Programmer;


public class MainApplication {

    public static void main(String[] args) {


        //ApplicationContext context =
        //      new AnnotationConfigApplicationContext(BeanConfig.class);

        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        Programmer pr1 = context.getBean(Junior.class);
        Programmer pr2 = context.getBean(Middle.class);
        Programmer pr3 = context.getBean(Senior.class);
        pr1.doCoding();
        pr2.doCoding();
        pr3.doCoding();
    }
}
