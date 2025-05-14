package fr.eni.zoo.dao;

import fr.eni.zoo.models.Employee;

public interface EmployeeDAO extends DAOInterface<Employee> {
    static EmployeeDAO getInstance() {
        return null;
    }
}
