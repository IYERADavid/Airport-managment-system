package airport.operations;

import airport.passenger.Passenger;

public class Baggage {
    private String baggageId;
    private double weight;
    private Passenger owner;
    private String status;

    public static final String CHECKED_IN = "Checked In";
    public static final String LOADED = "Loaded";
    public static final String IN_TRANSIT = "In Transit";
    public static final String ARRIVED = "Arrived";
    public static final String CLAIMED = "Claimed";

    public Baggage() {}

    public Baggage(String baggageId, double weight, Passenger owner) {
        this.baggageId = baggageId;
        this.weight = weight;
        this.owner = owner;
        this.status = CHECKED_IN;
    }

    public String getBaggageId() { return baggageId; }
    public void setBaggageId(String baggageId) { this.baggageId = baggageId; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public Passenger getOwner() { return owner; }
    public void setOwner(Passenger owner) { this.owner = owner; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public boolean checkWeightLimit(double limit) {
        return weight <= limit;
    }

    public double calculateExtraFee(double freeLimit, double feePerKg) {
        if (weight > freeLimit) {
            return (weight - freeLimit) * feePerKg;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Baggage{id='" + baggageId + "', weight=" + weight + "kg, owner='" + owner.getFullName() + "', status='" + status + "'}";
    }
}
