import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Singleton class that manages the entire car rental system.
 * Implements the Singleton pattern to ensure only one instance exists.
 */
public class CarRentalSystem {
    // Singleton instance
    private static volatile CarRentalSystem instance;
    
    // Private constructor to prevent instantiation
    private CarRentalSystem() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.admin = new Admin("ADM001", "System Admin", "Administrator", "ALL");
    }
    
    /**
     * Returns the singleton instance of CarRentalSystem.
     * Uses double-checked locking for thread safety.
     */
    public static CarRentalSystem getInstance() {
        if (instance == null) {
            synchronized (CarRentalSystem.class) {
                if (instance == null) {
                    instance = new CarRentalSystem();
                }
            }
        }
        return instance;
    }
    private final List<Car> cars;
    private final List<Customer> customers;
    private final List<Reservation> reservations;
    private final List<Staff> staffMembers;
    private final Admin admin;

    // Car management
    public void addCar(Car car) {
        if (car != null && !cars.contains(car)) {
            cars.add(car);
        }
    }

    public List<Car> getAvailableCars() {
        return cars.stream()
                .filter(car -> "Available".equals(car.getStatus()))
                .collect(Collectors.toList());
    }

    public List<Car> searchAvailableCars(String dateRange) {
        // Simplified implementation - in a real system, this would check the date range
        return getAvailableCars();
    }

    // Customer management
    public void addCustomer(Customer customer) {
        if (customer != null && !customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public Customer findCustomerByName(String name) {
        return customers.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Reservation management
    public void createReservation(String customerName, String carId, String startDate, String endDate) {
        Customer customer = findCustomerByName(customerName);
        Car car = findCarById(carId);

        if (customer != null && car != null && "Available".equals(car.getStatus())) {
            String reservationId = "RES" + System.currentTimeMillis();
            Reservation reservation = new Reservation.Builder(reservationId, startDate, endDate, customer, car)
                .build();
            
            if (reservation.validateDates()) {
                reservations.add(reservation);
                car.setStatus("Booked");
                customer.addReservation(reservation);
                System.out.println("Reservation created: " + reservation);
            } else {
                System.out.println("Invalid dates for reservation");
            }
        } else {
            System.out.println("Could not create reservation. Check customer name and car availability.");
        }
    }
    
    private Car findCarById(String carId) {
        return cars.stream()
            .filter(c -> c.getPlate().equals(carId))
            .findFirst()
            .orElse(null);
    }

    public void initiatePayment(Reservation reservation) {
        if (reservation != null && reservations.contains(reservation)) {
            System.out.println("Processing payment of $" + reservation.getTotalCost() + 
                             " for reservation " + reservation.getReservationId());
            // In a real system, this would integrate with a payment processor
        }
    }

    // Staff management
    public void addStaff(Staff staff) {
        if (staff != null && !staffMembers.contains(staff)) {
            staffMembers.add(staff);
        }
    }

    // Utility methods
    public void listCars() {
        System.out.println("\nAvailable Cars:");
        getAvailableCars().forEach(System.out::println);
    }

    public void listCustomers() {
        System.out.println("\nRegistered Customers:");
        customers.forEach(System.out::println);
    }

    public void listReservations() {
        System.out.println("\nAll Reservations:");
        reservations.forEach(System.out::println);
    }
    
    // Getters
    public Admin getAdmin() { return admin; }
    public List<Car> getCars() { return new ArrayList<>(cars); }
    public List<Customer> getCustomers() { return new ArrayList<>(customers); }
    public List<Reservation> getReservations() { return new ArrayList<>(reservations); }
    public List<Staff> getStaffMembers() { return new ArrayList<>(staffMembers); }
}
