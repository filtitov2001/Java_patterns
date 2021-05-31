package Lab3;

import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<Integer, String> mapSync = new MapSync<>();



    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 11; i++) {
                addElToMapSync(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 11; i < 21; i++) {
                addElToMapSync(i);
            }
        });

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sync map:");
        mapSync.forEach((key, value) -> System.out.println(key + ": " + value));

        Set<Integer> set = new MySet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Runnable runnable = ()-> {
            for (int i = 0; i < 5000; i++) {
                set.add(i);

            }
        };

        Thread threadd = new Thread(runnable);
        Thread threaddd = new Thread(runnable);

        threadd.start();
        threaddd.start();

        Thread.sleep(3000);

        System.out.println("Set: " + set.size());

    }

    private static void addElToMapSync(int i) {
        mapSync.put(i, "el_" + i);
    }
}
