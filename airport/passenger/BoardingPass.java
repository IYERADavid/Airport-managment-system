package airport.passenger;

import java.time.LocalDateTime;

public class BoardingPass {
    private String boardingPassId;
    private Ticket ticket;
    private String gateNumber;
    private LocalDateTime boardingTime;

    public BoardingPass() {}

    public BoardingPass(String boardingPassId, Ticket ticket, String gateNumber, LocalDateTime boardingTime) {
        this.boardingPassId = boardingPassId;
        this.ticket = ticket;
        this.gateNumber = gateNumber;
        this.boardingTime = boardingTime;
    }

    public String getBoardingPassId() { return boardingPassId; }
    public void setBoardingPassId(String boardingPassId) { this.boardingPassId = boardingPassId; }
    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public String getGateNumber() { return gateNumber; }
    public void setGateNumber(String gateNumber) { this.gateNumber = gateNumber; }
    public LocalDateTime getBoardingTime() { return boardingTime; }
    public void setBoardingTime(LocalDateTime boardingTime) { this.boardingTime = boardingTime; }

    public String generateBoardingPass() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════════╗\n");
        sb.append("║           BOARDING PASS                  ║\n");
        sb.append("╠══════════════════════════════════════════╣\n");
        sb.append("║ Pass ID: ").append(String.format("%-26s", boardingPassId)).append("║\n");
        sb.append("║ Passenger: ").append(String.format("%-24s", ticket.getPassenger().getFullName())).append("║\n");
        sb.append("║ Flight: ").append(String.format("%-27s", ticket.getFlight().getFlightId())).append("║\n");
        sb.append("║ From: ").append(String.format("%-29s", ticket.getFlight().getDepartureLocation())).append("║\n");
        sb.append("║ To: ").append(String.format("%-31s", ticket.getFlight().getDestination())).append("║\n");
        sb.append("║ Seat: ").append(String.format("%-29s", ticket.getSeatNumber())).append("║\n");
        sb.append("║ Class: ").append(String.format("%-28s", ticket.getClassType())).append("║\n");
        sb.append("║ Gate: ").append(String.format("%-30s", gateNumber)).append("║\n");
        sb.append("║ Boarding: ").append(String.format("%-25s", boardingTime.toLocalTime())).append("║\n");
        sb.append("╚══════════════════════════════════════════╝");
        return sb.toString();
    }

    public void displayBoardingPass() {
        System.out.println(generateBoardingPass());
    }

    @Override
    public String toString() {
        return "BoardingPass{id='" + boardingPassId + "', gate='" + gateNumber + "', flight='" + ticket.getFlight().getFlightId() + "'}";
    }
}
