/**
 * Component interface for the Composite pattern.
 * Defines common operations for both simple and composite add-ons.
 */
public interface AddOnComponent {
    String getAddOnId();
    String getName();
    double getPrice();
    String getDescription();
}
