package fr.eni.paperfactory.dal.mock;

import fr.eni.paperfactory.bo.CartLine;
import fr.eni.paperfactory.dal.DAO;

import java.util.ArrayList;
import java.util.List;

public class MockLineDAO implements DAO<CartLine, Integer> {

    // Gestion de la base de données avec une liste locale
    private List<CartLine> MockDB = new ArrayList<>();
    // Identifiant de CartLine est généré par la base
    private int index = 1;

    static MockLineDAO mockLineDAO = null;

    private MockLineDAO() {
    }

    public static MockLineDAO getInstance(){
        if(mockLineDAO == null){
            mockLineDAO = new MockLineDAO();
        }
        return mockLineDAO;
    }

    @Override
    public void create(CartLine data) {
        data.setId(index++);// ++ pour le prochain ajout
        MockDB.add(data);
    }

    @Override
    public CartLine findById(Integer id) {
        return MockDB.stream().filter(p -> p.equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<CartLine> findAll() {
        return MockDB;
    }

    @Override
    public void update(CartLine data) {
        for (int i = 0; i < MockDB.size(); i++) {
            if (MockDB.get(i).equals(data.getId())) {
                MockDB.set(i, data);
            }
        }
    }

    @Override
    public void delete(CartLine data) {
        MockDB.removeIf(p -> p.equals(data.getId()));
    }

}
