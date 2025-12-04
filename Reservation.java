import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Reservation - Model class in MVC Pattern
 * 
 * WHY this class: Represents a rental reservation linking a customer to a car
 * for specific dates. Encapsulates all reservation logic including cost calculation.
 */
public class Reservation {
    private String id;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    
    /**
     * Constructor - Creates a new reservation
     * WHY sets status to BOOKED: Immediately marks car as unavailable when reservation is created
     */
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
    
    /**
     * calculateTotal - Calculates total rental cost based on days and rate
     * WHY private: Internal calculation - only called during construction
     * WHY +1: Includes both start and end dates in the rental period
     */
    private double calculateTotal() {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return car.calculateRate() * days;
    }
    
    // Public getters - WHY: Allow other classes to read reservation data safely
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }
    
    /**
     * returnCar - Marks the car as available again
     * WHY this method: Centralizes the return logic in the Reservation class
     */
    public void returnCar() {
        car.setStatus("AVAILABLE");
    }
}

