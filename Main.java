public class Main {
    public static void main(String[] args) {
        System.out.println("=== Car Rental Management System ===");

        // Get the singleton instance of CarRentalSystem
        CarRentalSystem system = CarRentalSystem.getInstance();

        // Initialize sample data
        initializeSampleData(system);

        // Display system status
        displaySystemStatus(system);

        System.out.println("\nSystem running... (placeholder for console menu or UI)");
    }

    private static void initializeSampleData(CarRentalSystem system) {
        // Add sample cars
        system.addCar(new Car("ABC123", "Toyota", "Corolla", 2020, "Compact", 50.0, "Available"));
        system.addCar(new Car("XYZ789", "BMW", "X5", 2022, "SUV", 120.0, "Available"));

        // Add sample customers
        system.addCustomer(new Customer("John Doe", "john@example.com", "DL12345"));
        system.addCustomer(new Customer("Jane Smith", "jane@example.com", "DL98765"));

        // Create a sample reservation
        system.createReservation("John Doe", "ABC123", "2025-10-10", "2025-10-15");
    }

    private static void displaySystemStatus(CarRentalSystem system) {
        // Display available cars
        System.out.println("\n=== Available Cars ===");
        system.listCars();

        // Display all customers
        System.out.println("\n=== Registered Customers ===");
        system.listCustomers();

        // Display all reservations
        System.out.println("\n=== Active Reservations ===");
        system.listReservations();
    }
}
