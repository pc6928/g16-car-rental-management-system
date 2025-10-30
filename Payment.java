import java.util.Date;

public class Payment {
    private String paymentId;
    private double amount;
    private Date paymentDate;
    private String method;

    public Payment(String paymentId, double amount, Date paymentDate, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
    }

    public boolean processPayment() {
        // TODO: Process payment logic (stub)
        return true;
    }

    public void refund() {
        // TODO: Process refund logic
    }
}
