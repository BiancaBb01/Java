package Homework;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class Trip {
    private List<Attraction> attractions;

    public Trip() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void displayVisitableNonPayableLocations() {
        List<Attraction> visitableNonPayableLocations = new ArrayList<>();

        // Filtrăm atracțiile care pot fi vizitate și nu necesită plată
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNonPayableLocations.add(attraction);
            }
        }

        // Sortăm lista de atracții după ora de deschidere
        visitableNonPayableLocations.sort(Comparator.comparing(attraction -> attraction.getOpeningHour(LocalDate.now())));

        // Afișăm locațiile vizitabile și nepalpabile sortate după ora de deschidere
        System.out.println("Visitable non-payable locations sorted by opening hour:");
        for (Attraction attraction : visitableNonPayableLocations) {
            System.out.println(attraction.getName() + " - Opening hour: " + attraction.getOpeningHour(LocalDate.now()));
        }
    }

    @Override
    public String toString() {
        return "Trip{" +
                "attractions=" + attractions +
                '}';
    }
}
