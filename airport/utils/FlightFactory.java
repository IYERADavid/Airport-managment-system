package airport.utils;

import airport.flight.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class FlightFactory {

    public static final String DOMESTIC = "DOMESTIC";
    public static final String INTERNATIONAL = "INTERNATIONAL";
    public static final String CARGO = "CARGO";
    public static final String CHARTER = "CHARTER";
    public static final String EMERGENCY = "EMERGENCY";

    private static final Map<String, Integer> flightCounters = new HashMap<>();

    public static Flight createFlight(String type, String airlineName, String departure, String destination,
                                       LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity,
                                       Object... extraParams) {
        String flightId = generateFlightId(type, airlineName);

        return switch (type.toUpperCase()) {
            case DOMESTIC -> new DomesticFlight(
                    flightId, airlineName, departure, destination, departureTime, arrivalTime, capacity,
                    (String) extraParams[0], (Boolean) extraParams[1]
            );
            case INTERNATIONAL -> new InternationalFlight(
                    flightId, airlineName, departure, destination, departureTime, arrivalTime, capacity,
                    (String) extraParams[0], (String) extraParams[1], (String) extraParams[2]
            );
            case CARGO -> new CargoFlight(
                    flightId, airlineName, departure, destination, departureTime, arrivalTime, capacity,
                    (Double) extraParams[0], (String) extraParams[1]
            );
            case CHARTER -> new CharterFlight(
                    flightId, airlineName, departure, destination, departureTime, arrivalTime, capacity,
                    (String) extraParams[0], (String) extraParams[1], (Double) extraParams[2]
            );
            case EMERGENCY -> new EmergencyFlight(
                    flightId, airlineName, departure, destination, departureTime, arrivalTime, capacity,
                    (Integer) extraParams[0], (String) extraParams[1], (String) extraParams[2]
            );
            default -> new Flight(flightId, airlineName, departure, destination, departureTime, arrivalTime, capacity);
        };
    }

    private static String generateFlightId(String type, String airline) {
        String prefix = airline.substring(0, Math.min(2, airline.length())).toUpperCase();
        int counter = flightCounters.getOrDefault(type, 0) + 1;
        flightCounters.put(type, counter);
        return prefix + String.format("%03d", counter);
    }

    public static void displayFlightInfo(Flight flight) {
        System.out.println("Created " + flight.getFlightType() + ":");
        System.out.println(flight.toString());
    }
}
