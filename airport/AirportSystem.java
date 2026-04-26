package airport;

import airport.airport.Airport;
import airport.airport.Gate;
import airport.airport.Terminal;
import airport.core.AirportManager;
import airport.flight.Flight;
import airport.passenger.BoardingPass;
import airport.operations.Payment;
import airport.operations.Schedule;
import airport.passenger.Passenger;
import airport.passenger.Reservation;
import airport.passenger.Ticket;
import airport.utils.FlightFactory;
import airport.utils.InputValidator;
import airport.utils.ReportGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AirportSystem {
    @FunctionalInterface
    interface ValidatorFunction {
        String validate(String input);
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Flight> flights = new ArrayList<>();
    private static final List<Passenger> passengers = new ArrayList<>();
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final List<Ticket> tickets = new ArrayList<>();
    private static final List<BoardingPass> boardingPasses = new ArrayList<>();
    private static final List<Payment> payments = new ArrayList<>();
    private static final List<Schedule> schedules = new ArrayList<>();
    private static final Airport airport = new Airport("AP001", "International Airport", "Main City", 3);
    private static final AirportManager manager = new AirportManager("MGR001", "Main Manager", "International Airport", 1, "John Smith");

    private static int passengerCounter = 1000;
    private static int reservationCounter = 5000;
    private static int ticketCounter = 8000;
    private static int boardingPassCounter = 9000;
    private static int paymentCounter = 10000;
    private static int scheduleCounter = 2000;

    public static void main(String[] args) {
        initializeSystem();
        runMenu();
    }

    private static void initializeSystem() {
        Terminal t1 = new Terminal("T1", "Terminal 1", 10);
        Terminal t2 = new Terminal("T2", "Terminal 2", 8);

        for (int i = 1; i <= 5; i++) {
            t1.addGate(new Gate("T1-G" + i, t1));
            t2.addGate(new Gate("T2-G" + i, t2));
        }

        airport.addTerminal(t1);
        airport.addTerminal(t2);

        LocalDateTime now = LocalDateTime.now();

        flights.add(FlightFactory.createFlight(FlightFactory.DOMESTIC, "SkyAir", "New York", "Boston",
                now.plusHours(2), now.plusHours(3), 150, "NE", true));
        flights.add(FlightFactory.createFlight(FlightFactory.INTERNATIONAL, "GlobalWings", "New York", "London",
                now.plusHours(4), now.plusHours(16), 300, "Valid", "Required", "UK"));
        flights.add(FlightFactory.createFlight(FlightFactory.DOMESTIC, "SkyAir", "Boston", "Chicago",
                now.plusHours(5), now.plusHours(7), 180, "MW", false));
        flights.add(FlightFactory.createFlight(FlightFactory.CARGO, "CargoExpress", "Los Angeles", "Seattle",
                now.plusHours(3), now.plusHours(6), 50, 10000.0, "General Cargo"));
        flights.add(FlightFactory.createFlight(FlightFactory.CHARTER, "LuxuryAir", "Miami", "Las Vegas",
                now.plusHours(6), now.plusHours(9), 20, "VIP Client", "vip@client.com", 5000.0));
        flights.add(FlightFactory.createFlight(FlightFactory.EMERGENCY, "MedEvac", "Houston", "Dallas",
                now.plusHours(1), now.plusHours(2), 10, 1, "Medical Emergency", "Hospital Authority"));
        flights.add(FlightFactory.createFlight(FlightFactory.CARGO, "CargoAir", "Miami", "Houston",
                now.plusHours(3), now.plusHours(5), 5, 50000.0, "General"));
        flights.add(FlightFactory.createFlight(FlightFactory.CHARTER, "PrivateJet", "Los Angeles", "Las Vegas",
                now.plusHours(6), now.plusHours(7), 20, "Mr. Smith", "+1-555-0199", 15000.0));
        flights.add(FlightFactory.createFlight(FlightFactory.EMERGENCY, "MedEvac", "Remote Area", "Denver",
                now.plusHours(1), now.plusHours(2), 2, 1, "Medical", "Hospital Authority"));
        flights.add(FlightFactory.createFlight(FlightFactory.INTERNATIONAL, "EuroAir", "Chicago", "Paris",
                now.plusHours(8), now.plusHours(20), 250, "Valid", "Schengen", "FR"));

        System.out.println("Airport Management System Initialized");
        System.out.println("Airport: " + airport.getName() + " at " + airport.getLocation());
        System.out.println("Available flights: " + flights.size());
    }

    private static void runMenu() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            String choice = promptInput("Enter choice: ");

            switch (choice) {
                case "1" -> bookFlight();
                case "2" -> viewFlights();
                case "3" -> viewReservations();
                case "4" -> cancelReservation();
                case "5" -> viewReports();
                case "6" -> viewAirportInfo();
                case "0" -> {
                    System.out.println("Thank you for using Airport Management System");
                    running = false;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n===== AIRPORT MANAGEMENT SYSTEM =====");
        System.out.println("1. Book a Flight");
        System.out.println("2. View Available Flights");
        System.out.println("3. View My Reservations");
        System.out.println("4. Cancel Reservation");
        System.out.println("5. Generate Reports");
        System.out.println("6. Airport Information");
        System.out.println("0. Exit");
        System.out.println("=====================================");
    }

    private static void bookFlight() {
        System.out.println("\n----- BOOK FLIGHT -----");

        String name = promptInputUntilValid("Full Name: ", s -> InputValidator.validateNotEmpty(s, "Full Name"));

        System.out.println("\nID Type: Passport or National ID");
        String idTypeInput = promptInputUntilValid("Select ID Type: ", InputValidator::validateIdType);
        String idType = idTypeInput.toLowerCase().contains("passport") ? Passenger.PASSPORT : Passenger.NATIONAL_ID;

        String idDocument;
        if (idType.equals(Passenger.PASSPORT)) {
            idDocument = promptInputUntilValid("Passport Number (e.g., AB123456): ", InputValidator::validatePassport);
        } else {
            idDocument = promptInputUntilValid("National ID (8-12 digits): ", s -> InputValidator.validateIdDocument(s, "National ID"));
        }

        String nationality = promptInputUntilValid("Nationality: ", s -> InputValidator.validateNotEmpty(s, "Nationality"));
        String phone = promptInputUntilValid("Phone Number: ", InputValidator::validatePhoneNumber);

        Passenger passenger = new Passenger("P" + (++passengerCounter), name, idDocument, idType, nationality, phone);

        System.out.println("\n--- Available Flights ---");
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            System.out.println((i + 1) + ". " + f.getFlightId() + " [" + f.getFlightType() + "] | " +
                    f.getDepartureLocation() + " -> " + f.getDestination() +
                    " | Available: " + f.getAvailableSeats() + "/" + f.getCapacity());
        }

        int flightChoice = promptInt("Select flight (1-" + flights.size() + "): ");
        if (flightChoice < 1 || flightChoice > flights.size()) {
            System.out.println("Invalid flight selection");
            return;
        }

        Flight selectedFlight = flights.get(flightChoice - 1);

        if (!selectedFlight.hasAvailableSeats()) {
            System.out.println("Flight is fully booked");
            return;
        }

        System.out.println("\nClass Types: Economy, Business, First");
        String classType = promptInputUntilValid("Select Class: ", InputValidator::validateClassType);

        String seat = generateSeatNumber(selectedFlight, classType);

        String reservationId = "RES" + (++reservationCounter);
        Reservation reservation = new Reservation(reservationId, passenger, selectedFlight);

        if (reservation.confirmReservation()) {
            reservations.add(reservation);
            passengers.add(passenger);

            String ticketId = "TKT" + (++ticketCounter);
            Ticket ticket = new Ticket(ticketId, passenger, selectedFlight, seat, classType.substring(0, 1).toUpperCase() + classType.substring(1));
            tickets.add(ticket);

            System.out.println("\nTicket Price: $" + String.format("%.2f", ticket.getPrice()));
            String paymentMethod = promptInput("Payment Method (Credit Card/Cash/Digital): ");

            Payment payment = new Payment("PAY" + (++paymentCounter), ticket.getPrice(), paymentMethod);
            if (payment.completePayment()) {
                payments.add(payment);
                System.out.println("Payment successful");
                payment.displayReceipt();
            }

            Terminal terminal = airport.getTerminalById("T1");
            Gate gate = terminal != null ? terminal.getAvailableGate() : null;
            String gateNumber = gate != null ? gate.getGateId() : "TBD";

            if (gate != null) {
                gate.assignFlight(selectedFlight);
                Schedule schedule = new Schedule("SCH" + (++scheduleCounter), selectedFlight, gate, selectedFlight.getDepartureTime());
                schedules.add(schedule);
            }

            String boardingPassId = "BP" + (++boardingPassCounter);
            LocalDateTime boardingTime = selectedFlight.getDepartureTime().minusMinutes(30);
            BoardingPass boardingPass = new BoardingPass(boardingPassId, ticket, gateNumber, boardingTime);
            boardingPasses.add(boardingPass);

            System.out.println("\n========================================");
            System.out.println("   BOOKING CONFIRMED SUCCESSFULLY");
            System.out.println("========================================");
            System.out.println("Reservation ID: " + reservationId);
            System.out.println("Ticket ID: " + ticketId);
            System.out.println("Boarding Pass ID: " + boardingPassId);
            System.out.println("\n" + ticket.generateTicketDetails());
            System.out.println("\n" + boardingPass.generateBoardingPass());

        } else {
            System.out.println("Booking failed - flight is full");
        }
    }

    private static void viewFlights() {
        System.out.println("\n----- AVAILABLE FLIGHTS -----");
        for (Flight f : flights) {
            System.out.println("\n" + "=".repeat(40));
            f.displayFlightDetails();
        }
    }

    private static void viewReservations() {
        System.out.println("\n----- RESERVATIONS -----");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found");
            return;
        }
        for (Reservation r : reservations) {
            System.out.println(r.getReservationId() + " | " + r.getPassenger().getFullName() +
                    " | Flight: " + r.getFlight().getFlightId() + " | Status: " + r.getStatus());
        }
    }

    private static void cancelReservation() {
        System.out.println("\n----- CANCEL RESERVATION -----");
        viewReservations();

        String resId = promptInput("Enter Reservation ID to cancel: ");
        Reservation reservation = findReservation(resId);

        if (reservation == null) {
            System.out.println("Reservation not found");
            return;
        }

        if (!reservation.getStatus().equals(Reservation.CONFIRMED)) {
            System.out.println("Cannot cancel - reservation is " + reservation.getStatus());
            return;
        }

        reservation.doCancel();

        payments.stream()
                .filter(p -> reservation.getPassenger().getFullName().contains(String.valueOf(paymentCounter)))
                .findFirst()
                .ifPresent(Payment::refund);

        System.out.println("Reservation cancelled successfully");
    }

    private static void viewReports() {
        System.out.println("\n----- REPORTS -----");
        System.out.println("1. Daily Flights Report");
        System.out.println("2. Passenger Statistics");
        System.out.println("3. Revenue Report");
        System.out.println("4. Delays Report");

        String choice = promptInput("Select report: ");

        switch (choice) {
            case "1" -> {
                LocalDate date = LocalDate.now();
                System.out.println(ReportGenerator.generateDailyFlightsReport(schedules, date));
            }
            case "2" -> System.out.println(ReportGenerator.generatePassengerStatistics(reservations));
            case "3" -> System.out.println(ReportGenerator.generateRevenueReport(payments));
            case "4" -> System.out.println(ReportGenerator.generateDelaysReport(schedules));
            default -> System.out.println("Invalid choice");
        }
    }

    private static void viewAirportInfo() {
        System.out.println("\n----- AIRPORT INFORMATION -----");
        airport.displayAirportInfo();
        manager.displaySummary();

        System.out.println("\n--- Terminals ---");
        for (Terminal t : airport.getTerminals()) {
            System.out.println(t.getTerminalId() + ": " + t.getName() +
                    " | Available Gates: " + t.getAvailableGateCount() + "/" + t.getGates().size());
        }
    }

    private static String generateSeatNumber(Flight flight, String classType) {
        Random rand = new Random();
        int row;
        char seat;

        switch (classType.toLowerCase()) {
            case "first" -> {
                row = rand.nextInt(2) + 1;
                seat = (char) ('A' + rand.nextInt(4));
            }
            case "business" -> {
                row = rand.nextInt(5) + 3;
                seat = (char) ('A' + rand.nextInt(6));
            }
            default -> {
                row = rand.nextInt(30) + 10;
                seat = (char) ('A' + rand.nextInt(6));
            }
        }
        return row + String.valueOf(seat);
    }

    private static Reservation findReservation(String id) {
        return reservations.stream()
                .filter(r -> r.getReservationId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private static String promptInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static String promptInputUntilValid(String message, ValidatorFunction validator) {
        while (true) {
            String input = promptInput(message);
            String error = validator.validate(input);
            if (error == null) {
                return input;
            }
            System.out.println("Error: " + error);
        }
    }

    private static int promptInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }
}
