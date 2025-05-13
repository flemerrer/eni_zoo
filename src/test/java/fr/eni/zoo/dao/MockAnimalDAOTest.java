package fr.eni.zoo.dao;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import fr.eni.zoo.models.*;

public class MockAnimalDAOTest {

	private static MockAnimalDAO animalDao = MockAnimalDAO.getInstance();

	private static Animal lionMale;
	private static Animal monkeyFemale;
	private static Animal girafeMale;
	private static Animal elephantFemale;
	private static Animal unknown;


	@BeforeAll
	static void init() {
		lionMale = new Animal(0, "Simba", false, AnimalType.LION);
		monkeyFemale = new Animal(0, "Coco", true, AnimalType.MONKEY);
		girafeMale = new Animal(0, "Gerald", false, AnimalType.GIRAFE);
		elephantFemale = new Animal(0, "dumbo", true, AnimalType.ELEPHANT);
		unknown = new Animal(100, "INCONNU", false, AnimalType.LION);

		animalDao.insertAnimal(lionMale);
		animalDao.insertAnimal(monkeyFemale);
		animalDao.insertAnimal(girafeMale);
		animalDao.insertAnimal(elephantFemale);
		animalDao.insertAnimal(unknown);
	}

	@Test
	void insertAnimalShouldPopulateDAOAnimalsListWithAnimals() {
		for (Animal a : animalDao.findAll()) {
			assertInstanceOf(Animal.class, a);
		}
	}

	@Test
	void updateAnimalShouldChangeTargetInDAOAnimalsList() throws DAOException {
		String updatedName = "Moufassa";
		lionMale.setName(updatedName);
		animalDao.updateAnimal(lionMale);
		assertEquals("Moufassa", animalDao.findById(1).getName());
	}

	@Test
	void getAnimalByIdShouldReturnTargetAnimal() throws DAOException {
		String expectedName = "Gerald";
		assertEquals("Gerald", animalDao.findById(3).getName());
	}

	@Test
	void getAnimalByIdGivenIncorrectIdShouldThrowDAOException() throws DAOException {
		assertThrows(DAOException.class, () -> animalDao.findById(1000));
	}

	@Test
	void findAllShouldReturnAllAnimalsFromDAOAnimalsList() {
		List<Animal> animals = animalDao.findAll();
			assertEquals(4, animals.size());
		}

	@Test
	void deleteAnimalShouldDeleteAnimalFromDAOAnimalsList() throws DAOException {
		animalDao.deleteAnimal(unknown);
		assertThrows(DAOException.class, () -> animalDao.findById(100));
	}
}

