/**
 * Car - Model class in MVC Pattern
 * 
 * WHY Encapsulation (private fields with public getters/setters):
 * Private fields protect data from being changed incorrectly.
 * Public getters/setters allow controlled access. For example, we can
 * add validation in setStatus() if needed, without changing other code.
 */
public class Car {
    // Private fields - WHY private: Protects data from direct access
    private String id;
    private String make;
    private String model;
    private double baseRate;
    private String status = "AVAILABLE"; // Default status when car is created
    
    /**
     * Constructor - Creates a new Car object
     * WHY this constructor: Initializes all required car information
     */
    public Car(String id, String make, String model, double baseRate) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.baseRate = baseRate;
    }
    
    /**
     * calculateRate - Returns the daily rental rate
     * WHY this method: Separates rate calculation logic for future extensions
     */
    public double calculateRate() {
        return baseRate;
    }
    
    /**
     * getDescription - Returns a readable description of the car
     * WHY this method: Centralizes how we display car information
     */
    public String getDescription() {
        return make + " " + model;
    }
    
    // Public getters - WHY public: Allow other classes to read car data safely
    public String getId() { return id; }
    public String getStatus() { return status; }
    
    // Public setter - WHY public: Allow controlled modification of status
    public void setStatus(String status) { this.status = status; }
}