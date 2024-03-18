package Homework;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public abstract class Attraction implements Visitable, Payable {
    private final String name;
    private final Map<LocalDate, TimeInterval<LocalTime>> visitingTimetable;
    private final boolean visitable;

    public Attraction(String name) {
        this.name = name;
        this.visitingTimetable = new HashMap<>();
        this.visitable = true; // Implicit, all attractions are visitable
    }

    public boolean isVisitable() {
        return visitable;
    }

    public boolean isPayable() {
        return name.startsWith("Paid"); // Check if the name starts with "Paid"
    }

    public String getDescription() {
        return "This attraction is a museum dedicated to history.";
    }

    public void addVisitingTimetable(LocalDate date, TimeInterval<LocalTime> timeInterval) {
        visitingTimetable.put(date, timeInterval);
    }

    public TimeInterval<LocalTime> getVisitingTimetable(LocalDate date) {
        return visitingTimetable.get(date);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", visitingTimetable=" + visitingTimetable +
                '}';
    }

    public abstract <U> U getOpeningHour(java.time.LocalDate now);
}
