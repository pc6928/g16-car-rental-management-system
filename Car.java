public class Car {
    private String id;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private String carClass;
    private double dailyRate;
    private String status; // AVAILABLE, BOOKED, MAINTENANCE

    public Car(String id, String make, String model, int year, 
              String licensePlate, String carClass, double dailyRate) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.carClass = carClass;
        this.dailyRate = dailyRate;
        this.status = "AVAILABLE";
    }

    // Getters and setters
    public String getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getLicensePlate() { return licensePlate; }
    public String getCarClass() { return carClass; }
    public double getDailyRate() { return dailyRate; }
    public String getStatus() { return status; }
    
    public void setStatus(String status) { 
        this.status = status; 
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %d (%s) - $%.2f/day - %s", 
            make, model, year, licensePlate, dailyRate, status);
    }
}
