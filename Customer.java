package src;

public class Customer {
    private String name;
    private String contactInfo;
    private String driversLicense;

    public Customer(String name, String contactInfo, String driversLicense) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.driversLicense = driversLicense;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + driversLicense + ")";
    }
}
