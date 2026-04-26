package airport.passenger;

import airport.core.Reservable;
import airport.flight.Flight;

import java.time.LocalDateTime;

public class Reservation implements Reservable {
    private String reservationId;
    private Passenger passenger;
    private Flight flight;
    private LocalDateTime bookingDate;
    private String status;

    public static final String CONFIRMED = "Confirmed";
    public static final String PENDING = "Pending";
    public static final String CANCELLED = "Cancelled";
    public static final String COMPLETED = "Completed";

    public Reservation() {}

    public Reservation(String reservationId, Passenger passenger, Flight flight) {
        this.reservationId = reservationId;
        this.passenger = passenger;
        this.flight = flight;
        this.bookingDate = LocalDateTime.now();
        this.status = PENDING;
    }

    public String getReservationId() { return reservationId; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }
    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean confirmReservation() {
        if (flight.hasAvailableSeats()) {
            flight.bookSeat();
            status = CONFIRMED;
            return true;
        }
        return false;
    }

    public boolean doCancel() {
        if (status.equals(CONFIRMED)) {
            flight.cancelSeat();
        }
        status = CANCELLED;
        return true;
    }

    public void updateReservation(Flight newFlight) {
        if (status.equals(CONFIRMED)) {
            flight.cancelSeat();
        }
        this.flight = newFlight;
        status = PENDING;
    }

    @Override
    public void createReservation() {
        System.out.println("Reservation created: " + reservationId);
    }

    @Override
    public void cancelReservation() {
        doCancel();
        System.out.println("Reservation cancelled: " + reservationId);
    }

    @Override
    public void modifyReservation() {
        System.out.println("Reservation modified: " + reservationId);
    }

    @Override
    public String toString() {
        return "Reservation{id='" + reservationId + "', status='" + status + "', passenger='" + passenger.getFullName() + "'}";
    }
}
