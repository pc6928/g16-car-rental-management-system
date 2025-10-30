import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private String id;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    
    public Reservation(String id, Customer customer, Car car, 
                      LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = calculateTotal();
        car.setStatus("BOOKED");
    }
    
    private double calculateTotal() {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return car.calculateRate() * days;
    }
    
    // Getters
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }
    
    public void returnCar() {
        car.setStatus("AVAILABLE");
    }
}
