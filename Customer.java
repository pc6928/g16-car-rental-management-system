public class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String driverLicense;

    public Customer(String id, String name, String email, String phone, String driverLicense) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.driverLicense = driverLicense;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDriverLicense() { return driverLicense; }

    @Override
    public String toString() {
        return String.format("%s (ID: %s, License: %s)", name, id, driverLicense);
    }
}
