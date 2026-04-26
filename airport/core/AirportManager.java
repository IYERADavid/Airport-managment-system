package airport.core;

import java.time.LocalDateTime;

public class AirportManager extends AirportEntity implements Reservable, Payable, Trackable {
    private String airportName;
    private int terminalNumber;
    private String managerName;
    private String location;
    private double paymentAmount;

    public AirportManager() {}

    public AirportManager(String entityId, String name, String airportName, int terminalNumber, String managerName) {
        super(entityId, name);
        this.airportName = airportName;
        this.terminalNumber = terminalNumber;
        this.managerName = managerName;
    }

    public String getAirportName() { return airportName; }
    public void setAirportName(String airportName) { this.airportName = airportName; }
    public int getTerminalNumber() { return terminalNumber; }
    public void setTerminalNumber(int terminalNumber) { this.terminalNumber = terminalNumber; }
    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public boolean validateEntity() {
        return getEntityId() != null && !getEntityId().isEmpty() && managerName != null && !managerName.isEmpty();
    }

    @Override
    public void activateEntity() {
        setStatus("Active");
        setLastUpdated(LocalDateTime.now());
    }

    @Override
    public void deactivateEntity() {
        setStatus("Inactive");
        setLastUpdated(LocalDateTime.now());
    }

    @Override
    public void updateDetails(String... details) {
        if (details.length >= 3) {
            this.airportName = details[0];
            this.managerName = details[1];
            this.location = details[2];
            setLastUpdated(LocalDateTime.now());
        }
    }

    @Override
    public String generateReport() {
        return "Airport Report: " + airportName + " - Terminal " + terminalNumber + " - Manager: " + managerName;
    }

    @Override
    public void logActivity(String activity) {
        System.out.println("[AirportManager] " + activity + " at " + LocalDateTime.now());
    }

    @Override
    public String checkStatus() {
        return "Airport: " + airportName + " | Status: " + getStatus() + " | Terminal: " + terminalNumber;
    }

    @Override
    public void archiveEntity() {
        setStatus("Archived");
        setLastUpdated(LocalDateTime.now());
    }

    @Override
    public void restoreEntity() {
        setStatus("Active");
        setLastUpdated(LocalDateTime.now());
    }

    @Override
    public void displaySummary() {
        System.out.println("=== Airport Manager Summary ===");
        System.out.println("Entity ID: " + getEntityId());
        System.out.println("Airport: " + airportName);
        System.out.println("Manager: " + managerName);
        System.out.println("Terminal: " + terminalNumber);
        System.out.println("Status: " + getStatus());
    }

    @Override
    public void createReservation() {
        System.out.println("Manager " + managerName + " created a reservation.");
    }

    @Override
    public void cancelReservation() {
        System.out.println("Manager " + managerName + " cancelled a reservation.");
    }

    @Override
    public void modifyReservation() {
        System.out.println("Manager " + managerName + " modified a reservation.");
    }

    @Override
    public void processPayment(double amount) {
        this.paymentAmount = amount;
        System.out.println("Payment processed: $" + amount);
    }

    @Override
    public double calculateAmount() {
        return paymentAmount;
    }

    @Override
    public String generateReceipt() {
        return "Receipt for Airport Management - Amount: $" + paymentAmount;
    }

    @Override
    public void trackStatus() {
        System.out.println("Tracking airport operations... Status: " + getStatus());
    }

    @Override
    public void updateLocation(String location) {
        this.location = location;
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "AirportManager{entityId='" + getEntityId() + "', airportName='" + airportName + "', terminalNumber=" + terminalNumber + ", managerName='" + managerName + "'}";
    }
}
