package biblioteca;

import java.util.*;

/**
 * Probar el funcionamiento del ejercicio, creando objetos de las distintas clases y probando los distintos
 * métodos existentes en las mismas. Aquí os dejo algunos ejemplos de libros para ayudaros en las pruebas:
 */
public class TestBiblioteca {

	public static void main(String[] args) {

		List<String> personajes1 = new LinkedList<String>();
		personajes1.add("Don Quijote de la Mancha");
		personajes1.add("Sancho Panza");
		personajes1.add("Dulcinea del Toboso");
		personajes1.add("Rocinante");
		Libro libro1 = new Libro("0001","Don Quijote de la Mancha","Miguel de Cervantes Saavedra",
				personajes1);

		// Otra forma más corta de crear la colección de personajes
		Libro libro2 = new Libro("0002","Los pilares de la Tierra","Ken Follet",
				Arrays.asList("Aliena","Jack Jackson","Regan Hamleigh"));
		Libro libro3 = new Libro("0003","El tiempo entre costuras","María Dueñas",
				Arrays.asList("Sira Quiroga","Ramiro Arribas", "Marcus Logan"));
		Libro libro4 = new Libro("0004","El principito","Antoine de Saint-Exupary",
				Arrays.asList("The Little Prince","El vanidoso","Le renard"));
		Libro libro5 = new Libro("0005","El Señor de los Anillos","J.R.R. Tolkien",
				Arrays.asList("Gandalf","Aragorn","Frodo Bolsón","Legolas","Gollum"));
		Libro libro6 = new Libro("0006","Cien Años de Soledad","Gabriel García Márquez",
				Arrays.asList("José Arcadio Buendía","Coronel Aureliano Buendía"));
		Libro libro7 = new Libro("0007","El principito","Antoine de Saint-Exupary",
				Arrays.asList("The Little Prince","El vanidoso","Le renard"));

		// Libros
		System.out.println("LIBROS");
		System.out.println(libro1 + "\n");
		System.out.println(libro2 + "\n");
		System.out.println(libro3 + "\n");
		System.out.println(libro4 + "\n");
		System.out.println(libro5 + "\n");
		System.out.println(libro6 + "\n");
		System.out.println(libro7 + "\n");
	}

}
