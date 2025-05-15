package fr.eni.paperfactory;

import fr.eni.paperfactory.bo.Cart;
import fr.eni.paperfactory.bo.PaperBundle;
import fr.eni.paperfactory.bo.CartLine;
import fr.eni.paperfactory.bo.Pen;

public class Main {

	public static void main(String[] args) {
		Pen bic = new Pen("BBOrange","Bic","Bic bille Orange", 1.2f, "Bleu");
		PaperBundle paperBundle = new PaperBundle("CRA4S", "Clairef", "PaperBundle A4 Sup", 9f, 80);
		
		CartLine penLine = new CartLine();
		penLine.setId(1);
		penLine.setItem(bic);
		penLine.setQuantity(100);
		//Mise à jour du prix d'une ligne
		penLine.setPrice(bic.getPrice()*penLine.getQuantity());
				
		CartLine paperLine = new CartLine();
		paperLine.setId(2);
		paperLine.setItem(paperBundle);
		paperLine.setQuantity(5);
		//Mise à jour du prix d'une ligne
		paperLine.setPrice(paperBundle.getPrice()*paperLine.getQuantity());
		
		Cart cart = new Cart();
		cart.setId(1);
		cart.addLine(penLine);
		//Mise à jour du montant total
		cart.setTotalPrice(cart.getTotalPrice()+ penLine.getPrice());
		cart.addLine(paperLine);
		cart.setTotalPrice(cart.getTotalPrice()+ paperLine.getPrice());
		
		System.out.println(cart);
	}

}
