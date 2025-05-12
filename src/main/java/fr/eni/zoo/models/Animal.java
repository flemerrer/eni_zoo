package fr.eni.zoo.models;

public class Animal {

    int id;
    String name;
    int age;
    boolean isFemale;
    AnimalType animalType;

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

}
