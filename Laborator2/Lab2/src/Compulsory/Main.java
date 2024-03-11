package Compulsory;

public class Main {
    static public void main(String[] args) {
        Depot depot = new Depot("Tatarasi", "Rozelor 123");
        System.out.println(depot);

        Vehicle vehicle = new Vehicle("ABC123", "Camioneta", 5000);
        System.out.println(vehicle);

        Client client1 = new Client("Dalida", "456 Fundatura Rozelor", ClientType.REGULAR);
        System.out.println(client1);

        Client client2 = new Client("Vlad", "34 Anton Pan", ClientType.PREMIUM);
        System.out.println(client2);
    }
}
