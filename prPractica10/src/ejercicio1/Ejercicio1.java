package ejercicio1;

import java.util.*;

/**
 * 1.- Crear una colección tipo Collection, en la colección vamos a guardar de todo un poco, así que la
 * parametrizaremos a Object. A continuación, realiza las siguientes acciones sobre este objeto:
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		Collection<Object> lista = new ArrayList<Object>();

		Libro miLibro = new Libro("Brandon Sanderson", "Cosmere", true);

		// Añade varios elementos a tu colección: varias cadenas, varios números
		// (con y sin decimales), un objeto Random, varios objetos Libro.

		lista.add("Hola");
		lista.add("Adios");
		lista.add(20);
		lista.add(21);
		lista.add(22);
		lista.add(3.14);
		lista.add(new Random());
		lista.add(new Libro("J.R.R Tolkien", "El señor de los anillos", true));
		lista.add(miLibro);

		System.out.println(lista + "\n");

		// Prueba a mostrar la colección de diferentes formas, es decir, directamente, recorriéndola con
		// Iterator, utilizando el bucle foreach, ...

		// Recorrer con Iterator
		Iterator<Object> it = lista.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println();

		// Recorrer con bucle for-each
		for (Object object : lista) {
			System.out.println(object);
		}

		//  Elimina con la ayuda de Iterator, todos los números enteros.
		Iterator<Object> it2 = lista.iterator();
		Object elem;
		while(it2.hasNext()) {
			elem = it2.next();
			if (elem instanceof Integer) { // Es un número entero
				it2.remove(); // Borra el último elemento obtenido con next
			}
		}

		// Lo mismo pero con bucle for
		//		for (Iterator<Object> it3 = lista.iterator(); it3.hasNext();) {
		//			if (it3.next() instanceof Integer) { // Es un número entero
		//				it3.remove(); // Borra el último elemento obtenido con next
		//			}
		//		}

		System.out.println("\n=== Colección tras borrar los números enteros ===");
		for (Object object : lista) {
			System.out.println(object);
		}

		// Busca uno de los libros que has añadido, y modifícale su título para que aparezca todo en mayúscula.
		boolean encontrado = false;
		Object elemLibro;
		Libro libroBuscado;

		Iterator<Object> it4 = lista.iterator();
		while(encontrado==false && it4.hasNext()) {
			elemLibro = it4.next();

			if (elemLibro instanceof Libro) {
				libroBuscado = (Libro)elemLibro;
				if (((Libro) elemLibro).getTitulo().equalsIgnoreCase("El señor de los anillos")) {
					libroBuscado.setTitulo(libroBuscado.getTitulo().toUpperCase());
					encontrado=true;
				}
			}
		}

		System.out.println("\n=== Colección tras cambiar un libro a mayus ===");
		for (Object object : lista) {
			System.out.println(object);
		}
	}

}
