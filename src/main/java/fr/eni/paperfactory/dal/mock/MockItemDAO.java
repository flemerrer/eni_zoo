package fr.eni.paperfactory.dal.mock;

import fr.eni.paperfactory.bo.Item;
import fr.eni.paperfactory.dal.DAO;

import java.util.ArrayList;
import java.util.List;

public class MockItemDAO implements DAO<Item, Integer> {

    private List<Item> mockDB = new ArrayList<>();
    static MockItemDAO mockItemDAO = null;
    private int index = 1;

    private MockItemDAO() {
    }

    public static MockItemDAO getInstance() {
        if (mockItemDAO == null) {
            mockItemDAO = new MockItemDAO();
        }
        return mockItemDAO;
    }

    @Override
    public void create(Item data) {
        data.setId(index++);
        mockDB.add(data);
    }

    @Override
    public Item findById(Integer id) {
        return mockDB.stream().filter(p -> p.equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Item> findAll() {
        return mockDB;
    }

    @Override
    public void update(Item data) {
        for (int i = 0; i < mockDB.size(); i++) {
            if (mockDB.get(i).equals(data.getId())) {
                mockDB.set(i, data);
            }
        }
    }

    @Override
    public void delete(Item data) {
        mockDB.removeIf(p -> p.equals(data.getId()));
    }
}
