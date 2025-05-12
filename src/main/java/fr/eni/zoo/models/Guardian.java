package fr.eni.zoo.models;

public class Guardian extends Employee {

    boolean nightShift = false;

    public Guardian(int id, String firstName, String lastName, double salary, Address address, boolean nightShift) {
        super(id, firstName, lastName, salary, address);
        this.nightShift = nightShift;
    }

    public Guardian(int id, String firstName, String lastName, double salary, Address address) {
        super(id, firstName, lastName, salary, address);
    }

    public boolean isNightShift() {
        return nightShift;
    }

    public void setNightShift(boolean nightShift) {
        this.nightShift = nightShift;
    }

    @Override
    public String toString() {
        return "Guardian [id=" + getId() + ", lastName=" + getLastName() + ", firstName=" + getFirstName() + ", salary=" + getSalary() + "] [nightShift=" + isNightShift() + "]";
    }

}
