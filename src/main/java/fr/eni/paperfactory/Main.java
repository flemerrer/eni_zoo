package fr.eni.paperfactory;

import fr.eni.paperfactory.bo.*;
import fr.eni.paperfactory.dal.DAO;
import fr.eni.paperfactory.dal.FactoryDAO;
import fr.eni.paperfactory.dal.mock.MockItemDAO;

public class Main {

	public static void main(String[] args) {

		String context = ConfigReader.getContext();

		final DAO itemDAO = FactoryDAO.getDAOInstance(context, "ITEM");
		final DAO lineDAO = FactoryDAO.getDAOInstance(context, "CARTLINE");
		final DAO cartDAO = FactoryDAO.getDAOInstance(context, "CART");

		Pen pen = new Pen("BBOrange", "Bic", "Bic bille Orange", 1.2f, "Bleu");
		itemDAO.create(pen);

		PaperBundle paperBundle = new PaperBundle("CRA4S", "Clairef", "Ramette A4 Sup", 9f, 80);
		itemDAO.create(paperBundle);

		System.out.println("\n############### La table Article : ############### ");
		itemDAO.findAll().forEach(System.out::println);

		CartLine ligneStylo = new CartLine();
		ligneStylo.setItem(pen);
		ligneStylo.setQuantity(100);
		// Mise à jour du prix d'une ligne
		ligneStylo.setPrice(pen.getPrice() * ligneStylo.getQuantity());
		lineDAO.create(ligneStylo);

		CartLine paperLine = new CartLine();
		paperLine.setItem(paperBundle);
		paperLine.setQuantity(5);
		// Mise à jour du prix d'une ligne
		paperLine.setPrice(paperBundle.getPrice() * paperLine.getQuantity());
		lineDAO.create(paperLine);

		System.out.println("\n############### La table Ligne : ############### ");
		lineDAO.findAll().forEach(System.out::println);

		Cart cart = new Cart();
		cart.getLines().add(ligneStylo);
		// Mise à jour du montant total
		cart.setTotalPrice(cart.getTotalPrice() + ligneStylo.getPrice());
		cart.getLines().add(paperLine);
		cart.setTotalPrice(cart.getTotalPrice() + paperLine.getPrice());
		cartDAO.create(cart);

		System.out.println("\n############### La table Panier : ############### ");
		cartDAO.findAll().forEach(System.out::println);
	}

}
