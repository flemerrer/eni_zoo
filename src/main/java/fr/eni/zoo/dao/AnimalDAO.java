package fr.eni.zoo.dao;

import fr.eni.zoo.models.Animal;

import java.util.ArrayList;
import java.util.List;

public interface AnimalDAO {
    public static MockAnimalDAO getInstance() {
        return null;
    }
    public void setAnimals(List<Animal> animals);
    public int insertAnimal(Animal animal);
    public void deleteAnimal(Animal animal) throws DAOException;
    public void updateAnimal(Animal animal) throws DAOException;
    public Animal findById(int id) throws DAOException;
    public List<Animal> findAll();

}
