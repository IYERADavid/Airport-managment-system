package airport.staff;

public class SecurityOfficer extends Staff {
    private int securityLevel;
    private String clearanceCode;
    private boolean armed;

    public SecurityOfficer(String staffId, String name, double salary, int securityLevel, String clearanceCode, boolean armed) {
        super(staffId, name, "Security Officer", salary);
        this.securityLevel = securityLevel;
        this.clearanceCode = clearanceCode;
        this.armed = armed;
    }

    public int getSecurityLevel() { return securityLevel; }
    public void setSecurityLevel(int securityLevel) { this.securityLevel = securityLevel; }
    public String getClearanceCode() { return clearanceCode; }
    public void setClearanceCode(String clearanceCode) { this.clearanceCode = clearanceCode; }
    public boolean isArmed() { return armed; }
    public void setArmed(boolean armed) { this.armed = armed; }

    public void patrol() {
        System.out.println(getName() + " is patrolling security level " + securityLevel + " area");
    }

    public boolean checkClearance(String code) {
        return clearanceCode.equals(code);
    }

    @Override
    public void work() {
        System.out.println(getName() + " is monitoring security checkpoints");
    }

    @Override
    public double calculateAnnualSalary() {
        double armedBonus = armed ? 5000 : 0;
        return super.calculateAnnualSalary() + (securityLevel * 1000) + armedBonus;
    }

    @Override
    public String toString() {
        return "SecurityOfficer{id='" + getStaffId() + "', name='" + getName() + "', level=" + securityLevel + "}";
    }
}
