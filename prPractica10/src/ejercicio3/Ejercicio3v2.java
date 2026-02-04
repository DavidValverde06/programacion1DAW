package ejercicio3;

import java.util.*;;

/**
 * 3.- Crea una colección de libros que esté ordenada por autor, y en caso de estar repetido el autor, por título
 * del libro. Añade varios libros a la colección, y finalmente muestra la colección por pantalla. Realiza dos
 * versiones diferentes del ejercicio, una en la que almacenes los libros en un conjunto ordenado, y otra en
 * una lista.
 */
public class Ejercicio3v2 {

	public static void main(String[] args) {

		SortedSet<Libro> misLibros = new TreeSet<>();
//		TreeSet<Libro> misLibros = new TreeSet<>();

		// Añado varios libros
		misLibros.add(new Libro("María Dueñas","Entre costuras",false));
		misLibros.add(new Libro("Sarah Lark","En el país de la nube blanca",true));
		misLibros.add(new Libro("Eduardo Punset","Viaje al optimismo",false));
		misLibros.add(new Libro("María Dueñas","Misión olvido",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Señor de los Anillos",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Hobbit",true));
		misLibros.add(new Libro("J.R.R. Tolkien","El Silmarillion",true));
		misLibros.add(new Libro("Kate Morton","El jardín olvidado",true));
		misLibros.add(new Libro("Sarah Lark","La canción de los maoríes",true));

		System.out.println("=== Lista de libros ===");
		for(Iterator<Libro> it = misLibros.iterator();it.hasNext();) {
			System.out.println(it.next() + "\n");
		}

		// Recorrer la coleccion hacia atras con ListIterator
		// Tenemos que convertir la coleccion en List, porque SortedSet, no dispone de ListIterator
		List<Libro> misLibros2 = new ArrayList<>(misLibros);
		for (ListIterator<Libro> lit = misLibros2.listIterator(misLibros.size());lit.hasPrevious();) {
			System.out.println(lit.previous());
		}
		
		// Añadir un libro repetido
		if (misLibros.add(new Libro("J.R.R. Tolkien","El Señor de los Anillos",true))) { // Si cambias el titulo del libro si se podrá añadir
			System.out.println("Libro añadido");
		}
		else {
			System.out.println("El libro no se pudo añadir");
		}
		
//		misLibros.sort(new ComparatorLibro());

		System.out.println("////////////////////////////////////////////////////////////////");

		System.out.println("=== Lista de libros ordenada ===");
		for(Iterator<Libro> it = misLibros.iterator();it.hasNext();) {
			System.out.println(it.next() + "\n");
		}

	}

}
