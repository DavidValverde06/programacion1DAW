package ejercicio3;

import java.util.*;

/**
 * 3.- Crea una colección de libros que esté ordenada por autor, y en caso de estar repetido el autor, por título
 * del libro. Añade varios libros a la colección, y finalmente muestra la colección por pantalla. Realiza dos
 * versiones diferentes del ejercicio, una en la que almacenes los libros en un conjunto ordenado, y otra en
 * una lista.
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		List<Libro> misLibros = new ArrayList<>();

		misLibros.add(new Libro("María Dueñas","Entre costuras",false));
		misLibros.add(new Libro("Sarah Lark","En el país de la nube blanca",true));
		misLibros.add(new Libro("Eduardo Punset","Viaje al optimismo",false));
		misLibros.add(new Libro("María Dueñas","Misión olvido",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Señor de los Anillos",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Hobbit",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Silmarillion",true));
		misLibros.add(new Libro("Kate Morton","El jardín olvidado",true));
		misLibros.add(new Libro("Sarah Lark","La canción de los maoríes",true));

		// ------------------------------------------------------------------
		// Ordenar la coleccion por orden natural, con sort de ArrayList,
		// y con sort de Collections
		// Orden natural: ascendente por autor y ascendente por título 
		// ------------------------------------------------------------------
		System.out.println("\nLibros ordenados por orden natural");
		//		misLibros.sort(null);
		Collections.sort(misLibros);
		for (Libro libro : misLibros) {
			System.out.println(libro);
		}

		// Ordenar la colección por orden inverso
		System.out.println("\nLibros ordenados por orden natural, en sentido inverso");
		Collections.reverse(misLibros);
		for (Libro libro : misLibros) {
			System.out.println(libro);
		}

		// ------------------------------------------------------------------
		// Ordenar la colección por orden alternativo, con sort de ArrayList,
		// y con sort de Collections
		// Orden alternativo: ascendente por autor y descendente por título
		// ------------------------------------------------------------------
		System.out.println("\nColección en orden alternativo");
		//		misLibros.sort(new OrdenAlternativo());
		Collections.sort(misLibros, new OrdenAlternativo());
		for (Libro libro : misLibros) {
			System.out.println(libro);
		}


		// ------------------------------------------------------------------
		// Identico al anterior, pero en una CLASE ANÓNIMA
		// ------------------------------------------------------------------
		Collections.sort(misLibros, new Comparator<Libro>() {
			@Override
			public int compare(Libro o1, Libro o2) {

				int compara = o1.getAutor().compareTo(o2.getAutor());

				if (compara != 0) {
					return compara; // Son distintos
				} else {
					return o2.getTitulo().compareTo(o1.getTitulo()); // Autores iguales, devuelvo titulos
				}
			} // end Método compare
		} // end Clase Anónima
				); // paréntesis de cierre del método sort

		System.out.println("\nLibros ordenados (orden alternativo): " + misLibros);


		// ------------------------------------------------------------------
		// Orden alternativo con expresión lambda (1º versión)

		Collections.sort(misLibros,(Libro o1, Libro o2) -> {
			int compareAutor = o1.getAutor().compareTo(o2.getAutor());

			if (compareAutor != 0)
				return compareAutor;
			else
				return o2.getTitulo().compareTo(o1.getTitulo());
		}
				);

		// ------------------------------------------------------------------
		// Orden alternativo con expresión lambda (2º versión)

		Collections.sort(misLibros,(o1, o2) -> {
			int compareAutor = o1.getAutor().compareTo(o2.getAutor());

			if (compareAutor != 0)
				return compareAutor;
			else
				return o2.getTitulo().compareTo(o1.getTitulo());
		}
				);
	}

}
