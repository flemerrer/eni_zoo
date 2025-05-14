package fr.eni.zoo.dao;

import java.util.List;

public interface DAOInterface<T> {
    void setAnimals(List<T> objects);
    int insertAnimal(T object);
    void deleteAnimal(T object) throws DAOException;
    void updateAnimal(T object) throws DAOException;
    T findById(int id) throws DAOException;
    List<T> findAll();

}

