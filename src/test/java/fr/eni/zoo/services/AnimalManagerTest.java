package fr.eni.zoo.services;

import java.util.ArrayList;
import java.util.List;

import fr.eni.zoo.dao.DAOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import fr.eni.zoo.models.*;

public class AnimalManagerTest {

	private static AnimalManager animalManager = AnimalManager.getInstance();
	private static List<Animal> zoo = new ArrayList<>();
	Animal unknown = new Animal(0, "unknown", false, AnimalType.LION);

	@BeforeAll
	static void init() throws ServiceException {
		zoo.add(new Animal(0, "Simba", false, AnimalType.LION));
		zoo.add(new Animal(0, "Coco", true, AnimalType.MONKEY));
		zoo.add(new Animal(0, "Gerald", false, AnimalType.GIRAFE));
		zoo.add(new Animal(0, "Dumbo", true, AnimalType.ELEPHANT));
		for (Animal animal : zoo) {
			try {
				animalManager.addAnimal(animal);
			} catch (Exception e) {
				throw new ServiceException(e.getMessage());
			}
		}
	}

	@Test
	void addAnimalShouldFillAnimalDAOAnimalList() throws ServiceException {
//		int i = 1;
//		for (Animal animal : zoo) {
//			assertEquals(zoo.get(i-1), animalManager.getAnimal(i));
//			i++;
//        }
		animalManager.addAnimal(unknown);
		assertEquals(unknown, animalManager.getAnimal(5));
		animalManager.removeAnimal(unknown);
	}

	@Test
	void addInvalidAnimalShouldThrowServiceException() {
		assertThrows(ServiceException.class, () -> {
			animalManager.addAnimal(new Animal(0, null, false, null));
		});
	}

	@Test
	void getAnimalByIdShouldReturnTargetAnimal() throws ServiceException {
		assertEquals("Simba", animalManager.getAnimal(1).getName());
	}

	@Test
	void getAnimalByIdGivenIncorrectIdShouldThrowAServiceException() {
		assertThrows(ServiceException.class, () -> animalManager.getAnimal(100));
	}

	@Test
	void updateAnimalShouldChangeTargetInDAOAnimalsList() throws ServiceException {
		try {
			Animal animal = zoo.getFirst();
			animal.setName("Moufassa");
			animalManager.updateAnimal(animal);
			assertEquals("Moufassa", animalManager.getAnimal(1).getName());
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Test
	void getAllAnimalsShouldReturnAllAnimalsFromDAOAnimalsList() {
		List<Animal> animals = animalManager.getAllAnimals();
		assertEquals(4, animals.size());
	}

	@Test
	void removeAnimalShouldRemoveAnimalFromDAOAnimalsList() throws ServiceException {
		animalManager.removeAnimal(zoo.get(1));
		assertThrows(ServiceException.class, () -> animalManager.getAnimal(2));
	}

}
