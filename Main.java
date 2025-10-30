import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Initialize system
        CarRentalSystem system = new CarRentalSystem();

        // Add some cars
        Car car1 = new Car("C1", "Toyota", "Camry", 50.0);
        Car car2 = new Car("C2", "Honda", "Civic", 45.0);
        
        system.addCar(car1);
        system.addCar(car2);

        // Add a customer
        Customer customer = new Customer("C1", "John Doe", "john@example.com", "DL123456");
        system.addCustomer(customer);

        // Find available cars
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);
        
        System.out.println("Available cars:");
        system.getAvailableCars(today, nextWeek).forEach(car -> 
            System.out.println(" - " + car.getDescription() + " (Rate: $" + car.calculateRate() + "/day)")
        );

        // Make a reservation and process payment
        try {
            System.out.println("\nCreating reservation...");
            Reservation reservation = system.makeReservation(customer, car1, today, nextWeek);
            System.out.println("Reservation created: " + reservation.getId());
            
            // Process payment
            System.out.println("\nProcessing payment...");
            Payment payment = system.processPayment(reservation, "CREDIT_CARD");
            System.out.println("Payment " + (payment != null ? "successful" : "failed") + "!");
            
            // Show reservation details
            System.out.println("\nReservation details:");
            System.out.println(" - Car: " + reservation.getCar().getDescription());
            System.out.println(" - Customer: " + reservation.getCustomer().getName());
            System.out.println(" - Period: " + reservation.getStartDate() + " to " + reservation.getEndDate());
            System.out.println(" - Total cost: $" + reservation.getTotalCost());
            
            // Return the car
            System.out.println("\nReturning the car...");
            reservation.returnCar();
            System.out.println("Car status: " + car1.getStatus());
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
