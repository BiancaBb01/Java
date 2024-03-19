package Compulsory;


public class Driver extends Person {

    public Driver(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Driver: " + getName();
    }
}
