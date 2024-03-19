package Compulsory;

class Passenger extends Person {

    public Passenger(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Passenger: " + getName();
    }
}
