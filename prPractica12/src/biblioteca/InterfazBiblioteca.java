package biblioteca;

import java.util.*;

/**
 *  Diseña un interfaz InterfazBiblioteca, que defina los comportamientos esenciales de cualquier usuario
 *  que interactúe con libros en un sistema de gestión de biblioteca. Estos comportamientos serán:
 */
public interface InterfazBiblioteca {

	public boolean altaUsuario(Usuario usu);

	boolean altaLibro(Libro lib);

	Libro sacarLibro(String tit);

	Usuario buscarUsuario(String nom);

	boolean prestarLibro(String titulo,String nombre);

	boolean devolverLibro(String titulo, String nombre);

	String librosDisponibles();

	String librosPrestadosUsuario(String nombre);

	SortedSet<Libro> copias(String titulo);

	Set<Libro> getLibrosUsuario(String nomCli);
}
