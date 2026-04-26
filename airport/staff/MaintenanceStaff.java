package airport.staff;

public class MaintenanceStaff extends Staff {
    private String specialization;
    private int yearsOfExperience;
    private boolean certified;

    public MaintenanceStaff(String staffId, String name, double salary, String specialization, int yearsOfExperience) {
        super(staffId, name, "Maintenance", salary);
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.certified = false;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
    public boolean isCertified() { return certified; }
    public void setCertified(boolean certified) { this.certified = certified; }

    public void performMaintenance() {
        System.out.println(getName() + " is performing " + specialization + " maintenance");
    }

    public void certify() {
        if (yearsOfExperience >= 2) {
            certified = true;
            System.out.println(getName() + " is now certified in " + specialization);
        }
    }

    @Override
    public void work() {
        System.out.println(getName() + " is conducting maintenance checks");
    }

    @Override
    public double calculateAnnualSalary() {
        return super.calculateAnnualSalary() + (yearsOfExperience * 500) + (certified ? 3000 : 0);
    }

    @Override
    public String toString() {
        return "MaintenanceStaff{id='" + getStaffId() + "', name='" + getName() + "', spec='" + specialization + "'}";
    }
}
