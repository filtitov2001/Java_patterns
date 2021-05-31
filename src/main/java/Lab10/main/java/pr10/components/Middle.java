package Lab10.main.java.pr10.components;

import org.springframework.stereotype.Component;
import Lab10.main.java.pr10.interfaces.Programmer;


@Component
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle is coding");
    }
}
