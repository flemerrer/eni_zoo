package fr.eni.zoo.services;

import fr.eni.zoo.dao.DAOException;
import fr.eni.zoo.dao.MockAnimalDAO;
import fr.eni.zoo.models.Animal;

import java.util.List;

public class AnimalManager {

    private static AnimalManager instance;
    private static MockAnimalDAO animalDao;

    private AnimalManager() {
        animalDao = MockAnimalDAO.getInstance();
    }

    public static AnimalManager getInstance() {
        if(instance == null) {
            instance = new AnimalManager();
        }
        return instance;
    }

    public int addAnimal(Animal animal) throws ServiceException {

        if (animal != null && animal.getName() != null && animal.getAnimalType() != null) {
            return animalDao.insertAnimal(animal);
        } else {
            StringBuilder str = new StringBuilder();
            str.append("L'objet animal fourni :\n");
            if (animal == null) {
                throw new ServiceException("La variable fournie ne contient pas d'objet de type animal (null value)");
            } else {
                if (animal.getAnimalType() == null) {
                    str.append("- n'a pas de type animal spécifié\n");
                }
                if (animal.getName() == null) {
                    str.append("- n'a pas de nom spécifié\n");
                }
                str.append("Ces éléments sont obligatoires. Vérifiez la cohérence des données.");
                throw new ServiceException(str.toString());
            }
        }
    }

    public void removeAnimal(Animal animal) throws ServiceException {
        try {
            animalDao.deleteAnimal(animal);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void updateAnimal(Animal animal) throws ServiceException {
        try {
            animalDao.updateAnimal(animal);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Animal getAnimal(int id) throws ServiceException {
        try {
            return animalDao.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<Animal> getAllAnimals() {
        return animalDao.findAll();
    }

    public void getFemalePercentage() {
    }

}
