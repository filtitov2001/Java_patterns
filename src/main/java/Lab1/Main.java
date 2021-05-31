
package Lab1;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements Predicate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static void main(String[] args) {
        Predicate<String> isEmail = email -> validate(email);
        System.out.println(isEmail.test("fil.titov61@gmail.com"));
        System.out.println(isEmail.test("fil.titov61"));
    }


    public static boolean validate(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean test(Object o) {
        return false;
    }
}

