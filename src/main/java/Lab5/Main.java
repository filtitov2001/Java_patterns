package Lab5;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Singleton_one singletonOne = Singleton_one.getInstance();
        Singleton_one singleton_one = Singleton_one.getInstance();
        Singleton_two singleton_two = Singleton_two.getInstance();
        Singleton_two singletonTwo = Singleton_two.getInstance();
        Singleton_three singleton_three = Singleton_three.getInstance();
        Singleton_three singletonThree = Singleton_three.getInstance();
        System.out.println(singleton_one);
        // System.out.println(singletonOne);
        System.out.println(singleton_two);
        //  System.out.println(singletonTwo);
        System.out.println(singleton_three);
        // System.out.println(singletonThree);
    }

}
