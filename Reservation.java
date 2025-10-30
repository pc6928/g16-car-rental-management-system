package src;

import java.time.LocalDate;

public class Reservation {
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // Booked, Active, Returned, Closed

    public Reservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Booked";
    }

    public void activate() { this.status = "Active"; }
    public void returnCar() { this.status = "Returned"; }
    public void close() { this.status = "Closed"; }

    @Override
    public String toString() {
        return "Reservation for " + customer.getName() + " - " + car.getLicensePlate() + " [" + status + "]";
    }
}
