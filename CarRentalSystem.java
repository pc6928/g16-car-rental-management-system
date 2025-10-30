package src;

import java.util.*;
import java.time.LocalDate;

public class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added: " + car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer);
    }

    public void makeReservation(String licensePlate, String driversLicense, LocalDate start, LocalDate end) {
        Car car = cars.stream().filter(c -> c.getLicensePlate().equals(licensePlate)).findFirst().orElse(null);
        Customer customer = customers.stream().filter(c -> c.toString().contains(driversLicense)).findFirst().orElse(null);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        if (!car.getStatus().equals("available")) {
            System.out.println("Car not available.");
            return;
        }

        Reservation res = new Reservation(customer, car, start, end);
        reservations.add(res);
        car.setStatus("booked");
        System.out.println("Reservation created: " + res);
    }

    public void listCars() {
        System.out.println("Cars:");
        for (Car car : cars) {
            System.out.println("- " + car);
        }
    }

    public void listReservations() {
        System.out.println("Reservations:");
        for (Reservation res : reservations) {
            System.out.println("- " + res);
        }
    }
}
