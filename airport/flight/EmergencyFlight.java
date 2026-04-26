package airport.flight;

import java.time.LocalDateTime;

public class EmergencyFlight extends Flight {
    private int emergencyLevel;
    private String emergencyType;
    private String requestingAuthority;

    public EmergencyFlight(String flightId, String airlineName, String departureLocation, String destination,
                           LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity,
                           int emergencyLevel, String emergencyType, String requestingAuthority) {
        super(flightId, airlineName, departureLocation, destination, departureTime, arrivalTime, capacity);
        this.emergencyLevel = emergencyLevel;
        this.emergencyType = emergencyType;
        this.requestingAuthority = requestingAuthority;
    }

    public int getEmergencyLevel() { return emergencyLevel; }
    public void setEmergencyLevel(int emergencyLevel) { this.emergencyLevel = emergencyLevel; }
    public String getEmergencyType() { return emergencyType; }
    public void setEmergencyType(String emergencyType) { this.emergencyType = emergencyType; }
    public String getRequestingAuthority() { return requestingAuthority; }
    public void setRequestingAuthority(String requestingAuthority) { this.requestingAuthority = requestingAuthority; }

    @Override
    public String getFlightType() {
        return "Emergency Flight (Level " + emergencyLevel + ")";
    }

    @Override
    public double getBasePrice() {
        return 0;
    }

    @Override
    public void displayFlightDetails() {
        System.out.println("EMERGENCY FLIGHT - Level " + emergencyLevel);
        System.out.println("Flight: " + getFlightId() + " | Type: " + emergencyType);
        System.out.println("Route: " + getDepartureLocation() + " -> " + getDestination());
        System.out.println("Authority: " + requestingAuthority);
    }

    @Override
    public String toString() {
        return "EmergencyFlight{id='" + getFlightId() + "', level=" + emergencyLevel + ", type='" + emergencyType + "'}";
    }
}
