package biblioteca;

import java.util.*;

/**
 * Una clase Biblioteca que implemente la interfaz anterior, la cual mantendrá un conjunto de los usuarios
 * de la biblioteca y un conjunto ordenado por código de los libros disponibles. Esta clase deberá algunos
 * métodos propios, más los métodos de la interfaz, los cuales se detallan a continuación:
 */
public class Biblioteca implements InterfazBiblioteca {

	/**
	 * Variables de instancia
	 */
	private Set<Usuario> UsuariosBiblioteca;
	private SortedSet<Libro> LibrosDisponibles;

	/**
	 * Un constructor, métodos getter y setter.
	 */
	public Biblioteca(Set<Usuario> usuariosBiblioteca, SortedSet<Libro> librosDisponibles) {
		UsuariosBiblioteca = usuariosBiblioteca;
		LibrosDisponibles = librosDisponibles;
	}

	public Set<Usuario> getUsuariosBiblioteca() {return UsuariosBiblioteca;}
	public void setUsuariosBiblioteca(Set<Usuario> usuariosBiblioteca) {UsuariosBiblioteca = usuariosBiblioteca;}

	public SortedSet<Libro> getLibrosDisponibles() {return LibrosDisponibles;}
	public void setLibrosDisponibles(SortedSet<Libro> librosDisponibles) {LibrosDisponibles = librosDisponibles;}

	/**
	 * Método para añadir un usuario a la biblioteca.
	 */
	@Override
	public boolean altaUsuario(Usuario usu) {
		return this.UsuariosBiblioteca.add(usu);
	}

	/**
	 * Método para añadir un libro a la biblioteca.
	 */
	@Override
	public boolean altaLibro(Libro lib) {
		return this.LibrosDisponibles.add(lib);
	}

	/**
	 * Un método Libro sacarLibro(String título) que dado un título lo busque en la colección de libros
	 * de la biblioteca y devuelva una referencia al Libro cuyo título coincida con el indicado como parámetro,
	 * o bien un null en caso de no encontrar ese libro. Este método además de devolver el libro, lo extrae de
	 * la colección de libros de la biblioteca.
	 */
	@Override
	public Libro sacarLibro(String tit) {
		return ;
	}

	/**
	 * Un método Usuario buscarUsuario(String nombre) que busque un usuario en la colección de
	 * usuarios de la biblioteca, y devuelva una referencia al objeto usuario cuyo nombre coincide con la
	 * cadena de caracteres dada como argumento. Devolverá null en caso de no existir un usuario con dicho
	 * nombre.
	 */
	@Override
	public Usuario buscarUsuario(String nom) {
		return ;
	}

	/**
	 * Un método boolean prestarLibro(String titulo, String nombre) que tenga el efecto esperado
	 * de un préstamo de libro (es decir, el libro con ese título deja de estar en la colección de libros de la
	 * biblioteca y pasa a estar en la colección de libros sacados por el usuario con el nombre indicado). Podéis
	 * devolver un valor false, cuando algo vaya mal, por ejemplo, el usuario o el libro no existen, y true
	 * cuando todo vaya correctamente.
	 */
	@Override
	public boolean prestarLibro(String titulo, String nombre) {
		return ;
	}

	/**
	 * Un método boolean devuelveLibro(String titulo, String nombre) que tenga el efecto esperado
	 * de una devolución de un Libro sacado previamente por el usuario indicado, es decir, el libro ya no estará
	 * en la colección de libros sacados por el usuario, y volverá a la colección de libros de la biblioteca.
	 */
	@Override
	public boolean devolverLibro(String titulo, String nombre) {
		return ;
	}

	/**
	 * Método String librosDisponibles() devuelve una cadena con todas los libros disponibles en la
	 * biblioteca
	 */
	@Override
	public String librosDisponibles() {
		return ;
	}

	/**
	 * Método String librosPrestadosUsuario(String nombre) devuelve una cadena con todos las libros
	 * sacados por un determinado usuario.
	 */
	@Override
	public String librosPrestadosUsuario(String nombre) {
		return ;
	}

	/**
	 * Un método SortedSet<Libro> copias(String titulo) que devuelve un conjunto con todos las
	 * libros que hay con el título que se pasa como argumento.
	 */
	@Override
	public SortedSet<Libro> copias(String titulo) {
		return ;
	}

	/**
	 * Un método Set<Libro> getLibrosUsuario(String nomCli) que devuelve una colección con los
	 * libros sacados por un determinado usuario.
	 */
	@Override
	public Set<Libro> getLibrosUsuario(String nomCli) {
		return ;
	}
}
