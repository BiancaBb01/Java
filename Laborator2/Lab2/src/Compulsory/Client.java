package Compulsory;

public class Client {
    private String name;
    private String address;
    private ClientType type;

    public Client(String name, String address, ClientType type) {
        this.name = name;
        this.address = address;
        this.type = type;
    }

    //definesc metodele get si set pentru fiecare atribut al clasei
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    //suprascriu clasa toString pt a fi mai usor de citit
    @Override
    public String toString() {
        return "Client{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", type=" + type + '}';
    }

}


