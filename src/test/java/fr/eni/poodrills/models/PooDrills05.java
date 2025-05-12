package fr.eni.poodrills.models;

public class PooDrills05 {

	private static final int SIZE = 10;

	public static void main(String[] args) {
		Person[] personsTab = new Person[SIZE];
		int index = 0;
		personsTab[index++] = new Person(1, "bob");
		personsTab[index++] = new Person(2, "jim");
		personsTab[index++] = new Person(3, "jane");
		personsTab[index++] = new Person(4, "jason");


		//Ajouter le code nécessaire pour que la console affiche :
		//"La personne Personne [noPersonne=3, nom=jane] est dans la liste !"
		boolean found = false;
		int i = 0;
		Person targetPerson = new Person(3, "jane");

		while(!found && i < index) {
			if(personsTab[i].equals(targetPerson)) {
				System.out.println("La personne " + targetPerson + " est dans la liste !");
				found = true;
			}
			i++;
		}
		if(!found) {
			System.out.println("La personne n'est pas dans la liste");
		}

	}

}
