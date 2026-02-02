package ejercicio2;

import java.util.*;

/**
 * 2.- Crear una colección tipo List, cuyos objetos sean cadenas de texto, parametrízala de forma adecuada.
 * Cuando pidas memoria concreta a ArrayList o LinkedList, independiente de la clase que elijas, prueba
 * posteriormente con la otra.
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		// ----------------------------------------------------------
		// Definir una colección tipo List, y añadir varios elementos
		// ----------------------------------------------------------

		//		List<String> lista = new ArrayList<String>();
		List<String> lista = new LinkedList<String>();


		// • Añade diferentes elementos a la lista y recórrela para mostrar sus elementos.
		System.out.println("=== Añade diferentes elementos y muestra sus elementos ===");
		lista.add("Hola");
		lista.add("me");
		lista.add("llamo");
		lista.add("David");
		lista.add("Como");
		lista.add("te");
		lista.add("llamas");
		lista.add("tu");

		// ----------------------------------------------------------
		// Definir una colección tipo List, y añadir varios elementos
		// ----------------------------------------------------------

		//		Iterator<String> it = lista.iterator();
		//		while(it.hasNext()) {
		//			System.out.print(it.next() + " ");
		//		}

		for (Iterator<String> it2 = lista.iterator();it2.hasNext();) {
			System.out.print(it2.next() + " ");
		}

		System.out.println("\n");

		// Con for-each
		for (String elem : lista) {
			System.out.print(elem + " ");
		}

		// • Recorre la lista con ListIterator.
		System.out.println("\n\n=== Lista en orden inverso ===");
		for (ListIterator<String> li = lista.listIterator(lista.size());li.hasPrevious();) {
			System.out.print(li.previous() + " ");
		}

		System.out.println("\n");

		// Con ListIterator, modificando cada cadena a mayus
		ListIterator<String> li2 = lista.listIterator(lista.size());

		// Forma 1
		String cadena;
		while (li2.hasPrevious()) {
			cadena=li2.previous().toUpperCase();
			li2.set(cadena);
			System.out.print(cadena + " ");
		}

		// Forma 2
		while (li2.hasPrevious()) {
			li2.set(li2.previous().toUpperCase());
		}

		System.out.println("\n\n" +lista);

		// • Averigua el número de elementos de tu lista.
		System.out.println("\n=== Número de elementos ===");
		System.out.println("Nº de elementos: " + lista.size());

		// • Prueba a mostrar distintos elementos de la lista, por ejemplo, el primero, el último, el que ocupa la
		// cuarta posición, ...

		System.out.println("Primer elemento: " + lista.getFirst());
		System.out.println("Último elemento: " + lista.getLast());

		System.out.println("\nPrimer elemento: " + lista.get(0));
		System.out.println("Último elemento: " + lista.get(lista.size()-1));

		System.out.println("\nCuarto elemento: " + lista.get(3));

		// • De forma análoga, prueba a borrar determinados elementos tanto con el método remove de la
		// interfaz List, como con el de la interfaz Iterator.

		System.out.println("\n=== Borrar elementos ===");
		if (lista.remove("Llamo".toUpperCase())) {
			System.out.println("Se ha eliminado \"Llamo\"");
		}
		else {
			System.out.println("No se ha eliminado \"Llamo\"");
		}

		if (lista.remove("Me".toUpperCase())) {
			System.out.println("Se ha eliminado \"Me\"");
		}
		else {
			System.out.println("No se ha eliminado \"Me\"");
		}

		System.out.println("\n" + lista);

		// Borrado con el método remove de Iterator

		for (Iterator<String> it4 = lista.iterator();it4.hasNext();) {
			if (it4.next().equalsIgnoreCase("David")) {
				it4.remove();
			}
		}

		// Cuidado con esto que se carga la lista

		// Borra todos los elementos a partir del segundo index

		//		for (Iterator<String> it4 = lista.iterator();it4.hasNext();) {
		//			if (it4.next().equalsIgnoreCase(lista.get(2))) {
		//				it4.remove();
		//			}
		//		}

		System.out.println("\n" + lista);

		// • Prueba a llamar algún método que sea propio de la clase (no de la interfaz List).
		System.out.println("\n=== Probar métodos propios de la clase ===");
		System.out.println("Elemento primero: " + ((LinkedList<String>) lista).peek() + "\n");

		Iterator<String> itInverso = ((LinkedList<String>)lista).descendingIterator();
		while (itInverso.hasNext()) {
			System.out.print(itInverso.next() + " ");
		}

		// • Prueba a ordenar tu lista, tanto de forma ascendente, como descendente.
		System.out.println("\n\n=== Ordenar ===");
		System.out.println("\n" + lista);

		lista.sort(null);

		System.out.println("\n\n" + lista);
	}

}
