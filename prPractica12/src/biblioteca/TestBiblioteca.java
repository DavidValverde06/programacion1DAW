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

		Libro libro1 = new Libro("0001","Don Quijote de la Mancha","Miguel de Cervantes Saavedra",personajes1);

		// Otra forma más corta de crear la colección de personajes
		Libro libro2 = new Libro("0002","Los pilares de la Tierra","Ken Follet",Arrays.asList("Aliena","Jack Jackson","Regan Hamleigh"));
		Libro libro3 = new Libro("0003","El tiempo entre costuras","María Dueñas",Arrays.asList("Sira Quiroga","Ramiro Arribas", "Marcus Logan"));
		Libro libro4 = new Libro("0004","El principito","Antoine de Saint-Exupary",Arrays.asList("The Little Prince","El vanidoso","Le renard"));
		Libro libro5 = new Libro("0005","El Señor de los Anillos","J.R.R. Tolkien",Arrays.asList("Gandalf","Aragorn","Frodo Bolsón","Legolas","Gollum"));
		Libro libro6 = new Libro("0006","Cien Años de Soledad","Gabriel García Márquez",Arrays.asList("José Arcadio Buendía","Coronel Aureliano Buendía"));
		Libro libro7 = new Libro("0007","El principito","Antoine de Saint-Exupary",Arrays.asList("The Little Prince","El vanidoso","Le renard"));

		// Creación usuarios
		Usuario usuario1 = new Usuario("David");
		Usuario usuario2 = new Usuario("Noemí");

		// Crear biblioteca
		Set<Usuario> usuarios = new HashSet<>();
		SortedSet<Libro> libros = new TreeSet<>();
		Biblioteca biblioteca = new Biblioteca(usuarios, libros);

		// Añadir usuarios y libros
		biblioteca.altaUsuario(usuario1);
		biblioteca.altaUsuario(usuario2);

		biblioteca.altaLibro(libro1);
		biblioteca.altaLibro(libro2);
		biblioteca.altaLibro(libro3);
		biblioteca.altaLibro(libro4);
		biblioteca.altaLibro(libro5);
		biblioteca.altaLibro(libro6);
		biblioteca.altaLibro(libro7);

		System.out.println("LIBROS DISPONIBLES INICIALES:");
		System.out.println(biblioteca.librosDisponibles());

		System.out.println("\nPRESTAR LIBROS:");
		boolean prestado1 = biblioteca.prestarLibro("El Señor de los Anillos","David");
		boolean prestado2 = biblioteca.prestarLibro("El principito","Noemí");
		System.out.println("Prestado 'El Señor de los Anillos' a David: " + prestado1);
		System.out.println("Prestado 'El principito' a Noemí: " + prestado2);

		System.out.println("\nLIBROS DISPONIBLES DESPUÉS DE PRÉSTAMOS:");
		System.out.println(biblioteca.librosDisponibles());

		System.out.println("\nLIBROS PRESTADOS USUARIO David:");
		System.out.println(biblioteca.librosPrestadosUsuario("David"));

		System.out.println("\nDEVOLVER LIBROS:");
		boolean devuelto = biblioteca.devolverLibro("El Señor de los Anillos","David");
		System.out.println("Devuelto 'El Señor de los Anillos' por David: " + devuelto);

		System.out.println("\nLIBROS DISPONIBLES DESPUÉS DE DEVOLUCIÓN:");
		System.out.println(biblioteca.librosDisponibles());

		System.out.println("\nCOPIAS DEL PRINCIPITO:");
		SortedSet<Libro> copiasPrincipito = biblioteca.copias("El principito");
		for (Libro l : copiasPrincipito) {
			System.out.println(l);
		}

		System.out.println("\nLIBROS USUARIO Noemí:");
		Set<Libro> librosNoemi = biblioteca.getLibrosUsuario("Noemí");
		for (Libro l : librosNoemi) {
			System.out.println(l.getTitulo());
		}
	}
}
