package fr.eni.zoo.services;

import java.util.ArrayList;
import java.util.List;

import fr.eni.zoo.dao.DAOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import fr.eni.zoo.models.*;

public class AnimalManagerTest {

	AnimalManager animalManager = new AnimalManager();

	private static List<Animal> zoo = new ArrayList<>();

	@BeforeAll
	static void init() {
		zoo.add(new Animal(0, "Simba", false, AnimalType.LION));
		zoo.add(new Animal(0, "Coco", true, AnimalType.MONKEY));
		zoo.add(new Animal(0, "Gerald", false, AnimalType.GIRAFE));
		zoo.add(new Animal(0, "Dumbo", true, AnimalType.ELEPHANT));
	}

	@Test
	void addAnimalShouldFillAnimalDAOAnimalList() throws ServiceException {
		for (Animal animal : zoo) {
			int i = 1;
			try {
				animalManager.addAnimal(animal);
				assertInstanceOf(Animal.class, animalManager.getAnimal(i));
			} catch (Exception e) {
				throw new ServiceException(e.getMessage());
			}
			i++;
        }
		//FIXME: There must be a better way to write this | Try parametrized test ?
	}

	@Test
	void addInvalidAnimalShouldThrowServiceException() {
		assertThrows(ServiceException.class, () -> {
			animalManager.addAnimal(new Animal(0, null, false, null));
		});
	}

	@Test
	void getAnimalByIdShouldReturnTargetAnimal() throws ServiceException, DAOException {
		animalManager.addAnimal(zoo.getFirst());
		assertEquals("Simba", animalManager.getAnimal(1).getName());
	}

	@Test
	void getAnimalByIdGivenIncorrectIdShouldThrowAServiceException() throws ServiceException, DAOException {
		assertThrows(ServiceException.class, () -> animalManager.getAnimal(100));
	}

	@Test
	void updateAnimalShouldChangeTargetInDAOAnimalsList() throws ServiceException {
		try {
			Animal animal = zoo.getFirst();
			animalManager.addAnimal(animal);
			animal.setName("Moufassa");
			animalManager.updateAnimal(animal);
			assertEquals("Moufassa", animalManager.getAnimal(1).getName());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Test
	void getAllAnimalsShouldReturnAllAnimalsFromDAOAnimalsList() throws ServiceException {
		for (Animal animal : zoo) {
			try {
				animalManager.addAnimal(animal);
			} catch (Exception e) {
				throw new ServiceException(e.getMessage());
			}
		}
		List<Animal> animals = animalManager.getAllAnimals();
		assertEquals(4, animals.size());
	}

	@Test
	void removeAnimalShouldRemoveAnimalFromDAOAnimalsList() throws ServiceException {
		animalManager.addAnimal(zoo.getFirst());
		animalManager.addAnimal(zoo.get(1));
		animalManager.removeAnimal(zoo.get(1));
		assertThrows(ServiceException.class, () -> animalManager.getAnimal(2));
	}

}
