package airport.flight;

import java.time.LocalDateTime;

public class DomesticFlight extends Flight {
    private String regionCode;
    private boolean isInterstate;

    public DomesticFlight(String flightId, String airlineName, String departureLocation, String destination,
                          LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity,
                          String regionCode, boolean isInterstate) {
        super(flightId, airlineName, departureLocation, destination, departureTime, arrivalTime, capacity);
        this.regionCode = regionCode;
        this.isInterstate = isInterstate;
    }

    public String getRegionCode() { return regionCode; }
    public void setRegionCode(String regionCode) { this.regionCode = regionCode; }
    public boolean isInterstate() { return isInterstate; }
    public void setInterstate(boolean interstate) { isInterstate = interstate; }

    @Override
    public String getFlightType() {
        return "Domestic Flight";
    }

    @Override
    public double getBasePrice() {
        return isInterstate ? 150.0 : 80.0;
    }

    @Override
    public void displayFlightDetails() {
        super.displayFlightDetails();
        System.out.println("Type: Domestic | Region: " + regionCode + " | Interstate: " + isInterstate);
    }

    @Override
    public String toString() {
        return "DomesticFlight{id='" + getFlightId() + "', regionCode='" + regionCode + "', interstate=" + isInterstate + "}";
    }
}
