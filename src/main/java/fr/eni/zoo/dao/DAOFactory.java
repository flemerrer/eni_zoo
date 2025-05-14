package fr.eni.zoo.dao;

import fr.eni.zoo.dao.animals.AnimalDAO;
import fr.eni.zoo.dao.animals.JDBCAnimalDAO;
import fr.eni.zoo.dao.animals.MockAnimalDAO;
import fr.eni.zoo.dao.employees.EmployeeDAO;

public class DAOFactory {

    private static DAOFactory instance = null;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if(instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public AnimalDAO getAnimalDAO(String impl) {
        return switch (impl.toUpperCase()) {
            case "MOCK" -> MockAnimalDAO.getInstance();
            case "JDBC" -> JDBCAnimalDAO.getInstance();
            default -> null;
        };
    }

    public EmployeeDAO getEmployeeDAO() {
        return EmployeeDAO.getInstance();
    }
}
