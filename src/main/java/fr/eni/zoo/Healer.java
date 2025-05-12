package fr.eni.zoo;

public class Healer extends Employee {

    AnimalType animalType;

    public Healer(int id, String firstName, String lastName, double salary, Address address, AnimalType animalType) {
        super(id, firstName, lastName, salary, address);
        this.animalType = animalType;
    }

    public Healer(int id, String firstName, String lastName, double salary, Address address) {
        super(id, firstName, lastName, salary, address);
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return "Healer [id=" + getId() + ", lastName=" + getLastName() + ", firstName=" + getFirstName() + ", salary=" + getSalary() + "] [specialty=" + getAnimalType() + "]";
    }

}

