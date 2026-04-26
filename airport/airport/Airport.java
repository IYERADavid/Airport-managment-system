package airport.airport;

import airport.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String airportId;
    private String name;
    private String location;
    private int numberOfTerminals;
    private List<Terminal> terminals;
    private List<Staff> staffList;

    public Airport() {}

    public Airport(String airportId, String name, String location, int numberOfTerminals) {
        this.airportId = airportId;
        this.name = name;
        this.location = location;
        this.numberOfTerminals = numberOfTerminals;
        this.terminals = new ArrayList<>();
        this.staffList = new ArrayList<>();
    }

    public String getAirportId() { return airportId; }
    public void setAirportId(String airportId) { this.airportId = airportId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getNumberOfTerminals() { return numberOfTerminals; }
    public void setNumberOfTerminals(int numberOfTerminals) { this.numberOfTerminals = numberOfTerminals; }
    public List<Terminal> getTerminals() { return terminals; }
    public List<Staff> getStaffList() { return staffList; }

    public void addTerminal(Terminal terminal) {
        terminals.add(terminal);
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public Terminal getTerminalById(String terminalId) {
        for (Terminal t : terminals) {
            if (t.getTerminalId().equals(terminalId)) return t;
        }
        return null;
    }

    public void displayAirportInfo() {
        System.out.println("Airport: " + name + " (" + airportId + ")");
        System.out.println("Location: " + location);
        System.out.println("Terminals: " + numberOfTerminals);
        System.out.println("Total Staff: " + staffList.size());
    }

    @Override
    public String toString() {
        return "Airport{id='" + airportId + "', name='" + name + "', location='" + location + "'}";
    }
}
