package airport.staff;

public class Staff {
    private String staffId;
    private String name;
    private String role;
    private double salary;

    public Staff() {}

    public Staff(String staffId, String name, String role, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public String getStaffId() { return staffId; }
    public void setStaffId(String staffId) { this.staffId = staffId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void work() {
        System.out.println(name + " is performing their duties as " + role);
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    @Override
    public String toString() {
        return "Staff{id='" + staffId + "', name='" + name + "', role='" + role + "'}";
    }
}
