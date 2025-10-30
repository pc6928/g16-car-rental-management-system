package src;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        Scanner sc = new Scanner(System.in);

        system.addCar(new Car("Toyota", "Camry", 2020, "ABC123", "Sedan", 45.0));
        system.addCustomer(new Customer("Alice", "alice@example.com", "D1234567"));

        System.out.println("=== Car Rental System ===");
        System.out.println("1. List Cars");
        System.out.println("2. Make Reservation");
        System.out.println("3. List Reservations");

        while (true) {
            System.out.print("\nChoose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> system.listCars();
                case 2 -> {
                    System.out.print("Enter car plate: ");
                    String plate = sc.nextLine();
                    System.out.print("Enter driver license: ");
                    String dl = sc.nextLine();
                    system.makeReservation(plate, dl, LocalDate.now(), LocalDate.now().plusDays(3));
                }
                case 3 -> system.listReservations();
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
