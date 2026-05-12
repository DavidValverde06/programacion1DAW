package ejercicio8;

import java.util.*;

/**
 * 8.- Con la ayuda de las colecciones, genera una lista de 50 números aleatorios que no estén repetidos.
 * Finalmente muestra la lista en pantalla.
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		SortedSet<Integer> listaNumSinRepetir = new TreeSet<>();

		do {
			listaNumSinRepetir.add((int)(Math.random()*50)+1);
		}
		while (listaNumSinRepetir.size()!=50);

		System.out.println(listaNumSinRepetir);

		System.out.println("\nCantidad de números en la lista: " + listaNumSinRepetir.size());
	}

}
