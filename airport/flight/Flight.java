package airport.flight;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight {
    private String flightId;
    private String airlineName;
    private String departureLocation;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int capacity;
    private int bookedSeats;

    public Flight() {}

    public Flight(String flightId, String airlineName, String departureLocation, String destination,
                  LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity) {
        this.flightId = flightId;
        this.airlineName = airlineName;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public String getFlightId() { return flightId; }
    public void setFlightId(String flightId) { this.flightId = flightId; }
    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public String getDepartureLocation() { return departureLocation; }
    public void setDepartureLocation(String departureLocation) { this.departureLocation = departureLocation; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getBookedSeats() { return bookedSeats; }
    public void setBookedSeats(int bookedSeats) { this.bookedSeats = bookedSeats; }

    public long calculateFlightDuration() {
        if (departureTime == null || arrivalTime == null) return 0;
        return Duration.between(departureTime, arrivalTime).toMinutes();
    }

    public boolean hasAvailableSeats() {
        return bookedSeats < capacity;
    }

    public boolean bookSeat() {
        if (hasAvailableSeats()) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (bookedSeats > 0) bookedSeats--;
    }

    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }

    public String getFlightType() {
        return "Standard Flight";
    }

    public double getBasePrice() {
        return 100.0;
    }

    public void displayFlightDetails() {
        System.out.println("Flight: " + flightId + " | " + airlineName);
        System.out.println("Route: " + departureLocation + " -> " + destination);
        System.out.println("Duration: " + calculateFlightDuration() + " minutes");
        System.out.println("Available Seats: " + getAvailableSeats() + "/" + capacity);
    }

    @Override
    public String toString() {
        return "Flight{id='" + flightId + "', airline='" + airlineName + "', route=" + departureLocation + "->" + destination + "}";
    }
}
