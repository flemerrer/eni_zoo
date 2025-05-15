package fr.eni.paperfactory.dal;

import fr.eni.paperfactory.bo.Cart;

import java.util.List;

public interface DAO<T, ID> {
    int id = 0;
    void create(T data);
    T findById(ID id);
    List<T> findAll();
    void update(T data);
    void delete(T data);
}
