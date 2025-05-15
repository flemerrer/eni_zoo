package fr.eni.paperfactory.bll;

import fr.eni.paperfactory.ConfigReader;
import fr.eni.paperfactory.bo.Item;
import fr.eni.paperfactory.bo.PaperBundle;
import fr.eni.paperfactory.bo.Pen;
import fr.eni.paperfactory.dal.DAO;
import fr.eni.paperfactory.dal.FactoryDAO;

import java.awt.print.Paper;
import java.util.List;

public class ItemManagerImpl implements ItemManager {

    static DAO<Item, String> itemDAO;

    static {
        try {
            itemDAO = FactoryDAO.getDAOInstance(ConfigReader.getContext(), "ITEM");
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    static ItemManagerImpl itemManager = null;

    private ItemManagerImpl() {
    }

    public static ItemManagerImpl getInstance(){
        if (itemManager == null) {
            itemManager = new ItemManagerImpl();
        }
        return itemManager;
    }

    @Override
    public void addItem(Item item) throws BusinessException {
        if (isValidItem(item)) {
            if (!isDuplicate(item)) {
                try {
                    itemDAO.create(item);
                } catch (Exception e) {
                    throw new BusinessException(e.getMessage());
                }
            }
        } else {
            throw new BusinessException("Invalid Item");
        }
    }

    private boolean isValidItem(Item item) {
        if (item == null) {
            return false;
        } else if (item.getName() !=null && item.getModel() != null && item.getBrand() != null && item.getPrice() != 0) {
            return isValidPen(item) || isValidPaper(item);
        }
        return false;
    }

    private boolean isValidPaper(Item item) {
        if (item.getClass() == PaperBundle.class) {
            int grain = ((PaperBundle) item).getGrain();
            return 79 < grain && grain < 161 && grain % 10 == 0;
        }
        return false;
    }

    private boolean isValidPen(Item item) {
        return item.getClass() == Pen.class && ((Pen) item).getColor() != null;
    }

    private boolean isDuplicate(Item item) {
        return itemDAO.findAll().stream().anyMatch(o -> o.getModel().equals(item.getModel()));
    }

    @Override
    public List<Item> getItems() throws BusinessException {
         try {
            return itemDAO.findAll();
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
