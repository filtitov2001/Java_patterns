package Lab6.Prototype;// A Java program to demonstrate working of
// Prototype Design Pattern with example 
// of a ColorStore class to store existing objects. 

import java.util.HashMap;
import java.util.Map;


abstract class Color implements Cloneable {

    protected String colorName;

    abstract void addColor();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}


