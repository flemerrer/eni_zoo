package fr.eni.paperfactory.dal.mock;

import fr.eni.paperfactory.bo.*;
import fr.eni.paperfactory.dal.DAO;

import java.util.ArrayList;
import java.util.List;

public class MockCartDAO implements DAO<Cart, Integer> {

    static MockCartDAO mockCartDAO = null;

    // Gestion de la base de données avec une liste locale
    private List<Cart> mockDB = new ArrayList<>();
    // Identifiant de Ligne est généré par la base
    private int index = 1;

    private MockCartDAO() {
    }

    public static MockCartDAO getInstance() {
        if (mockCartDAO == null) {
            mockCartDAO = new MockCartDAO();
        }
        return mockCartDAO;
    }

    @Override
    public void create(Cart data) {
        data.setId(index++);// ++ pour le prochain ajout
        mockDB.add(data);
    }

    @Override
    public Cart findById(Integer id) {
        return mockDB.stream().filter(p -> p.equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Cart> findAll() {
        return mockDB;
    }

    @Override
    public void update(Cart data) {
        for (int i = 0; i < mockDB.size(); i++) {
            if (mockDB.get(i).equals(data.getId())) {
                mockDB.set(i, data);
            }
        }
    }

    @Override
    public void delete(Cart data) {
        mockDB.removeIf(p -> p.equals(data.getId()));
    }
}

