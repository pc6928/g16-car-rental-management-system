package src;

public class Car {
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private String carClass;
    private double dailyRate;
    private String status; // available, booked, maintenance

    public Car(String make, String model, int year, String licensePlate, String carClass, double dailyRate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.carClass = carClass;
        this.dailyRate = dailyRate;
        this.status = "available";
    }

    public String getLicensePlate() { return licensePlate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + ") - " + status;
    }
}
