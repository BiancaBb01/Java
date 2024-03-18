package Homework;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {

    Map<LocalDate, TimeInterval<LocalTime>> getVisitingTimetable();

    default LocalTime getOpeningHoursByDate(LocalDate date) {
        // Obține orarul de vizitare al atracției
        Map<LocalDate, TimeInterval<LocalTime>> orarVizitare = getVisitingTimetable();

        // Verifică dacă orarul de vizitare conține informații pentru data specificată
        if (orarVizitare.containsKey(date)) {
            // Recuperează intervalul de timp pentru data specificată
            TimeInterval<LocalTime> interval = orarVizitare.get(date);
            // Returnează ora de început a intervalului
            return interval.getStart();
        }

        // Returnează null dacă orarul de vizitare nu conține informații pentru data specificată
        return null;
    }
}
