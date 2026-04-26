package airport.operations;

import airport.airport.Gate;
import airport.flight.Flight;

import java.time.LocalDateTime;

public class Schedule {
    private String scheduleId;
    private Flight flight;
    private Gate gate;
    private LocalDateTime departureTime;
    private LocalDateTime actualDepartureTime;
    private String status;

    public static final String SCHEDULED = "Scheduled";
    public static final String BOARDING = "Boarding";
    public static final String DEPARTED = "Departed";
    public static final String DELAYED = "Delayed";
    public static final String CANCELLED = "Cancelled";

    public Schedule() {}

    public Schedule(String scheduleId, Flight flight, Gate gate, LocalDateTime departureTime) {
        this.scheduleId = scheduleId;
        this.flight = flight;
        this.gate = gate;
        this.departureTime = departureTime;
        this.status = SCHEDULED;
    }

    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }
    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }
    public Gate getGate() { return gate; }
    public void setGate(Gate gate) { this.gate = gate; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public LocalDateTime getActualDepartureTime() { return actualDepartureTime; }
    public void setActualDepartureTime(LocalDateTime actualDepartureTime) { this.actualDepartureTime = actualDepartureTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void delay(int minutes) {
        this.departureTime = departureTime.plusMinutes(minutes);
        this.status = DELAYED;
    }

    public void startBoarding() {
        this.status = BOARDING;
    }

    public void depart() {
        this.actualDepartureTime = LocalDateTime.now();
        this.status = DEPARTED;
        gate.release();
    }

    public void cancel() {
        this.status = CANCELLED;
        gate.release();
    }

    public long getDelayMinutes() {
        if (actualDepartureTime != null && actualDepartureTime.isAfter(departureTime)) {
            return java.time.Duration.between(departureTime, actualDepartureTime).toMinutes();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Schedule{id='" + scheduleId + "', flight='" + flight.getFlightId() + "', time=" + departureTime + ", status='" + status + "'}";
    }
}
