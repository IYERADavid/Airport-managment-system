package airport.core;

import java.time.LocalDateTime;

public abstract class AirportEntity {
    private String entityId;
    private String name;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdated;

    public AirportEntity() {
        this.createdDate = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
        this.status = "Active";
    }

    public AirportEntity(String entityId, String name) {
        this();
        this.entityId = entityId;
        this.name = name;
    }

    public String getEntityId() { return entityId; }
    public void setEntityId(String entityId) { this.entityId = entityId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }

    @Override
    public String toString() {
        return "AirportEntity{id='" + entityId + "', name='" + name + "', status='" + status + "'}";
    }

    public abstract boolean validateEntity();
    public abstract void activateEntity();
    public abstract void deactivateEntity();
    public abstract void updateDetails(String... details);
    public abstract String generateReport();
    public abstract void logActivity(String activity);
    public abstract String checkStatus();
    public abstract void archiveEntity();
    public abstract void restoreEntity();
    public abstract void displaySummary();
}
