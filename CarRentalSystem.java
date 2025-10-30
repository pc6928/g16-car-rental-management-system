import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Reservation> reservations;
    private List<Payment> payments;

    public CarRentalSystem() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    // Car management
    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAvailableCars(LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        
        for (Car car : cars) {
            if (isCarAvailable(car, startDate, endDate)) {
                availableCars.add(car);
            }
        }
        
        return availableCars;
    }

    // Customer management
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Reservation management
    public boolean makeReservation(Customer customer, Car car, 
                                 LocalDate startDate, LocalDate endDate) {
        if (!isCarAvailable(car, startDate, endDate)) {
            return false;
        }

        String reservationId = "RES" + System.currentTimeMillis();
        Reservation reservation = new Reservation(
            reservationId, customer, car, startDate, endDate);
        reservations.add(reservation);
        car.setStatus("BOOKED");
        return true;
    }
    
    // Add an add-on to a reservation
    public void addAddOnToReservation(String reservationId, AddOn addOn) {
        for (Reservation r : reservations) {
            if (r.getId().equals(reservationId)) {
                r.addAddOn(addOn);
                break;
            }
        }
    }

    // Payment processing
    public Payment processPayment(Reservation reservation, String paymentMethod) {
        String paymentId = "PAY" + System.currentTimeMillis();
        Payment payment = new Payment(paymentId, reservation, paymentMethod);
        boolean success = payment.processPayment();
        
        if (success) {
            payments.add(payment);
            return payment;
        }
        return null;
    }

    // Helper methods
    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        if (!car.getStatus().equals("AVAILABLE")) {
            return false;
        }
        
        for (Reservation r : reservations) {
            if (r.getCar().equals(car) && 
                isDateRangeOverlap(
                    r.getStartDate(), r.getEndDate(), 
                    startDate, endDate) &&
                !r.getStatus().equals("CLOSED")) {
                return false;
            }
        }
        return true;
    }

    private boolean isDateRangeOverlap(
        LocalDate start1, LocalDate end1, 
        LocalDate start2, LocalDate end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

    // Getters
    public List<Car> getCars() { return new ArrayList<>(cars); }
    public List<Customer> getCustomers() { return new ArrayList<>(customers); }
    public List<Reservation> getReservations() { return new ArrayList<>(reservations); }
    public List<Payment> getPayments() { return new ArrayList<>(payments); }
}
