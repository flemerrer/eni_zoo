package fr.eni.zoo;

import java.util.ArrayList;
import java.util.List;

public class TestsBo {

	public static void main(String[] args) {
		System.out.println("Partie 1 - Tests de la couche métier.");
		// partie utilisateur
		List<Animal> animals = List.of(new Animal(1, "Simba", false, AnimalType.LION),
				new Animal(2, "Coco", true, AnimalType.MONKEY), new Animal(3, "Gerald", false, AnimalType.GIRAFE),
				new Animal(4, "dumbo", true, AnimalType.ELEPHANT));
		System.out.println("Les Animaux");
		for (Animal animal : animals) {
			System.out.println(animal);
		}

		// partie métier
		Address a1 = new Address(1, "9", " chemin des bois", "Nantes", "44000");
		Address a2 = new Address(2, "1", " rue de la forêt", "Rennes", "35000");
		Address a3 = new Address(3, "2b", " rue Faraday", "Saint Herblain", "44800");

		System.out.println("a1 : " + a1);
		System.out.println("a2 : " + a2);
		System.out.println("a3 : " + a3);

		Employee s1 = new Healer(1, "Dupont", "Daniel", 1800, a1, TypeAnimal.LION);
		Employee s2 = new Healer(2, "Martin", "Julie", 1750, a2, TypeAnimal.MONKEY);
		Employee s3 = new Guardian(3, "Dubois", "Sophie", 1600, a3, true);
		Employee s4 = new Guardian(4, "Leclerc", "Jacques", 1700, a3, false);

		// Polymorphisme
		List<Salarie> tempContacts = new ArrayList<>();
		tempContacts.add(s1);
		tempContacts.add(s2);
		tempContacts.add(s3);
		tempContacts.add(s4);
		System.out.println("Les salariés");
		for (Employee contact : tempContacts) {
			System.out.println(contact);
		}
	}
}
