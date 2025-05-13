package fr.eni.zoo.dao;

import fr.eni.zoo.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class MockAnimalDAO {

    int idCounter;
    List<Animal> animals = new ArrayList<Animal>();

    public MockAnimalDAO() {
        this.idCounter = 1;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int insertAnimal(Animal animal) {
        animal.setId(idCounter);
        this.animals.add(animal);
        idCounter++;
        return animal.getId();
    }

    public void deleteAnimal(Animal animal) throws DAOException {
        try {
            this.animals.remove(animal);
        } catch (Exception e) {
            throw new DAOException("erreur lors de la suppression de l'animal");
        }
    }

    public void updateAnimal(Animal animal) throws DAOException {
        try {
            if(this.animals.removeIf(target -> target.getId() == animal.getId())){
                this.animals.add(animal);
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
        } catch (Exception e) {
            throw new DAOException("erreur lors de la récupération de l'animal");
        }
        return null;
    }

    public List<Animal> findAll() {
        return animals;
    }

}
