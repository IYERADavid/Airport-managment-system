package airport.airport;

import java.util.ArrayList;
import java.util.List;

public class Terminal {
    private String terminalId;
    private String name;
    private int capacity;
    private List<Gate> gates;

    public Terminal() {}

    public Terminal(String terminalId, String name, int capacity) {
        this.terminalId = terminalId;
        this.name = name;
        this.capacity = capacity;
        this.gates = new ArrayList<>();
    }

    public String getTerminalId() { return terminalId; }
    public void setTerminalId(String terminalId) { this.terminalId = terminalId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public List<Gate> getGates() { return gates; }

    public void addGate(Gate gate) {
        if (gates.size() < capacity) {
            gates.add(gate);
        }
    }

    public Gate getAvailableGate() {
        for (Gate gate : gates) {
            if (gate.getStatus().equals("Available")) return gate;
        }
        return null;
    }

    public int getAvailableGateCount() {
        int count = 0;
        for (Gate gate : gates) {
            if (gate.getStatus().equals("Available")) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return "Terminal{id='" + terminalId + "', name='" + name + "', gates=" + gates.size() + "}";
    }
}
