package Compulsory;

public class Depot {
    private String name;
    private String location;

    public Depot(String name, String location) {
        this.name = name;
        this.location = location;
    }

    //definesc metodele get si set pentru fiecare atribut al clasei
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //suprascriu clasa toString pt a fi mai usor de citit
    @Override
    public String toString() {
        return "Depot{" + "name='" + name + '\'' + ", location='" + location + '\'' + '}';
    }

}
