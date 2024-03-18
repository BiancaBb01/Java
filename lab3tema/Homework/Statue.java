package Homework;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public abstract class Statue extends Attraction {

    public Statue(String name) {
        super(name);
    }

    @Override
    public Map<LocalDate, TimeInterval<LocalTime>> getVisitingTimetable() {
        Map<LocalDate, TimeInterval<LocalTime>> visitingTimetable = new HashMap<>();
        // Add time interval for each date the statue is open
        visitingTimetable.put(LocalDate.of(2024, 3, 17), new TimeInterval<>(LocalTime.of(8, 0), LocalTime.of(16, 0)));
        return visitingTimetable;
    }

    @Override
    public boolean isVisitable() {
        return true; // The statue is always visitable
    }
}
