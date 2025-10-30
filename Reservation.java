import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private String id;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // BOOKED, ACTIVE, RETURNED, CLOSED
    private double totalCost;
    private List<AddOn> addOns;

    public Reservation(String id, Customer customer, Car car, 
                      LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "BOOKED";
        this.addOns = new ArrayList<>();
        calculateTotal();
    }

    private void calculateTotal() {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        double addOnsCost = addOns.stream()
                                .mapToDouble(addon -> addon.getDailyRate() * days)
                                .sum();
        this.totalCost = (car.getDailyRate() * days) + addOnsCost;
    }

    // Add an add-on to the reservation
    public void addAddOn(AddOn addOn) {
        addOns.add(addOn);
        calculateTotal();
    }

    // Getters
    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public double getTotalCost() { return totalCost; }
    public List<AddOn> getAddOns() { return new ArrayList<>(addOns); }

    public void updateStatus(String status) {
        this.status = status;
        if ("RETURNED".equals(status)) {
            car.setStatus("AVAILABLE");
        } else if ("ACTIVE".equals(status)) {
            car.setStatus("BOOKED");
        }
    }

    @Override
    public String toString() {
        return String.format("Reservation #%s: %s to %s - %s - %s - $%.2f\nAdd-ons: %s", 
            id, startDate, endDate, customer.getName(), car, totalCost, addOns);
    }
}
