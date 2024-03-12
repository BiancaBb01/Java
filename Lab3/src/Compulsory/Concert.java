package Compulsory;
class Concert implements Payable {
    private String name;
    private double ticketPrice;

    public Concert(String name, double ticketPrice) {
        this.name = name;
        this.ticketPrice = ticketPrice;
    }


    @Override
    public double getEntranceFee() {
        return ticketPrice;
    }

    public String getName() {
        return name;
    }
}

