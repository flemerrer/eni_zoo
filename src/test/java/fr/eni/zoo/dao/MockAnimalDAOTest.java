package fr.eni.zoo.dao;

import java.util.List;

import fr.eni.zoo.dao.animals.AnimalDAO;
import fr.eni.zoo.models.animals.Animal;
import fr.eni.zoo.models.animals.AnimalType;
import fr.eni.zoo.services.AnimalManager;
import fr.eni.zoo.services.ServiceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MockAnimalDAOTest {

	private static AnimalManager animalManager = AnimalManager.getInstance();

	private static Animal lionMale;
	private static Animal monkeyFemale;
	private static Animal girafeMale;
	private static Animal elephantFemale;
	private static Animal unknown;


	@BeforeAll
	static void init() throws ServiceException {
		lionMale = new Animal(0, "Simba", false, AnimalType.LION);
		monkeyFemale = new Animal(0, "Coco", true, AnimalType.MONKEY);
		girafeMale = new Animal(0, "Gerald", false, AnimalType.GIRAFE);
		elephantFemale = new Animal(0, "dumbo", true, AnimalType.ELEPHANT);
		unknown = new Animal(100, "INCONNU", false, AnimalType.LION);

		animalManager.addAnimal(lionMale);
		animalManager.addAnimal(monkeyFemale);
		animalManager.addAnimal(girafeMale);
		animalManager.addAnimal(elephantFemale);
		animalManager.addAnimal(unknown);
	}

	@Test
	void insertAnimalShouldPopulateDAOAnimalsListWithAnimals() {
		for (Animal a : animalManager.getAllAnimals()) {
			assertInstanceOf(Animal.class, a);
		}
	}

	@Test
	void updateAnimalShouldChangeTargetInDAOAnimalsList() throws ServiceException {
		String updatedName = "Moufassa";
		lionMale.setName(updatedName);
		animalManager.updateAnimal(lionMale);
		assertEquals("Moufassa", animalManager.getAnimal(1).getName());
	}

	@Test
	void getAnimalByIdShouldReturnTargetAnimal() throws ServiceException {
		String expectedName = "Gerald";
		assertEquals("Gerald", animalManager.getAnimal(3).getName());
	}

	@Test
	void getAnimalByIdGivenIncorrectIdShouldThrowDAOException() throws ServiceException {
		assertThrows(ServiceException.class, () -> animalManager.getAnimal(1000));
	}

	@Test
	void findAllShouldReturnAllAnimalsFromDAOAnimalsList() {
		List<Animal> animals = animalManager.getAllAnimals();
			assertEquals(4, animals.size());
		}

	@Test
	void deleteAnimalShouldDeleteAnimalFromDAOAnimalsList() throws ServiceException {
		animalManager.removeAnimal(unknown);
		assertThrows(ServiceException.class, () -> animalManager.getAnimal(100));
	}

	@Test
	void getFemalePercentageShouldReturnFemalePercentage() throws ServiceException {
		assertEquals(0.5, animalManager.getFemalePercentage());
	}

}

