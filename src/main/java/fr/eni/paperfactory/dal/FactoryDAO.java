package fr.eni.paperfactory.dal;

import fr.eni.paperfactory.bo.*;
import fr.eni.paperfactory.dal.mock.*;

public class FactoryDAO {

    public static DAO getDAOInstance(String context, String type) {

        if (context.equals("MOCK")){
            switch (type.toUpperCase()) {
                case "CART" -> {
                    return MockCartDAO.getInstance();
                }
                case "ITEM" -> {
                    return MockItemDAO.getInstance();
                }
                case "CARTLINE" -> {
                    return MockLineDAO.getInstance();
                }
            }
        }
        return null;
    }
}
