package ejercicio8;

import java.util.*;

/**
 * 8.- Con la ayuda de las colecciones, genera una lista de 50 números aleatorios que no estén repetidos.
 * Finalmente muestra la lista en pantalla.
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		SortedSet<Integer> listaNumeros = new TreeSet<>();

		do {
			listaNumeros.add((int)(Math.random()*50)+1);
		}
		while (listaNumeros.size()!=50);

		System.out.println(listaNumeros);

		System.out.println("\nCantidad de números en la lista: " + listaNumeros.size());
	}

}
