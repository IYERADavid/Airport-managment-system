package airport.staff;

public class Pilot extends Staff {
    private int flightHours;
    private String licenseNumber;
    private String aircraftType;

    public Pilot(String staffId, String name, double salary, int flightHours, String licenseNumber, String aircraftType) {
        super(staffId, name, "Pilot", salary);
        this.flightHours = flightHours;
        this.licenseNumber = licenseNumber;
        this.aircraftType = aircraftType;
    }

    public int getFlightHours() { return flightHours; }
    public void setFlightHours(int flightHours) { this.flightHours = flightHours; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public String getAircraftType() { return aircraftType; }
    public void setAircraftType(String aircraftType) { this.aircraftType = aircraftType; }

    public void fly() {
        System.out.println(getName() + " is flying a " + aircraftType);
        flightHours++;
    }

    @Override
    public void work() {
        System.out.println(getName() + " is preparing for flight as a pilot");
    }

    @Override
    public double calculateAnnualSalary() {
        return super.calculateAnnualSalary() + (flightHours * 50);
    }

    @Override
    public String toString() {
        return "Pilot{id='" + getStaffId() + "', name='" + getName() + "', hours=" + flightHours + "}";
    }
}
