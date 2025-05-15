package fr.eni.paperfactory.bll;

import fr.eni.paperfactory.ConfigReader;
import fr.eni.paperfactory.bo.Cart;
import fr.eni.paperfactory.bo.CartLine;
import fr.eni.paperfactory.bo.Item;
import fr.eni.paperfactory.dal.DAO;
import fr.eni.paperfactory.dal.FactoryDAO;

public class CartManagerImpl implements CartManager {

    static DAO<Cart, Integer> cartDAO;
    static DAO<CartLine, Integer> lineDAO;

    static {
        try {
            cartDAO = FactoryDAO.getDAOInstance(ConfigReader.getContext(), "CART");
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            lineDAO = FactoryDAO.getDAOInstance(ConfigReader.getContext(), "CARTLINE");
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    static CartManagerImpl cartManager = null;

    private CartManagerImpl() {
    }

    public static CartManagerImpl getInstance(){
        if (cartManager == null) {
            cartManager = new CartManagerImpl();
        }
        return cartManager;
    }

    @Override
    public Cart createCart(CartLine line) throws BusinessException {
        try {
            Cart cart = new Cart();
            if (isValidLine(line)) {
                cart.addLine(line);
                cartDAO.create(cart);
            }
            return cart;
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void addLineToCart(Cart cart, CartLine line) throws BusinessException {
        try {
            if (cart != null && isValidLine(line)) {
                cart.addLine(line);
                float totalPrice = 0;
                for (CartLine l : cart.getLines()) {
                    totalPrice += l.getPrice();
                }
                cart.setTotalPrice(totalPrice);
                cartDAO.update(cart);
            }
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    private boolean isValidLine(CartLine line) {
        if (line != null && line.getItem() != null && line.getQuantity() != 0 && line.getPrice() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public Cart getCartById(Integer id) throws BusinessException {
        try {
            return (Cart) cartDAO.findById(id);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
