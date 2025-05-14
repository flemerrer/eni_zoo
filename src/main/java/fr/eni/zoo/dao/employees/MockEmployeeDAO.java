package fr.eni.zoo.dao.employees;

import fr.eni.zoo.dao.DAOException;
import fr.eni.zoo.dao.DAOInterface;
import fr.eni.zoo.models.employees.Employee;

import java.util.List;

public class MockEmployeeDAO implements DAOInterface<Employee> {

    //TODO: Implement class (optional)

    private static MockEmployeeDAO instance;

    public static MockEmployeeDAO getInstance() {
        if(instance == null) {
            instance = new MockEmployeeDAO();
        }
        return null;
    }

    @Override
    public void setAnimals(List<Employee> objects) {

    }

    @Override
    public int insertAnimal(Employee object) {
        return 0;
    }

    @Override
    public void deleteAnimal(Employee object) throws DAOException {

    }

    @Override
    public void updateAnimal(Employee object) throws DAOException {

    }

    @Override
    public Employee findById(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

}
