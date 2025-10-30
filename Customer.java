public class Customer {
    private String id;
    private String name;
    private String email;
    private String licenseNumber;

    public Customer(String id, String name, String email, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getLicenseNumber() { return licenseNumber; }
}
