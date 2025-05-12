package fr.eni.zoo;

import fr.eni.zoo.models.Animal;
import fr.eni.zoo.models.AnimalType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    public static Animal animal;

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
