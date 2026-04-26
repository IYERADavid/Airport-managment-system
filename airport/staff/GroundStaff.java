package airport.staff;

public class GroundStaff extends Staff {
    private String department;
    private String shift;
    private String equipmentCertification;

    public GroundStaff(String staffId, String name, double salary, String department, String shift) {
        super(staffId, name, "Ground Staff", salary);
        this.department = department;
        this.shift = shift;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public String getEquipmentCertification() { return equipmentCertification; }
    public void setEquipmentCertification(String equipmentCertification) { this.equipmentCertification = equipmentCertification; }

    public void handleBaggage() {
        System.out.println(getName() + " from " + department + " is handling baggage");
    }

    @Override
    public void work() {
        System.out.println(getName() + " is working in " + department + " department on " + shift + " shift");
    }

    @Override
    public double calculateAnnualSalary() {
        double shiftBonus = shift.equals("Night") ? 2000 : 0;
        return super.calculateAnnualSalary() + shiftBonus;
    }

    @Override
    public String toString() {
        return "GroundStaff{id='" + getStaffId() + "', name='" + getName() + "', dept='" + department + "'}";
    }
}
