import java.util.Scanner;

/**
 * Main - Entry point for the Car Rental Management System
 * 
 * This is where the program starts. It creates the controller
 * and handles the main menu loop, delegating all business logic to the controller.
 */
public class Main {
    
    public static void main(String[] args) {
        RentalController controller = new RentalController();
        controller.initializeSampleData();
        RentalView view = new RentalView();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            view.displayMenu();
            String choice = scanner.nextLine().trim();
            if ("1".equals(choice)) controller.rentCar();
            else if ("2".equals(choice)) controller.returnCar();
            else if ("3".equals(choice)) controller.viewAllCars();
            else if ("4".equals(choice)) controller.viewAllCustomers();
            else if ("5".equals(choice)) controller.viewAllReservations();
            else if ("6".equals(choice)) {
                view.displayMessage("Thank you for using Car Rental Management System!\n");
                break;
            } else {
                view.displayError("Invalid choice! Please enter 1-6.");
            }
        }
        scanner.close();
    }
}

