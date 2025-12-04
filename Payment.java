/**
 * Payment - Model class in MVC Pattern
 * 
 * WHY this class: Handles payment processing for reservations.
 * Tracks payment status and allows for refunds. Separates payment logic
 * from reservation logic for better organization.
 */
public class Payment {
    private String id;
    private Reservation reservation;
    private double amount;
    private String status; // PENDING, COMPLETED, REFUNDED
    
    /**
     * Constructor - Creates a payment for a reservation
     * WHY initializes amount from reservation: Ensures payment matches reservation cost
     * WHY status starts as PENDING: Payment must be processed before completion
     */
    public Payment(String id, Reservation reservation) {
        this.id = id;
        this.reservation = reservation;
        this.amount = reservation.getTotalCost();
        this.status = "PENDING";
    }
    
    /**
     * processPayment - Processes the payment
     * WHY returns boolean: Allows caller to know if payment was successful
     * WHY sets status to COMPLETED: Tracks payment state for refund validation
     */
    public boolean processPayment() {
        this.status = "COMPLETED";
        return true;
    }
    
    /**
     * processRefund - Processes a refund for completed payments
     * WHY checks status first: Can only refund completed payments, not pending ones
     * WHY returns boolean: Indicates success/failure of refund operation
     */
    public boolean processRefund() {
        if ("COMPLETED".equals(status)) {
            this.status = "REFUNDED";
            return true;
        }
        return false;
    }
    
    // Public getters - WHY: Allow other classes to read payment data safely
    public String getId() { return id; }
    public Reservation getReservation() { return reservation; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}
