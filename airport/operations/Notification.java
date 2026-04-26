package airport.operations;

import java.time.LocalDateTime;

public class Notification {
    private String notificationId;
    private String message;
    private String recipient;
    private LocalDateTime date;
    private boolean read;

    public Notification() {}

    public Notification(String notificationId, String message, String recipient) {
        this.notificationId = notificationId;
        this.message = message;
        this.recipient = recipient;
        this.date = LocalDateTime.now();
        this.read = false;
    }

    public String getNotificationId() { return notificationId; }
    public void setNotificationId(String notificationId) { this.notificationId = notificationId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public boolean isRead() { return read; }
    public void setRead(boolean read) { this.read = read; }

    public void markAsRead() {
        this.read = true;
    }

    public void send() {
        System.out.println("[Notification to " + recipient + "]: " + message);
    }

    @Override
    public String toString() {
        return "Notification{id='" + notificationId + "', recipient='" + recipient + "', read=" + read + "}";
    }
}
