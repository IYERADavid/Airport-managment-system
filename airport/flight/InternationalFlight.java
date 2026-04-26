package airport.flight;

import java.time.LocalDateTime;

public class InternationalFlight extends Flight {
    private String passportRequirement;
    private String visaRequirement;
    private String countryCode;

    public InternationalFlight(String flightId, String airlineName, String departureLocation, String destination,
                               LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity,
                               String passportRequirement, String visaRequirement, String countryCode) {
        super(flightId, airlineName, departureLocation, destination, departureTime, arrivalTime, capacity);
        this.passportRequirement = passportRequirement;
        this.visaRequirement = visaRequirement;
        this.countryCode = countryCode;
    }

    public String getPassportRequirement() { return passportRequirement; }
    public void setPassportRequirement(String passportRequirement) { this.passportRequirement = passportRequirement; }
    public String getVisaRequirement() { return visaRequirement; }
    public void setVisaRequirement(String visaRequirement) { this.visaRequirement = visaRequirement; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    @Override
    public String getFlightType() {
        return "International Flight";
    }

    @Override
    public double getBasePrice() {
        return 500.0;
    }

    @Override
    public void displayFlightDetails() {
        super.displayFlightDetails();
        System.out.println("Type: International | Country: " + countryCode);
        System.out.println("Passport: " + passportRequirement + " | Visa: " + visaRequirement);
    }

    @Override
    public String toString() {
        return "InternationalFlight{id='" + getFlightId() + "', countryCode='" + countryCode + "'}";
    }
}
