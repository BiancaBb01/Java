package Compulsory;
public class Main {
    public static void main(String[] args) {
        // Crearea unei călătorii
        Trip trip = new Trip("Paris", "Vara");

        // Adăugarea atracțiilor în călătorie
        Statue eiffelTower = new Statue("Turnul Eiffel");
        trip.addAttraction(eiffelTower);

        Church notreDame = new Church("Notre Dame", 10.0, "Every Day", "4:00");
        trip.addAttraction(notreDame);

        Concert concert = new Concert("Concert Rock", 25.0);

        // Vizitarea atracțiilor din călătorie
        for (Object attraction : trip.getAttractions()) {

        }

        // Obținerea prețului de intrare pentru un concert
        System.out.println("Pretul pentru " + concert.getName() + ": $" + concert.getEntranceFee());
        System.out.println("Ultima vacanta a fost in " + trip.getCityName() + " " + trip.getTimePeriod() + ".");

    }
}
