// Car class with Decorator pattern for add-ons
public class Car {
    private String id;
    private String make;
    private String model;
    private double baseRate;
    private String status = "AVAILABLE";
    
    public Car(String id, String make, String model, double baseRate) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.baseRate = baseRate;
    }
    
    // Core methods
    public double calculateRate() {
        return baseRate;
    }
    
    public String getDescription() {
        return make + " " + model;
    }
    
    // Getters
    public String getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
