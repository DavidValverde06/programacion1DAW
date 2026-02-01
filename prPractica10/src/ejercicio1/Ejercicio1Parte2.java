package ejercicio1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ejercicio1Parte2 {

	public static void main(String[] args) {
		Collection<Object> lista = new ArrayList<Object>();
		List<Object> lista2 = new ArrayList<Object>();

		Libro miLibro = new Libro("Brandon Sanderson", "Cosmere", true);
		Libro miLibroPrueba = new Libro("Cervantes", "Quijote", true);

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
		lista.add(miLibroPrueba);

		// Prueba los métodos contains y remove, tanto con cadenas y números como con libros.

		// Prueba del método remove
		System.out.println(lista);

		lista.remove("Hola");
		lista.remove("Holi");
		lista.remove(22);
		lista.remove(20);
		lista.remove(miLibro);
		lista.remove(new Libro("J.R.R Tolkien", "El señor de los anillos", true));

		System.out.println("\n" + lista);

		// Prueba del método contains
		System.out.println("\n¿La colección contiene el número 20? " + (lista.contains(20)?"Si":"No"));
		System.out.println("¿La colección contiene el número 100? " + (lista.contains(100)?"Si":"No"));

		System.out.println("\n¿La colección contiene la cadena \"Hola\"? " + (lista.contains("Hola")?"Si":"No"));
		System.out.println("¿La colección contiene la cadena \"Holi\"? " + (lista.contains("Holi")?"Si":"No"));

		System.out.println("\n¿La colección contiene el libro El señor de los anillos? " + (lista.contains(new Libro("J.R.R Tolkien", "El señor de los anillos", true))?"Si":"No"));
		System.out.println("¿La colección contiene el libro El señor de los ajillos? " + (lista.contains(new Libro("J.R.R Tolkien", "El señor de los ajillos", true))?"Si":"No"));

		// En este caso comparamos con dos objetos Libro diferentes pero con el mismo contenido
		// Si anulo equals de la clase libro nos dira que no existe.

		// Y en este caso comparamos el objeto consigo mismo
		// Si anulo equals de la clase Libro, nos dira que si existe, ya
		// que utiliza equals de la clase Object, y compara solo direcciones de memoria.

		System.out.println("\n¿La colección contiene el libro Quijote? " + (lista.contains(miLibroPrueba)?"Si":"No"));

		/**
		 * Añade el número 100, y posteriormente prueba a eliminarlo con remove (para ello tendrás que crear
		 * una nueva colección tipo List). Prueba también a recorrer esta nueva colección como si fuese un array
		 * (posición a posición)
		 */
		lista2.add(100);
		lista2.add("Hola");
		lista2.add(2);
		System.out.println("\n" + lista2 + "\n");

		Iterator<Object> it = lista2.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}

		System.out.println("\n");

		for (Object object : lista2) {
			System.out.print(object + " ");
		}

		System.out.println("\n");

		for (Iterator<Object> it3 = lista2.iterator(); it3.hasNext();) {
			System.out.print(it3.next() + " ");
		}

		lista2.remove((Integer)(100));
		lista2.remove("Hola");
		lista2.remove(lista2.getLast());
		System.out.println("\n\n" + lista2);



	}

}
