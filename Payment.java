public class Payment {
    private String id;
    private Reservation reservation;
    private double amount;
    private String status; // PENDING, COMPLETED, REFUNDED
    
    public Payment(String id, Reservation reservation) {
        this.id = id;
        this.reservation = reservation;
        this.amount = reservation.getTotalCost();
        this.status = "PENDING";
    }
    
    public boolean processPayment() {
        // Simulate payment processing
        this.status = "COMPLETED";
        return true;
    }
    
    public boolean processRefund() {
        if ("COMPLETED".equals(status)) {
            this.status = "REFUNDED";
            return true;
        }
        return false;
    }
    
    // Getters
    public String getId() { return id; }
    public Reservation getReservation() { return reservation; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}
