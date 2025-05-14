package fr.eni.genericity;

import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Integer> list = List.of(1,2,3,45,15,451,451,25,2,22,2);
		
		//Exercice 1
		System.out.println(list);
		System.out.println("2 apparaît " + count(list, 2) + " fois dans cette liste"); // nombre element : 3

		//Exercice 2
		Integer[] tab = {0,1,2,3,4,5,6,7,8,9};
		
		swapElement(tab, 3, 6);
		
		for (int elem : tab) {
			System.out.print(elem + " ");
		}
		System.out.println();
		
		//Exercice 3
		
		System.out.println("Maximum de la liste : " + findMax(list));// Maximum de la liste : 451
	

		//	Exercice 4
		//	Implémenter une classe générique pour une pile (LIFO : Last In First Out).
		
		Lifo<String> lifo = new Lifo<String>();

		lifo.add("premier");
		lifo.add("second");
		
		lifo.remove();
		
		System.out.println(lifo);
		
		System.out.println(lifo.getStack());
		System.out.println(lifo);
		
		//	Exercice 5
		//	Implémenter une classe générique pour une paire de valeurs.
		
        Pair<Integer, String> pair = new Pair<>(42, "Hello");

        // Affichage des paires
        System.out.println("Paire : " + pair);

        // Modification des éléments de la paire
        pair.setFirst(100);

        System.out.println("Paire modifiée : " + pair);
	}
	
//	Exercice 1
//	Écrire une méthode générique pour trouver le nombre d'occurrences d'un élément dans une liste. 
	
	public static <T> int count(List<T> list, T element) {
		return (int) list.stream().filter(e -> e == element).count();
    }
	
//	Exercice 2
//	Écrire une méthode générique pour échanger deux éléments dans un tableau.
	public static <T> void swapElement(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

//	Exercice 3
//	Écrire une méthode générique pour trouver le maximum dans une liste.
//	Dans ce cas utiliser la méthode compareTo, les éléments doivent être comparable alors la déclaration de la fonction doit commencer ainsi:
	public static <T extends Comparable<T>> T findMax(List<T> list) {
		return list.stream().max(Comparator.naturalOrder()).orElse(null);
	}

}
