public class Staff {
    private String staffId;
    private String name;
    private String role;

    public Staff(String staffId, String name, String role) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
    }

    // Getters and setters
    public String getStaffId() { return staffId; }
    public String getName() { return name; }
    public String getRole() { return role; }
    
    public void setName(String name) { this.name = name; }
    public void setRole(String role) { this.role = role; }

    public void addCar(Car car) {
        // Implementation to add a new car to inventory
        System.out.println("Adding car to inventory: " + car);
    }

    public void editCar(Car car, String newStatus, double newDailyRate) {
        // Implementation to edit existing car details
        if (car != null) {
            car.setStatus(newStatus);
            car.setDailyRate(newDailyRate);
            System.out.println("Updated car: " + car);
        }
    }

    public Reservation createReservation(Customer customer, Car car, String startDate, String endDate) {
        if (car != null && customer != null) {
            String reservationId = "RES" + System.currentTimeMillis();
            Reservation reservation = new Reservation.Builder(reservationId, startDate, endDate, customer, car)
                .build();
            
            if (reservation.validateDates()) {
                System.out.println("Created reservation: " + reservation);
                return reservation;
            }
        }
        return null;
    }

    public void closeReservation(Reservation reservation) {
        // Implementation to close a completed reservation
        if (reservation != null) {
            reservation.changeStatus("Closed");
            System.out.println("Closed reservation: " + reservation);
        }
    }
}
