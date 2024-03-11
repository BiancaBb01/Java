package Compulsory;

public class Vehicle {
    private String licensePlate;
    private String type;
    private int capacity;
    // constructor
    public Vehicle(String licensePlate, String type, int capacity) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.capacity = capacity;
    }

    //definesc metodele get si set pentru fiecare atribut al clasei
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //suprascriu clasa toString pt a fi mai usor de citit
    @Override
    public String toString() {
        return "Vehicle{" + "licensePlate='" + licensePlate + '\'' + ", type='" + type + '\'' + ", capacity=" + capacity + '}';
    }


}
