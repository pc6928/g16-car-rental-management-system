import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    
    // Car management
    public void addCar(Car car) {
        cars.add(car);
    }
    
    public List<Car> getAvailableCars(LocalDate start, LocalDate end) {
        List<Car> available = new ArrayList<>();
        for (Car car : cars) {
            if (isCarAvailable(car, start, end)) {
                available.add(car);
            }
        }
        return available;
    }
    
    private boolean isCarAvailable(Car car, LocalDate start, LocalDate end) {
        if (!"AVAILABLE".equals(car.getStatus())) return false;
        
        for (Reservation r : reservations) {
            if (r.getCar() == car && isDateRangeOverlap(start, end, r.getStartDate(), r.getEndDate())) {
                return false;
            }
        }
        return true;
    }
    
    // Customer management
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    // Reservation management
    public Reservation makeReservation(Customer customer, Car car, LocalDate start, LocalDate end) {
        String reservationId = "R" + (reservations.size() + 1);
        if (!isCarAvailable(car, start, end)) {
            throw new IllegalStateException("Car not available");
        }
        
        Reservation reservation = new Reservation(reservationId, customer, car, start, end);
        reservations.add(reservation);
        return reservation;
    }
    
    // Payment processing
    public Payment processPayment(Reservation reservation, String paymentMethod) {
        String paymentId = "P" + (payments.size() + 1);
        Payment payment = new Payment(paymentId, reservation);
        payment.processPayment();
        payments.add(payment);
        return payment;
    }
    
    // Helper method
    private boolean isDateRangeOverlap(LocalDate start1, LocalDate end1, 
                                     LocalDate start2, LocalDate end2) {
        return !(end1.isBefore(start2) || start1.isAfter(end2));
    }

    // Getters
    public List<Car> getCars() { return new ArrayList<>(cars); }
    public List<Customer> getCustomers() { return new ArrayList<>(customers); }
    public List<Reservation> getReservations() { return new ArrayList<>(reservations); }
    public List<Payment> getPayments() { return new ArrayList<>(payments); }
}
