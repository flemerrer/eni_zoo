package fr.eni.zoo.dao;

import fr.eni.zoo.models.Animal;

import java.util.List;

public class JDBCAnimalDAO implements AnimalDAO {

    private static JDBCAnimalDAO instance = new JDBCAnimalDAO();

    private JDBCAnimalDAO() {
    }

    public static JDBCAnimalDAO getInstance() {
        if(instance == null) {
            instance = new JDBCAnimalDAO();
        }
        return null;
    }

    @Override
    public void setAnimals(List<Animal> animals) {
    }

    @Override
    public int insertAnimal(Animal animal) {
        return 0;
    }

    @Override
    public void deleteAnimal(Animal animal) throws DAOException {

    }

    @Override
    public void updateAnimal(Animal animal) throws DAOException {

    }

    @Override
    public Animal findById(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Animal> findAll() {
        return List.of();
    }
}
