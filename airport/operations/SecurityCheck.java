package airport.operations;

import airport.passenger.Passenger;

public class SecurityCheck {
    private String checkId;
    private Passenger passenger;
    private String status;
    private String remarks;

    public static final String PENDING = "Pending";
    public static final String PASSED = "Passed";
    public static final String FAILED = "Failed";
    public static final String ADDITIONAL_SCREENING = "Additional Screening";

    public SecurityCheck() {}

    public SecurityCheck(String checkId, Passenger passenger) {
        this.checkId = checkId;
        this.passenger = passenger;
        this.status = PENDING;
        this.remarks = "";
    }

    public String getCheckId() { return checkId; }
    public void setCheckId(String checkId) { this.checkId = checkId; }
    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public void performCheck() {
        System.out.println("Security check in progress for " + passenger.getFullName());
        status = PASSED;
    }

    public void flagForAdditionalScreening(String reason) {
        status = ADDITIONAL_SCREENING;
        remarks = reason;
    }

    public void failCheck(String reason) {
        status = FAILED;
        remarks = reason;
    }

    public boolean isCleared() {
        return status.equals(PASSED);
    }

    @Override
    public String toString() {
        return "SecurityCheck{id='" + checkId + "', passenger='" + passenger.getFullName() + "', status='" + status + "'}";
    }
}
