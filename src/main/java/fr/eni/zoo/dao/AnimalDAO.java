package fr.eni.zoo.dao;

import fr.eni.zoo.models.Animal;

public interface AnimalDAO extends DAOInterface<Animal> {
    static AnimalDAO getInstance() {
        return null;
    }
}
