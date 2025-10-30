public class Car {
    private String carId;
    private String make;
    private String model;
    private int year;
    private String plate;
    private String carClass;
    private double dailyRate;
    private String status; // Available, Booked, Maintenance

    // Constructor matching the one used in Main.java
    public Car(String plate, String make, String model, int year, String carClass, double dailyRate, String status) {
        this.carId = plate; // Using plate as carId since that's what's being passed in Main.java
        this.make = make;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.carClass = carClass;
        this.dailyRate = dailyRate;
        this.status = status;
    }
    
    // Original constructor for backward compatibility
    public Car(String carId, String make, String model, int year, String plate, String carClass, double dailyRate, String status) {
        this(plate, make, model, year, carClass, dailyRate, status); // Reuse the new constructor
        this.carId = carId; // In case carId is different from plate
    }

    public void updateStatus(String newStatus) {
        // Update car status (e.g., Available → Booked)
    }

    public boolean isAvailable() {
        // Return true if car is available
        return false;
    }

    public boolean calculateAvailability(String[] dates) {
        // Check if car is available for given date range
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d (Plate: %s, Class: %s, Rate: $%.2f/day, Status: %s)",
                make, model, year, plate, carClass, dailyRate, status);
    }
    
    // Getters and setters
    public String getCarId() { return carId; }
    public String getPlate() { return plate; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getCarClass() { return carClass; }
    public double getDailyRate() { return dailyRate; }
    public String getStatus() { return status; }
    
    public void setDailyRate(double rate) { this.dailyRate = rate; }
    public void setStatus(String status) { this.status = status; }
    
    /**
     * Gets a description of the car including its make, model, and year.
     * This method is used by the Decorator pattern to build the car's description.
     */
    public String getDescription() {
        return String.format("%d %s %s", year, make, model);
    }
}
