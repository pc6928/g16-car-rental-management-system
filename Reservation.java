import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a car rental reservation.
 * Uses Builder pattern for object creation.
 */
public class Reservation {
    private String reservationId;
    private String startDate;
    private String endDate;
    private double totalCost;
    private String status; // Booked, Active, Returned, Closed
    private Customer customer;
    private Car car;
    private List<AddOn> addOns;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Private constructor to force use of Builder
    private Reservation(Builder builder) {
        this.reservationId = builder.reservationId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.customer = builder.customer;
        this.car = builder.car;
        this.addOns = new ArrayList<>(builder.addOns);
        this.status = "Booked";
        this.totalCost = calculateTotal();
    }
    
    /**
     * Builder class for creating Reservation objects.
     * Implements the Builder pattern for flexible object creation.
     */
    public static class Builder {
        // Required parameters
        private final String reservationId;
        private final String startDate;
        private final String endDate;
        private final Customer customer;
        private final Car car;
        
        // Optional parameters - initialized to default values
        private List<AddOn> addOns = new ArrayList<>();
        
        public Builder(String reservationId, String startDate, String endDate, Customer customer, Car car) {
            this.reservationId = reservationId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.customer = customer;
            this.car = car;
        }
        
        public Builder addOns(List<AddOn> addOns) {
            this.addOns = addOns;
            return this;
        }
        
        public Builder addAddOn(AddOn addOn) {
            this.addOns.add(addOn);
            return this;
        }
        
        public Reservation build() {
            return new Reservation(this);
        }
    }

    public double calculateTotal() {
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            long diffInMillies = Math.abs(end.getTime() - start.getTime());
            int days = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
            
            double addOnsTotal = addOns.stream()
                .mapToDouble(AddOn::getPrice)
                .sum();
                
            return (days * car.getDailyRate()) + addOnsTotal;
        } catch (ParseException e) {
            System.err.println("Error parsing dates: " + e.getMessage());
            return 0.0;
        }
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
        if ("Returned".equals(newStatus)) {
            car.setStatus("Available");
        } else if ("Booked".equals(newStatus)) {
            car.setStatus("Booked");
        }
    }

    public boolean validateDates() {
        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return !end.before(start) && !start.before(new Date());
        } catch (ParseException e) {
            return false;
        }
    }

    public void addAddOn(AddOn addOn) {
        if (addOn != null) {
            addOns.add(addOn);
            this.totalCost = calculateTotal();
        }
    }
    
    // Getters and setters
    public String getReservationId() { return reservationId; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }
    public String getStatus() { return status; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public List<AddOn> getAddOns() { return new ArrayList<>(addOns); }
    
    @Override
    public String toString() {
        return String.format("Reservation #%s: %s to %s - %s (Car: %s %s, Total: $%.2f)",
            reservationId, startDate, endDate, customer.getName(), 
            car.getMake(), car.getModel(), totalCost);
    }
}
