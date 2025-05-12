package fr.eni.zoo;

public class Healer extends Employee {

    AnimalType specialty;

    public Healer(int id, String firstName, String lastName, double salary, Address address, AnimalType animalType) {
        super(id, firstName, lastName, salary, address);
        this.specialty = animalType;
    }

    public Healer(int id, String firstName, String lastName, double salary, Address address) {
        super(id, firstName, lastName, salary, address);
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

}

