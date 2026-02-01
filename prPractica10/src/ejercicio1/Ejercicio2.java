package ejercicio1;

import java.util.*;

/**
 * 2.- Crear una colección tipo List, cuyos objetos sean cadenas de texto, parametrízala de forma adecuada.
 * Cuando pidas memoria concreta a ArrayList o LinkedList, independiente de la clase que elijas, prueba
 * posteriormente con la otra.
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		List<String> lista = new ArrayList<String>();

		// • Añade diferentes elementos a la lista y recórrela para mostrar sus elementos.
		lista.add("Hola");
		lista.add("me");
		lista.add("llamo");
		lista.add("David");

		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}

		// • Recorre la lista con ListIterator.


		// • Averigua el número de elementos de tu lista.

		// • Prueba a mostrar distintos elementos de la lista, por ejemplo, el primero, el último, el que ocupa la
		// cuarta posición, ...

		// • De forma análoga, prueba a borrar determinados elementos tanto con el método remove de la
		// interfaz List, como con el de la interfaz Iterator.

		// • Prueba a llamar algún método que sea propio de la clase (no de la interfaz List).

		// • Prueba a ordenar tu lista, tanto de forma ascendente, como descendente.

	}

}
