package Lab10.main.java.pr10.components;

import org.springframework.stereotype.Component;
import Lab10.main.java.pr10.interfaces.Programmer;


@Component
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is coding");
    }
}
