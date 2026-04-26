package airport.staff;

import java.util.List;

public class CabinCrew extends Staff {
    private List<String> languages;
    private String serviceClass;
    private int safetyTrainingLevel;

    public CabinCrew(String staffId, String name, double salary, List<String> languages, String serviceClass) {
        super(staffId, name, "Cabin Crew", salary);
        this.languages = languages;
        this.serviceClass = serviceClass;
        this.safetyTrainingLevel = 1;
    }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }
    public String getServiceClass() { return serviceClass; }
    public void setServiceClass(String serviceClass) { this.serviceClass = serviceClass; }
    public int getSafetyTrainingLevel() { return safetyTrainingLevel; }
    public void setSafetyTrainingLevel(int safetyTrainingLevel) { this.safetyTrainingLevel = safetyTrainingLevel; }

    public void servePassengers() {
        System.out.println(getName() + " is serving passengers in " + serviceClass);
    }

    public void speakLanguage(String language) {
        if (languages.contains(language)) {
            System.out.println(getName() + " speaks " + language);
        }
    }

    @Override
    public void work() {
        System.out.println(getName() + " is attending to passengers as cabin crew");
    }

    @Override
    public double calculateAnnualSalary() {
        return super.calculateAnnualSalary() + (languages.size() * 100);
    }

    @Override
    public String toString() {
        return "CabinCrew{id='" + getStaffId() + "', name='" + getName() + "', languages=" + languages.size() + "}";
    }
}
