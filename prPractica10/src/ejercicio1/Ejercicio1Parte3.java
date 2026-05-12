package ejercicio1;

import java.util.*;

public class Ejercicio1Parte3 {

	public static void main(String[] args) {

		/**
		 * Añade el número 100, y posteriormente prueba a eliminarlo con remove (para ello tendrás que crear
		 * una nueva colección tipo List). Prueba también a recorrer esta nueva colección como si fuese un array
		 * (posición a posición)
		 */
		List<Integer> lista2 = new ArrayList<Integer>();

		lista2.add(100);
		lista2.add(58);
		lista2.add(2);
		lista2.add(78);
		lista2.add(12);

		for(int cont=0;cont<lista2.size();cont++) {
			System.out.print(lista2.get(cont) + " ");
		}

		System.out.println("\n\nContiene el número 100: " + (lista2.contains(100)?"Si":"No"));
		System.out.println("Contiene el número 200: " + (lista2.contains(200)?"Si":"No"));

		lista2.remove((Integer.valueOf(100))); // Lo mismo que lista2.remove((Integer)(100));
		System.out.println();

		for(int cont=0;cont<lista2.size();cont++) {
			System.out.print(lista2.get(cont) + " ");
		}
		
		lista2.sort(null); // Método de la interfaz List
//		Collections.sort(lista2); // Método de Collections
		
		System.out.println("\n\n=== Lista ordenada ===");
		
		for(int cont=0;cont<lista2.size();cont++) {
			System.out.print(lista2.get(cont) + " ");
		}
		
		// Ordenar la coleccion de forma desc (orden alternativo)
		lista2.sort(new ComparatorInteger());
		Collections.sort(lista2, new ComparatorInteger());
		
		System.out.println("\n\n=== Lista ordenada ===");
		
		for(int cont=0;cont<lista2.size();cont++) {
			System.out.print(lista2.get(cont) + " ");
		}
	}

}
