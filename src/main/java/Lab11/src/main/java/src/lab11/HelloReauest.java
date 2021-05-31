package src.lab11;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloReauest {
    @RequestMapping("/hello")
    public String getHello() {
        return "HelloWorld";
    }
}

