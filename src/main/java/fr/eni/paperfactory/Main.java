package fr.eni.paperfactory;

import fr.eni.paperfactory.bll.*;
import fr.eni.paperfactory.bo.*;

public class Main {

	public static void main(String[] args) {

		final ItemManager itemManager = ItemManagerImpl.getInstance();
		final CartManager cartManager = CartManagerImpl.getInstance();

		try {
			Pen pen = new Pen(0, "BBOrange", "Bic", "Bic bille Orange", 1.2f, "Bleu");
			itemManager.addItem(pen);

			PaperBundle paperBundle = new PaperBundle(0, "CRA4S", "Clairef", "Ramette A4 Sup", 9f, 80);
			itemManager.addItem(paperBundle);

			System.out.println("\n############### Les articles du Catalogue : ############### ");
			itemManager.getItems().forEach(System.out::println);


			// Créer un nouveau panier
			CartLine penLine = new CartLine();
			penLine.setItem(pen);
			penLine.setPrice(30);
			penLine.setQuantity(100);
			Cart cart = cartManager.createCart(penLine);
			System.out.println("\n############### Nouveau Panier : ############### ");
			System.out.println(cart);

			// Ajouter une ligne au panier
			CartLine paperLine = new CartLine();
			paperLine.setItem(paperBundle);
			paperLine.setQuantity(5);
			cartManager.addLineToCart(cart, paperLine);

			System.out.println("\n############### Panier mis à jour : ############### ");
			System.out.println(cart);

		}catch (BusinessException e) {
			e.printStackTrace();
		}

	}

}
