package fr.eni.poodrills.models;

public class PooDrills04 {

	private static final int SIZE = 10;

	public static void main(String[] args) {
		Shape[] shapesArray = new Shape[SIZE];
		int index = 0;
		shapesArray[index++] = new Triangle(22, 10);
		shapesArray[index++] = new Rectangle(22, 10);
		shapesArray[index++] = new Triangle(4, 125);
		shapesArray[index++] = new Rectangle(4, 125);

		// Les lignes de codes suivantes doivent afficher
		/*
		 * Surface de : Triangle [largeur=22.0, hauteur=10.0] est 110.0
		 * 
		 * Surface de : Rectangle [largeur=22.0, longueur=10.0] est 220.0
		 * 
		 * Surface de : Triangle [largeur=4.0, hauteur=125.0] est 250.0
		 * 
		 * Surface de : Rectangle [largeur=4.0, longueur=125.0] est 500.0
		 */
		for (int i = 0; i < index; i++) {
			System.out.println("Surface de : " + shapesArray[i].toString() + " est " + shapesArray[i].computeArea());
		}

		// Comment faire pour garantir qu'un Triangle, Rectangle ou une autre
		// forme ait son implémentation propre ?

	}

}
