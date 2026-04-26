package airport.flight;

import java.time.LocalDateTime;

public class CharterFlight extends Flight {
    private String privateClientName;
    private String clientContact;
    private double charterFee;

    public CharterFlight(String flightId, String airlineName, String departureLocation, String destination,
                         LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity,
                         String privateClientName, String clientContact, double charterFee) {
        super(flightId, airlineName, departureLocation, destination, departureTime, arrivalTime, capacity);
        this.privateClientName = privateClientName;
        this.clientContact = clientContact;
        this.charterFee = charterFee;
    }

    public String getPrivateClientName() { return privateClientName; }
    public void setPrivateClientName(String privateClientName) { this.privateClientName = privateClientName; }
    public String getClientContact() { return clientContact; }
    public void setClientContact(String clientContact) { this.clientContact = clientContact; }
    public double getCharterFee() { return charterFee; }
    public void setCharterFee(double charterFee) { this.charterFee = charterFee; }

    @Override
    public String getFlightType() {
        return "Charter Flight";
    }

    @Override
    public double getBasePrice() {
        return charterFee;
    }

    @Override
    public boolean hasAvailableSeats() {
        return getBookedSeats() < getCapacity();
    }

    @Override
    public void displayFlightDetails() {
        super.displayFlightDetails();
        System.out.println("Type: Charter | Client: " + privateClientName + " | Fee: $" + charterFee);
    }

    @Override
    public String toString() {
        return "CharterFlight{id='" + getFlightId() + "', client='" + privateClientName + "', fee=" + charterFee + "}";
    }
}
