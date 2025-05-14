package fr.eni.zoo.models;

import fr.eni.zoo.models.animals.Animal;
import fr.eni.zoo.models.animals.AnimalType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    public static Animal animal;

    @Test
    void animalsToStringTest() {

        List<Animal> animals = List.of(new Animal(1, "Simba", false, AnimalType.LION),
                new Animal(2, "Coco", true, AnimalType.MONKEY), new Animal(3, "Gerald", false, AnimalType.GIRAFE),
                new Animal(4, "dumbo", true, AnimalType.ELEPHANT));

        for (Animal animal : animals) {
            String expectedString = "Animal [id=" + animal.getId() + ", name=" + animal.getName() + ", isFemale=" + animal.isFemale() + ", type=" + animal.getAnimalType() + "]";
            assertEquals(expectedString, animal.toString());
        }

    }

    @Test
    public void defaultAnimalConstructorShouldNotReturnNullObject() {
        animal = new Animal();
        assertNotNull(animal);
    }

    @Test
    public void animalConstructorShouldReturnInstanceWithGivenAttributes() {
        Animal expectedAnimal = new Animal();
        expectedAnimal.setId(1);
        expectedAnimal.setName("Simba");
        expectedAnimal.setFemale(false);
        expectedAnimal.setAnimalType(AnimalType.LION);
        animal = new Animal(1, "Simba", false, AnimalType.LION);
        Assertions.assertEquals(expectedAnimal, animal);
    }

}
