package airport.passenger;

public class Passenger {
    private String passengerId;
    private String fullName;
    private String idDocument;
    private String idType;
    private String nationality;
    private String phoneNumber;

    public static final String PASSPORT = "Passport";
    public static final String NATIONAL_ID = "National ID";

    public Passenger() {}

    public Passenger(String passengerId, String fullName, String idDocument, String idType, String nationality, String phoneNumber) {
        this.passengerId = passengerId;
        this.fullName = fullName;
        this.idDocument = idDocument;
        this.idType = idType;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
    }

    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getIdDocument() { return idDocument; }
    public void setIdDocument(String idDocument) { this.idDocument = idDocument; }
    public String getIdType() { return idType; }
    public void setIdType(String idType) { this.idType = idType; }
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassportNumber() { return idType.equals(PASSPORT) ? idDocument : null; }

    public void displayDetails() {
        System.out.println("Passenger: " + fullName + " (ID: " + passengerId + ")");
        System.out.println(idType + ": " + idDocument + " | Nationality: " + nationality);
        System.out.println("Contact: " + phoneNumber);
    }

    @Override
    public String toString() {
        return "Passenger{id='" + passengerId + "', name='" + fullName + "', " + idType + "='" + idDocument + "'}";
    }
}
