package fr.eni.zoo.dao.animals;

import fr.eni.zoo.dao.DAOInterface;
import fr.eni.zoo.models.animals.Animal;

public interface AnimalDAO extends DAOInterface<Animal> {
    static AnimalDAO getInstance() {
        return null;
    }
}
