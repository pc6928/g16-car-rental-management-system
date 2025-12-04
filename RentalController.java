import java.time.LocalDate;
import java.util.Scanner;

/**
 * RentalController - Controller in MVC Pattern
 * 
 * WHY MVC Controller: Handles all business logic and coordinates between
 * the Model (data) and View (display). This keeps business rules separate
 * from display code, making the code easier to maintain and test.
 */
public class RentalController {
    // Reference to the singleton repository
    private RentalRepository repository;
    // Reference to the view for displaying information
    private RentalView view;
    // Scanner for reading user input
    private Scanner scanner;
    
    /**
     * Constructor - Initializes the controller
     * WHY this setup: Gets the singleton repository instance and creates a view
     */
    public RentalController() {
        repository = RentalRepository.getInstance();
        view = new RentalView();
        scanner = new Scanner(System.in);
    }
    
    /**
     * rentCar - Handles car rental with validation
     * WHY: Prevents renting unavailable cars and validates all inputs
     */
    public void rentCar() {
        view.promptForCarId();
        Car car = repository.findCarById(scanner.nextLine().trim());
        view.promptForCustomerId();
        Customer customer = repository.findCustomerById(scanner.nextLine().trim());
        
        if (car == null) { view.displayError("Car not found!"); return; }
        if (customer == null) { view.displayError("Customer not found!"); return; }
        if (!"AVAILABLE".equals(car.getStatus())) {
            view.displayError("Car is already rented! Status: " + car.getStatus());
            return;
        }
        
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startStr = scanner.nextLine().trim();
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endStr = scanner.nextLine().trim();
        
        try {
            LocalDate start = LocalDate.parse(startStr);
            LocalDate end = LocalDate.parse(endStr);
            if (end.isBefore(start)) {
                view.displayError("End date must be after start date!");
                return;
            }
            String resId = "RES" + System.currentTimeMillis();
            Reservation res = new Reservation(resId, customer, car, start, end);
            repository.addReservation(res);
            view.displaySuccess("Car rented successfully!");
            view.displayMessage("Reservation ID: " + resId + " | Total: $" + res.getTotalCost());
        } catch (Exception e) {
            view.displayError("Invalid date format! Use YYYY-MM-DD");
        }
    }
    
    /**
     * returnCar - Handles car return process
     * WHY: Validates reservation exists before returning
     */
    public void returnCar() {
        view.promptForCarId();
        Reservation res = repository.findReservationByCarId(scanner.nextLine().trim());
        if (res == null) {
            view.displayError("No active reservation found for this car!");
            return;
        }
        res.returnCar();
        repository.removeReservation(res);
        view.displaySuccess("Car returned successfully!");
        view.displayMessage("Car " + res.getCar().getDescription() + " is now available.");
    }
    
    public void viewAllCars() { view.displayAllCars(repository.getAllCars()); }
    public void viewAllCustomers() { view.displayAllCustomers(repository.getAllCustomers()); }
    public void viewAllReservations() { view.displayAllReservations(repository.getAllReservations()); }
    
    /**
     * initializeSampleData - Creates sample data for testing
     * WHY: Enables testing without manual data entry
     */
    public void initializeSampleData() {
        repository.addCar(CarFactory.createCar("C001", "Toyota", "Camry", 50.0));
        repository.addCar(CarFactory.createCar("C002", "Honda", "Accord", 55.0));
        repository.addCar(CarFactory.createCar("C003", "Ford", "Mustang", 80.0));
        repository.addCustomer(new Customer("CUST001", "John Doe", "john@email.com", "DL12345"));
        repository.addCustomer(new Customer("CUST002", "Jane Smith", "jane@email.com", "DL67890"));
    }
}

