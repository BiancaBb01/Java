package Compulsory;
class Statue implements Visitable {
    private String name;

    public Statue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
