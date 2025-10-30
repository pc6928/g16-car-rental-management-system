import java.util.Date;

public class Payment {
    private String id;
    private Reservation reservation;
    private double amount;
    private Date paymentDate;
    private String paymentMethod; // CREDIT_CARD, DEBIT_CARD, CASH
    private String status; // PENDING, COMPLETED, REFUNDED, FAILED

    public Payment(String id, Reservation reservation, String paymentMethod) {
        this.id = id;
        this.reservation = reservation;
        this.amount = reservation.getTotalCost();
        this.paymentDate = new Date();
        this.paymentMethod = paymentMethod;
        this.status = "PENDING";
    }

    public boolean processPayment() {
        // In a real implementation, this would integrate with a payment gateway
        try {
            // Simulate payment processing
            Thread.sleep(1000);
            this.status = "COMPLETED";
            return true;
        } catch (Exception e) {
            this.status = "FAILED";
            return false;
        }
    }

    public boolean processRefund() {
        if (!"COMPLETED".equals(status)) {
            return false;
        }
        
        try {
            // Simulate refund processing
            Thread.sleep(1000);
            this.status = "REFUNDED";
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Getters
    public String getId() { return id; }
    public Reservation getReservation() { return reservation; }
    public double getAmount() { return amount; }
    public Date getPaymentDate() { return paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("Payment #%s: $%.2f for Reservation %s - %s", 
            id, amount, reservation.getId(), status);
    }
}
