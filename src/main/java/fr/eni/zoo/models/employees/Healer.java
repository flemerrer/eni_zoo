package fr.eni.zoo.models.employees;

import fr.eni.zoo.models.animals.AnimalType;

public class Healer extends Employee {

    private AnimalType specialty;

    public Healer(int id, String firstName, String lastName, double salary, Address address, AnimalType animalType) {
        super(id, firstName, lastName, salary, address);
        this.specialty = animalType;
    }

    public Healer(int id, String firstName, String lastName, double salary, Address address) {
        super(id, firstName, lastName, salary, address);
    }

    public Healer() {
    }

    public AnimalType getSpecialty() {
        return specialty;
    }

    public void setSpecialty(AnimalType specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Healer [id=" + getId() + ", lastName=" + getLastName() + ", firstName=" + getFirstName() + ", salary=" + getSalary() + "] [specialty=" + getSpecialty() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Healer guardian = (Healer) o;
        return this.getFirstName().equals(guardian.getFirstName()) && this.getLastName().equals(guardian.getLastName()) && this.getSalary() == (guardian.getSalary()) && this.getAddress().equals(guardian.getAddress()) && this.getSpecialty() == guardian.getSpecialty();
    }

}

