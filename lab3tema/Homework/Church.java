package Homework;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public abstract class Church extends Attraction {

    public Church(String name) {
        super(name);
    }

    @Override
    public boolean isVisitable() {
        return true; // Church is always visitable
    }

    @Override
    public Map<LocalDate, TimeInterval<LocalTime>> getVisitingTimetable() {
        Map<LocalDate, TimeInterval<LocalTime>> visitingTimetable = new HashMap<>();
        // Add time interval for each date the church is open
        visitingTimetable.put(LocalDate.of(2024, 3, 18), new TimeInterval<>(LocalTime.of(9, 0), LocalTime.of(17, 0)));
        return visitingTimetable;
    }
}
