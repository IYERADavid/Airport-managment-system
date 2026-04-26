package airport.passenger;

import airport.flight.Flight;

public class Ticket {
    private String ticketId;
    private Passenger passenger;
    private Flight flight;
    private String seatNumber;
    private String classType;
    private double price;

    public static final String ECONOMY = "Economy";
    public static final String BUSINESS = "Business";
    public static final String FIRST_CLASS = "First";

    public Ticket() {}

    public Ticket(String ticketId, Passenger passenger, Flight flight, String seatNumber, String classType) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.price = calculateTicketPrice();
    }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }
    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }
    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double calculateTicketPrice() {
        double basePrice = flight.getBasePrice();
        double multiplier = switch (classType) {
            case BUSINESS -> 2.0;
            case FIRST_CLASS -> 4.0;
            default -> 1.0;
        };
        return basePrice * multiplier;
    }

    public String generateTicketDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("          BOARDING TICKET\n");
        sb.append("========================================\n");
        sb.append("Ticket ID: ").append(ticketId).append("\n");
        sb.append("Passenger: ").append(passenger.getFullName()).append("\n");
        sb.append("Flight: ").append(flight.getFlightId()).append(" (").append(flight.getAirlineName()).append(")\n");
        sb.append("Route: ").append(flight.getDepartureLocation()).append(" -> ").append(flight.getDestination()).append("\n");
        sb.append("Seat: ").append(seatNumber).append(" | Class: ").append(classType).append("\n");
        sb.append("Price: $").append(String.format("%.2f", price)).append("\n");
        sb.append("========================================");
        return sb.toString();
    }

    public void displayTicket() {
        System.out.println(generateTicketDetails());
    }

    @Override
    public String toString() {
        return "Ticket{id='" + ticketId + "', passenger='" + passenger.getFullName() + "', flight='" + flight.getFlightId() + "', seat='" + seatNumber + "'}";
    }
}
