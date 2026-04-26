package airport.core;

public interface Payable {
    void processPayment(double amount);
    double calculateAmount();
    String generateReceipt();
}
