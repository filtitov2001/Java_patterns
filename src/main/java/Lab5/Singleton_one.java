package Lab5;

public class Singleton_one {
    private static Singleton_one SINGLE;

    private Singleton_one() {
    }

    public static Singleton_one getInstance() {
        if (SINGLE == null) {
            synchronized (Singleton_one.class) {
                SINGLE = new Singleton_one();
            }
        }
        return SINGLE;
    }
}
// lazy initialization method