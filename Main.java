import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Initialize the car rental system
        CarRentalSystem system = new CarRentalSystem();
        
        // Add some cars to the system
        System.out.println("Adding cars to the system...");
        Car car1 = new Car("C001", "Toyota", "Camry", 2022, "ABC123", "Sedan", 50.0);
        Car car2 = new Car("C002", "Honda", "CR-V", 2023, "XYZ789", "SUV", 70.0);
        
        system.addCar(car1);
        system.addCar(car2);
        
        // Add a customer
        System.out.println("\nAdding a customer...");
        Customer customer = new Customer("CUST001", "John Doe", "john@example.com", "555-1234", "DL123456");
        system.addCustomer(customer);
        
        // Display available cars
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);
        System.out.println("\nAvailable cars for rent from " + today + " to " + nextWeek + ":");
        system.getAvailableCars(today, nextWeek).forEach(System.out::println);
        
        // Make a reservation
        System.out.println("\nMaking a reservation...");
        boolean reservationSuccess = system.makeReservation(customer, car1, today, nextWeek);
        
        if (reservationSuccess) {
            System.out.println("Reservation successful!");
            
            // Add some add-ons
            System.out.println("\nAdding add-ons to the reservation...");
            AddOn childSeat = new AddOn("Child Seat", 5.0);
            AddOn gps = new AddOn("GPS Navigation", 10.0);
            
            // Get the reservation ID (in a real app, you'd get this from the reservation object)
            String reservationId = system.getReservations().get(0).getId();
            
            system.addAddOnToReservation(reservationId, childSeat);
            system.addAddOnToReservation(reservationId, gps);
            
            // Process payment
            System.out.println("\nProcessing payment...");
            Payment payment = system.processPayment(
                system.getReservations().get(0), 
                "CREDIT_CARD"
            );
            
            if (payment != null) {
                System.out.println("Payment successful!");
                System.out.println("Payment details: " + payment);
            } else {
                System.out.println("Payment failed!");
            }
            
            // Show all reservations
            System.out.println("\nAll reservations:");
            system.getReservations().forEach(System.out::println);
            
            // Show updated car status
            System.out.println("\nUpdated car status:");
            system.getCars().forEach(System.out::println);
        } else {
            System.out.println("Failed to make reservation. Car not available.");
        }
    }
}
