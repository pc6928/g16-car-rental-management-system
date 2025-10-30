// Simple class for rental add-ons
public class AddOn {
    private String name;
    private double dailyRate;

    public AddOn(String name, double dailyRate) {
        this.name = name;
        this.dailyRate = dailyRate;
    }

    public String getName() { return name; }
    public double getDailyRate() { return dailyRate; }
    
    @Override
    public String toString() {
        return name + " (" + dailyRate + "/day)";
    }
}
