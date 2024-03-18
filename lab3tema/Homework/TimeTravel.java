package Homework;
import java.time.LocalTime;

class TimeInterval<T> {
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeInterval(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStart() {
        return startTime;
    }

    public LocalTime getEnd() {
        return endTime;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime;
    }
}
