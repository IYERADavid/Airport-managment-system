package airport.airport;

import airport.flight.Flight;

public class Gate {
    private String gateId;
    private Terminal terminal;
    private String status;
    private Flight currentFlight;

    public static final String AVAILABLE = "Available";
    public static final String OCCUPIED = "Occupied";
    public static final String MAINTENANCE = "Maintenance";

    public Gate() {}

    public Gate(String gateId, Terminal terminal) {
        this.gateId = gateId;
        this.terminal = terminal;
        this.status = AVAILABLE;
    }

    public String getGateId() { return gateId; }
    public void setGateId(String gateId) { this.gateId = gateId; }
    public Terminal getTerminal() { return terminal; }
    public void setTerminal(Terminal terminal) { this.terminal = terminal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Flight getCurrentFlight() { return currentFlight; }
    public void setCurrentFlight(Flight currentFlight) { this.currentFlight = currentFlight; }

    public boolean assignFlight(Flight flight) {
        if (status.equals(AVAILABLE)) {
            this.currentFlight = flight;
            status = OCCUPIED;
            return true;
        }
        return false;
    }

    public void release() {
        this.currentFlight = null;
        status = AVAILABLE;
    }

    public void closeForMaintenance() {
        status = MAINTENANCE;
    }

    @Override
    public String toString() {
        return "Gate{id='" + gateId + "', status='" + status + "'}";
    }
}
