package Lab6.Builder;// Java code to demonstrate Builder Pattern

// Driver class
public class BuilderDemo {
    public static void main(String args[]) {
        StudentReceiver sr = new StudentReceiver();
        System.out.println(sr.getStudent());
        StudentReceiver sr1 = new StudentReceiver();
        System.out.println("id = " + "1" + ", name = " + "Ram" +
                ", address = " + "Noida");
    }
} 

