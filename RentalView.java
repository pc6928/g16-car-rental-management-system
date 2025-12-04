import java.util.ArrayList;

/**
 * RentalView - View in MVC Pattern
 * 
 * WHY MVC View: Separates all console printing from business logic.
 * This makes it easy to change the UI (e.g., switch to GUI) without
 * touching the business logic. All display code is in one place.
 */
public class RentalView {
    
    /**
     * displayMenu - Shows the main menu options
     * WHY this method: Centralizes menu display logic
     */
    public void displayMenu() {
        System.out.println("\n=== Car Rental Management System ===");
        System.out.println("1. Rent a Car");
        System.out.println("2. Return a Car");
        System.out.println("3. View All Cars");
        System.out.println("4. View All Customers");
        System.out.println("5. View All Reservations");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    
    public void displayAllCars(ArrayList<Car> cars) {
        System.out.println("\n=== All Cars ===");
        if (cars.isEmpty()) { System.out.println("No cars available."); return; }
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            System.out.println("ID: " + c.getId() + " | " + c.getDescription() + 
                             " | Rate: $" + c.calculateRate() + "/day | Status: " + c.getStatus());
        }
    }
    
    public void displayAllCustomers(ArrayList<Customer> customers) {
        System.out.println("\n=== All Customers ===");
        if (customers.isEmpty()) { System.out.println("No customers registered."); return; }
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println("ID: " + c.getId() + " | Name: " + c.getName() + " | Email: " + c.getEmail());
        }
    }
    
    public void displayAllReservations(ArrayList<Reservation> reservations) {
        System.out.println("\n=== All Reservations ===");
        if (reservations.isEmpty()) { System.out.println("No reservations found."); return; }
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            System.out.println("Reservation ID: " + r.getId() + " | Car: " + r.getCar().getDescription() +
                             " | Customer: " + r.getCustomer().getName() + " | Dates: " + r.getStartDate() + 
                             " to " + r.getEndDate() + " | Total: $" + r.getTotalCost() + 
                             " | Status: " + r.getCar().getStatus());
        }
    }
    
    public void promptForCarId() { System.out.print("Enter Car ID: "); }
    public void promptForCustomerId() { System.out.print("Enter Customer ID: "); }
    public void displayMessage(String msg) { System.out.print(msg); }
    public void displayError(String err) { System.out.println("ERROR: " + err); }
    public void displaySuccess(String msg) { System.out.println("SUCCESS: " + msg); }
}

