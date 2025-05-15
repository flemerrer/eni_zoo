package fr.eni.paperfactory.bll;

import fr.eni.paperfactory.bo.Item;

import java.util.List;

public interface ItemManager {
    void addItem(Item item) throws BusinessException;
    List<Item> getItems() throws BusinessException;
}
