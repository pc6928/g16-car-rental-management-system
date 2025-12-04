import java.util.ArrayList;

/**
 * RentalRepository - Singleton Pattern
 * 
 * WHY Singleton: We need ONE shared database in memory for the entire application.
 * If we created multiple instances, each would have separate data, causing data loss.
 * This ensures all parts of the application access the same cars, customers, and reservations.
 */
public class RentalRepository {
    // Private static instance - only one will ever exist
    private static RentalRepository instance = null;
    
    // Private fields to store our data
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Reservation> reservations;
    
    /**
     * Private constructor - prevents other classes from creating instances
     * WHY private: Forces everyone to use getInstance() to get the same instance
     */
    private RentalRepository() {
        // Initialize empty lists when repository is first created
        cars = new ArrayList<Car>();
        customers = new ArrayList<Customer>();
        reservations = new ArrayList<Reservation>();
    }
    
    /**
     * getInstance() - Returns the single instance of RentalRepository
     * WHY this method: This is the ONLY way to get the repository instance.
     * If it doesn't exist yet, we create it. Otherwise, we return the existing one.
     */
    public static RentalRepository getInstance() {
        if (instance == null) {
            instance = new RentalRepository();
        }
        return instance;
    }
    
    public void addCar(Car car) { cars.add(car); }
    public void addCustomer(Customer customer) { customers.add(customer); }
    public void addReservation(Reservation reservation) { reservations.add(reservation); }
    public ArrayList<Car> getAllCars() { return cars; }
    public ArrayList<Customer> getAllCustomers() { return customers; }
    public ArrayList<Reservation> getAllReservations() { return reservations; }
    
    /**
     * findCarById - Searches for a car by ID (accepts "C001", "001", or "1")
     * WHY flexible matching: Convenience feature - users don't need to type prefix
     */
    public Car findCarById(String carId) {
        return findCarByIdHelper(cars, carId, "C");
    }
    
    /**
     * findCustomerById - Searches for a customer by ID (accepts "CUST001", "001", or "1")
     * WHY flexible matching: Convenience feature - users don't need to type prefix
     */
    public Customer findCustomerById(String customerId) {
        return findCustomerByIdHelper(customers, customerId, "CUST");
    }
    
    // Helper methods - WHY: Eliminates code duplication with flexible ID matching
    private Car findCarByIdHelper(ArrayList<Car> list, String id, String prefix) {
        String[] idsToTry = {id, prefix + id};
        try { idsToTry = new String[]{id, prefix + id, prefix + String.format("%03d", Integer.parseInt(id))}; }
        catch (NumberFormatException e) {}
        for (int j = 0; j < idsToTry.length; j++) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(idsToTry[j])) return list.get(i);
            }
        }
        return null;
    }
    
    private Customer findCustomerByIdHelper(ArrayList<Customer> list, String id, String prefix) {
        String[] idsToTry = {id, prefix + id};
        try { idsToTry = new String[]{id, prefix + id, prefix + String.format("%03d", Integer.parseInt(id))}; }
        catch (NumberFormatException e) {}
        for (int j = 0; j < idsToTry.length; j++) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(idsToTry[j])) return list.get(i);
            }
        }
        return null;
    }
    
    /**
     * findReservationByCarId - Finds active reservation for a car
     * WHY: Validates car availability before rental
     */
    public Reservation findReservationByCarId(String carId) {
        Car car = findCarById(carId);
        if (car == null) return null;
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            if (r.getCar().getId().equals(car.getId()) && "BOOKED".equals(r.getCar().getStatus())) {
                return r;
            }
        }
        return null;
    }
    
    /**
     * removeReservation - Removes a reservation from the list
     * WHY: Clean up when car is returned
     */
    public void removeReservation(Reservation reservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId().equals(reservation.getId())) {
                reservations.remove(i);
                break;
            }
        }
    }
}

