package Lab5;

public class Singleton_three {
    private static Singleton_three SINGLE;

    private Singleton_three() {
    }

    public static Singleton_three getInstance() {
        if (SINGLE == null) {
            synchronized (Singleton_three.class) {
                if (SINGLE == null) {
                    SINGLE = new Singleton_three();
                }
            }
        }
        return SINGLE;
    }
}

/**
 * Lazy Initialization With Double Lock Method
 */