package fr.eni.zoo.dao;

import fr.eni.zoo.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class MockAnimalDAO implements AnimalDAO{

    private static MockAnimalDAO instance;
    private static int idCounter;
    private static List<Animal> animals = new ArrayList<Animal>();

    private MockAnimalDAO() {
        idCounter = 1;
    }

    public static MockAnimalDAO getInstance() {
        if(instance == null) {
            instance = new MockAnimalDAO();
        }
        return instance;
    }

    public void setAnimals(List<Animal> animals) {
        MockAnimalDAO.animals = animals;
    }

    public int insertAnimal(Animal animal) {
        animal.setId(idCounter);
        animals.add(animal);
        idCounter++;
        return animal.getId();
    }

    public void deleteAnimal(Animal animal) throws DAOException {
        try {
            animals.remove(animal);
        } catch (Exception e) {
            throw new DAOException("erreur lors de la suppression de l'animal");
        }
    }

    public void updateAnimal(Animal animal) throws DAOException {
        try {
            if(animals.removeIf(target -> target.getId() == animal.getId())){
                animals.add(animal);
            }
        } catch (Exception e) {
            throw new DAOException("erreur lors de la mise à jour de l'animal");
        }
    }

    public Animal findById(int id) throws DAOException {
        try {
            for (Animal a : animals) {
                if (a.getId() == id) {
                    return a;
                }
            }
            throw new DAOException("l'animal n'est pas présent dans la liste");
        } catch (Exception e) {
            throw new DAOException("erreur lors de la récupération de l'animal");
        }
    }

    public List<Animal> findAll() {
        return animals;
    }

}
