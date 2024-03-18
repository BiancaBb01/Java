package Homework;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public abstract class Concert extends Attraction implements Payable {
    private double price; // Pretul concertului

    public Concert(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public Map<LocalDate, TimeInterval<LocalTime>> getVisitingTimetable() {
        return new HashMap<>();
    }

    @Override
    public boolean isVisitable() {
        return true; // Concerts are always visitable
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Concert{" +
                "price=" + price +
                '}';
    }
}
