package airport.utils;

import airport.operations.Payment;
import airport.operations.Schedule;
import airport.passenger.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGenerator {

    public static String generateDailyFlightsReport(List<Schedule> schedules, LocalDate date) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== DAILY FLIGHTS REPORT =====\n");
        sb.append("Date: ").append(date).append("\n\n");

        long total = schedules.stream()
                .filter(s -> s.getDepartureTime().toLocalDate().equals(date))
                .count();

        long departed = schedules.stream()
                .filter(s -> s.getDepartureTime().toLocalDate().equals(date) && s.getStatus().equals(Schedule.DEPARTED))
                .count();

        long delayed = schedules.stream()
                .filter(s -> s.getDepartureTime().toLocalDate().equals(date) && s.getStatus().equals(Schedule.DELAYED))
                .count();

        long cancelled = schedules.stream()
                .filter(s -> s.getDepartureTime().toLocalDate().equals(date) && s.getStatus().equals(Schedule.CANCELLED))
                .count();

        sb.append("Total Flights: ").append(total).append("\n");
        sb.append("Departed: ").append(departed).append("\n");
        sb.append("Delayed: ").append(delayed).append("\n");
        sb.append("Cancelled: ").append(cancelled).append("\n\n");

        sb.append("--- Flight Details ---\n");
        schedules.stream()
                .filter(s -> s.getDepartureTime().toLocalDate().equals(date))
                .forEach(s -> sb.append(s.getFlight().getFlightId())
                        .append(" | ")
                        .append(s.getFlight().getDestination())
                        .append(" | ")
                        .append(s.getStatus())
                        .append("\n"));

        return sb.toString();
    }

    public static String generatePassengerStatistics(List<Reservation> reservations) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== PASSENGER STATISTICS =====\n\n");

        long total = reservations.size();
        long confirmed = reservations.stream()
                .filter(r -> r.getStatus().equals(Reservation.CONFIRMED))
                .count();
        long cancelled = reservations.stream()
                .filter(r -> r.getStatus().equals(Reservation.CANCELLED))
                .count();
        long pending = reservations.stream()
                .filter(r -> r.getStatus().equals(Reservation.PENDING))
                .count();

        sb.append("Total Reservations: ").append(total).append("\n");
        sb.append("Confirmed: ").append(confirmed).append("\n");
        sb.append("Pending: ").append(pending).append("\n");
        sb.append("Cancelled: ").append(cancelled).append("\n\n");

        Map<String, Long> byNationality = reservations.stream()
                .collect(Collectors.groupingBy(r -> r.getPassenger().getNationality(), Collectors.counting()));

        sb.append("--- By Nationality ---\n");
        byNationality.forEach((k, v) -> sb.append(k).append(": ").append(v).append("\n"));

        return sb.toString();
    }

    public static String generateRevenueReport(List<Payment> payments) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== REVENUE REPORT =====\n\n");

        double totalRevenue = payments.stream()
                .filter(p -> p.getPaymentStatus().equals(Payment.COMPLETED))
                .mapToDouble(Payment::getAmount)
                .sum();

        double refunded = payments.stream()
                .filter(p -> p.getPaymentStatus().equals(Payment.REFUNDED))
                .mapToDouble(Payment::getAmount)
                .sum();

        long completed = payments.stream()
                .filter(p -> p.getPaymentStatus().equals(Payment.COMPLETED))
                .count();

        long failed = payments.stream()
                .filter(p -> p.getPaymentStatus().equals(Payment.FAILED))
                .count();

        sb.append("Total Revenue: $").append(String.format("%.2f", totalRevenue)).append("\n");
        sb.append("Refunded: $").append(String.format("%.2f", refunded)).append("\n");
        sb.append("Net Revenue: $").append(String.format("%.2f", totalRevenue - refunded)).append("\n\n");
        sb.append("Completed Payments: ").append(completed).append("\n");
        sb.append("Failed Payments: ").append(failed).append("\n");

        Map<String, Double> byMethod = payments.stream()
                .filter(p -> p.getPaymentStatus().equals(Payment.COMPLETED))
                .collect(Collectors.groupingBy(Payment::getPaymentMethod, Collectors.summingDouble(Payment::getAmount)));

        sb.append("\n--- By Payment Method ---\n");
        byMethod.forEach((k, v) -> sb.append(k).append(": $").append(String.format("%.2f", v)).append("\n"));

        return sb.toString();
    }

    public static String generateDelaysReport(List<Schedule> schedules) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== DELAYS REPORT =====\n\n");

        List<Schedule> delayed = schedules.stream()
                .filter(s -> s.getStatus().equals(Schedule.DELAYED) || s.getDelayMinutes() > 0)
                .toList();

        sb.append("Total Delayed Flights: ").append(delayed.size()).append("\n\n");

        double avgDelay = delayed.stream()
                .mapToLong(Schedule::getDelayMinutes)
                .average()
                .orElse(0);

        sb.append("Average Delay: ").append(String.format("%.1f", avgDelay)).append(" minutes\n\n");

        sb.append("--- Delayed Flights ---\n");
        delayed.forEach(s -> sb.append(s.getFlight().getFlightId())
                .append(" | ")
                .append(s.getDelayMinutes())
                .append(" min | Gate: ")
                .append(s.getGate().getGateId())
                .append("\n"));

        return sb.toString();
    }

    public static void printReport(String report) {
        System.out.println(report);
    }
}
