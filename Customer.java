import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String contactInfo;
    private String driverLicense;
    private List<Reservation> reservations;

    public Customer(String name, String contactInfo, String driverLicense) {
        this.customerId = "CUST" + System.currentTimeMillis();
        this.name = name;
        this.contactInfo = contactInfo;
        this.driverLicense = driverLicense;
        this.reservations = new ArrayList<>();
    }

    // Getters and setters
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
    public String getDriverLicense() { return driverLicense; }
    
    public void setName(String name) { this.name = name; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public void setDriverLicense(String driverLicense) { this.driverLicense = driverLicense; }

    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            reservations.add(reservation);
        }
    }

    public void viewReservations() {
        System.out.println("\nReservations for " + name + ":");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation r : reservations) {
                System.out.println("- " + r);
            }
        }
    }

    public void updateInfo(String name, String contactInfo) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
        if (contactInfo != null) {
            this.contactInfo = contactInfo;
        }
        System.out.println("Customer information updated successfully.");
    }
    
    @Override
    public String toString() {
        return String.format("Customer[ID: %s, Name: %s, Contact: %s, License: %s]",
            customerId, name, contactInfo, driverLicense);
    }
}
