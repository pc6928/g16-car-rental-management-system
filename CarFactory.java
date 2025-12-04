/**
 * CarFactory - Factory Pattern
 * WHY: Separates object creation from business logic for easier maintenance
 */
public class CarFactory {
    public static Car createCar(String id, String make, String model, double baseRate) {
        return new Car(id, make, model, baseRate);
    }
}

