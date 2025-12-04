/**
 * Customer - Model class in MVC Pattern
 * 
 * WHY this class: Represents a customer in the system with all necessary information.
 * Uses encapsulation (private fields with public getters) to protect customer data.
 */
public class Customer {
    // Private fields - WHY private: Protects customer data from direct access
    private String id;
    private String name;
    private String email;
    private String licenseNumber;

    /**
     * Constructor - Creates a new customer
     * WHY this constructor: Initializes all required customer information
     */
    public Customer(String id, String name, String email, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    // Public getters - WHY public: Allow other classes to read customer data safely
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getLicenseNumber() { return licenseNumber; }
}
