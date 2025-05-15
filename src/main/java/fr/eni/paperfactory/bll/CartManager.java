package fr.eni.paperfactory.bll;

import fr.eni.paperfactory.bo.Cart;
import fr.eni.paperfactory.bo.CartLine;

public interface CartManager {
    Cart createCart(CartLine l) throws BusinessException;
    void addLineToCart(Cart c, CartLine l) throws BusinessException;
    Cart getCartById(Integer id) throws BusinessException;
}
