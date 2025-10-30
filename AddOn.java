import java.util.ArrayList;
import java.util.List;

/**
 * Leaf class in the Composite pattern.
 * Represents an individual add-on item.
 */
public class AddOn implements AddOnComponent {
    private String addOnId;
    private String name;
    private String description;
    private double price;

    public AddOn(String addOnId, String name, String description, double price) {
        this.addOnId = addOnId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getAddOnId() { return addOnId; }
    
    @Override
    public String getName() { return name; }
    
    @Override
    public double getPrice() { return price; }
    
    @Override
    public String getDescription() { return description; }
    
    public void setPrice(double price) { this.price = price; }
    
    @Override
    public String toString() {
        return String.format("%s (%s): %s - $%.2f", name, addOnId, description, price);
    }
}

/**
 * Composite class in the Composite pattern.
 * Represents a package of add-ons.
 */
class AddOnPackage implements AddOnComponent {
    private String packageId;
    private String name;
    private String description;
    private List<AddOnComponent> addOns;

    public AddOnPackage(String packageId, String name, String description) {
        this.packageId = packageId;
        this.name = name;
        this.description = description;
        this.addOns = new ArrayList<>();
    }

    public void add(AddOnComponent addOn) {
        if (addOn != null) {
            addOns.add(addOn);
        }
    }

    public void remove(AddOnComponent addOn) {
        addOns.remove(addOn);
    }

    @Override
    public String getAddOnId() { return packageId; }
    
    @Override
    public String getName() { return name; }
    
    @Override
    public double getPrice() {
        return addOns.stream()
            .mapToDouble(AddOnComponent::getPrice)
            .sum();
    }
    
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(description);
        sb.append(" Includes: ");
        for (AddOnComponent addOn : addOns) {
            sb.append(addOn.getName()).append(", ");
        }
        return sb.toString().replaceAll(", $", "");
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s): %s - $%.2f", 
            name, packageId, getDescription(), getPrice());
    }
}

/**
 * Factory class for creating add-ons (Factory Method pattern).
 */
class AddOnFactory {
    public static AddOnComponent createAddOn(String type, String id, String name, String description, double price) {
        return new AddOn(id, name, description, price);
    }
    
    public static AddOnComponent createPackage(String id, String name, String description) {
        return new AddOnPackage(id, name, description);
    }
}
