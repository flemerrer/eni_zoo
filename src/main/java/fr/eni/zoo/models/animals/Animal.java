package fr.eni.zoo.models.animals;

public class Animal {

    private int id;
    private String name;
    private int age;
    private boolean isFemale;
    private AnimalType animalType;

    public Animal(int id, String name, boolean isFemale, AnimalType animalType) {
        this.id = id;
        this.name = name;
        this.age = 1;
        this.animalType = animalType;
        this.isFemale = isFemale;
    }

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", name=" + name + ", isFemale=" + isFemale + ", type=" + animalType + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        return getId() == other.getId() && getName().equals(other.getName()) && isFemale() == other.isFemale() && getAnimalType().equals(other.getAnimalType()) ;
    }
}
