package fr.eni.zoo.models;

import java.util.Objects;

public class Guardian extends Employee {

    private boolean nightShift = false;

    public Guardian(int id, String firstName, String lastName, double salary, Address address, boolean nightShift) {
        super(id, firstName, lastName, salary, address);
        this.nightShift = nightShift;
    }

    public Guardian(int id, String firstName, String lastName, double salary, Address address) {
        super(id, firstName, lastName, salary, address);
    }

    public Guardian() {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Guardian guardian = (Guardian) o;
        return this.getFirstName().equals(guardian.getFirstName()) && this.getLastName().equals(guardian.getLastName()) && this.getSalary() == (guardian.getSalary()) && this.getAddress().equals(guardian.getAddress()) && this.isNightShift() == guardian.isNightShift();
    }

}
