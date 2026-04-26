package airport.flight;

import java.time.LocalDateTime;

public class CargoFlight extends Flight {
    private double cargoWeightLimit;
    private double currentCargoWeight;
    private String cargoType;

    public CargoFlight(String flightId, String airlineName, String departureLocation, String destination,
                       LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity,
                       double cargoWeightLimit, String cargoType) {
        super(flightId, airlineName, departureLocation, destination, departureTime, arrivalTime, capacity);
        this.cargoWeightLimit = cargoWeightLimit;
        this.cargoType = cargoType;
        this.currentCargoWeight = 0;
    }

    public double getCargoWeightLimit() { return cargoWeightLimit; }
    public void setCargoWeightLimit(double cargoWeightLimit) { this.cargoWeightLimit = cargoWeightLimit; }
    public double getCurrentCargoWeight() { return currentCargoWeight; }
    public String getCargoType() { return cargoType; }
    public void setCargoType(String cargoType) { this.cargoType = cargoType; }

    public boolean addCargo(double weight) {
        if (currentCargoWeight + weight <= cargoWeightLimit) {
            currentCargoWeight += weight;
            return true;
        }
        return false;
    }

    @Override
    public String getFlightType() {
        return "Cargo Flight";
    }

    @Override
    public double getBasePrice() {
        return cargoWeightLimit * 2.5;
    }

    @Override
    public void displayFlightDetails() {
        System.out.println("Cargo Flight: " + getFlightId() + " | " + getAirlineName());
        System.out.println("Route: " + getDepartureLocation() + " -> " + getDestination());
        System.out.println("Cargo Type: " + cargoType + " | Capacity: " + currentCargoWeight + "/" + cargoWeightLimit + " kg");
    }

    @Override
    public String toString() {
        return "CargoFlight{id='" + getFlightId() + "', cargoType='" + cargoType + "', weightLimit=" + cargoWeightLimit + "}";
    }
}
