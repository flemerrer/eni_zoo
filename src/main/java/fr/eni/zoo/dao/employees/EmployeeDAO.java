package fr.eni.zoo.dao.employees;

import fr.eni.zoo.dao.DAOInterface;
import fr.eni.zoo.models.employees.Employee;

public interface EmployeeDAO extends DAOInterface<Employee> {
    static EmployeeDAO getInstance() {
        return null;
    }
}
