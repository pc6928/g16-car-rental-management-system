import java.util.List;

/**
 * Base decorator class that implements the Car interface.
 * This is the core of the Decorator pattern.
 */
public abstract class CarDecorator extends Car {
    protected Car decoratedCar;
    
    public CarDecorator(Car decoratedCar) {
        super(decoratedCar.getPlate(), decoratedCar.getMake(), decoratedCar.getModel(), 
              decoratedCar.getYear(), decoratedCar.getCarClass(), 
              decoratedCar.getDailyRate(), decoratedCar.getStatus());
        this.decoratedCar = decoratedCar;
    }
    
    @Override
    public double getDailyRate() {
        return decoratedCar.getDailyRate();
    }
    
    @Override
    public String getDescription() {
        return decoratedCar.getDescription();
    }
}

// Concrete decorators for different car features
class GPSDecorator extends CarDecorator {
    private static final double GPS_DAILY_RATE = 10.0;
    
    public GPSDecorator(Car decoratedCar) {
        super(decoratedCar);
    }
    
    @Override
    public double getDailyRate() {
        return super.getDailyRate() + GPS_DAILY_RATE;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + ", GPS Navigation";
    }
}

class ChildSeatDecorator extends CarDecorator {
    private static final double CHILD_SEAT_DAILY_RATE = 5.0;
    
    public ChildSeatDecorator(Car decoratedCar) {
        super(decoratedCar);
    }
    
    @Override
    public double getDailyRate() {
        return super.getDailyRate() + CHILD_SEAT_DAILY_RATE;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + ", Child Safety Seat";
    }
}

class PremiumSoundSystemDecorator extends CarDecorator {
    private static final double SOUND_SYSTEM_DAILY_RATE = 8.0;
    
    public PremiumSoundSystemDecorator(Car decoratedCar) {
        super(decoratedCar);
    }
    
    @Override
    public double getDailyRate() {
        return super.getDailyRate() + SOUND_SYSTEM_DAILY_RATE;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + ", Premium Sound System";
    }
}

/**
 * Factory for creating decorated cars (combining Factory and Decorator patterns)
 */
class CarFeatureFactory {
    public static Car addFeature(Car car, String feature) {
        if (car == null) return null;
        
        return switch (feature.toLowerCase()) {
            case "gps" -> new GPSDecorator(car);
            case "childseat" -> new ChildSeatDecorator(car);
            case "premiumsound" -> new PremiumSoundSystemDecorator(car);
            default -> car; // Return as-is if feature not recognized
        };
    }
    
    public static Car addFeatures(Car car, List<String> features) {
        Car result = car;
        if (features != null) {
            for (String feature : features) {
                result = addFeature(result, feature);
            }
        }
        return result;
    }
}
