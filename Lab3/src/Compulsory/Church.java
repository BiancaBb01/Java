package Compulsory;
import Compulsory.Payable;
import Compulsory.Visitable;
class Church implements Visitable, Payable {
    private String name;
    private double entranceFee;
    private String OpeningDays;
    private String OpeningHours;
    public static String getname;

    public Church(String name, double entranceFee, String openingDays, String openingHours) {
        this.name = name;
        this.entranceFee = entranceFee;
        OpeningDays = openingDays;
        OpeningHours = openingHours;
    }

    public static String getname() {
        return getname;
    }

    public String getName() {
        return getname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEntranceFee(double entranceFee) {
        this.entranceFee = entranceFee;
    }

    public void setOpeningDays(String openingDays) {
        OpeningDays = openingDays;
    }

    public void setOpeningHours(String openingHours) {
        OpeningHours = openingHours;
    }

    @Override
    public double getEntranceFee() {
        return entranceFee;
    }

    @Override
    public String getOpeningDays() {
        return null;
    }

    @Override
    public String getOpeningHours() {
        return null;
    }
}