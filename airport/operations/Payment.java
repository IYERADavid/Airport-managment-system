package airport.operations;

import airport.core.Payable;

import java.time.LocalDateTime;

public class Payment implements Payable {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime paymentDate;

    public static final String PENDING = "Pending";
    public static final String COMPLETED = "Completed";
    public static final String FAILED = "Failed";
    public static final String REFUNDED = "Refunded";

    public Payment() {}

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PENDING;
        this.paymentDate = LocalDateTime.now();
    }

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public boolean completePayment() {
        if (amount > 0) {
            paymentStatus = COMPLETED;
            return true;
        }
        paymentStatus = FAILED;
        return false;
    }

    public void refund() {
        if (paymentStatus.equals(COMPLETED)) {
            paymentStatus = REFUNDED;
        }
    }

    @Override
    public void processPayment(double amount) {
        this.amount = amount;
        completePayment();
    }

    @Override
    public double calculateAmount() {
        return amount;
    }

    @Override
    public String generateReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== PAYMENT RECEIPT =====\n");
        sb.append("Payment ID: ").append(paymentId).append("\n");
        sb.append("Amount: $").append(String.format("%.2f", amount)).append("\n");
        sb.append("Method: ").append(paymentMethod).append("\n");
        sb.append("Status: ").append(paymentStatus).append("\n");
        sb.append("Date: ").append(paymentDate).append("\n");
        sb.append("========================");
        return sb.toString();
    }

    public void displayReceipt() {
        System.out.println(generateReceipt());
    }

    @Override
    public String toString() {
        return "Payment{id='" + paymentId + "', amount=$" + amount + ", status='" + paymentStatus + "'}";
    }
}
