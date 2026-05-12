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
	private Set<Usuario> usuariosBiblioteca;
	private SortedSet<Libro> librosDisponibles;

	/**
	 * Constructor
	 */
	public Biblioteca(Set<Usuario> usuariosBiblioteca, SortedSet<Libro> librosDisponibles) {
		this.usuariosBiblioteca = usuariosBiblioteca;
		this.librosDisponibles = librosDisponibles;
	}

	/**
	 * Getter's y setter's
	 */
	public Set<Usuario> getUsuariosBiblioteca() {return usuariosBiblioteca;}
	public void setUsuariosBiblioteca(Set<Usuario> usuariosBiblioteca) {this.usuariosBiblioteca = usuariosBiblioteca;}

	public SortedSet<Libro> getLibrosDisponibles() {return librosDisponibles;}
	public void setLibrosDisponibles(SortedSet<Libro> librosDisponibles) {this.librosDisponibles = librosDisponibles;}

	/**
	 * Método para añadir un usuario a la biblioteca.
	 */
	@Override
	public boolean altaUsuario(Usuario usu) {
		return this.usuariosBiblioteca.add(usu);
	}

	/**
	 * Método para añadir un libro a la biblioteca.
	 */
	@Override
	public boolean altaLibro(Libro lib) {
		return this.librosDisponibles.add(lib);
	}

	/**
	 * Un método Libro sacarLibro(String título) que dado un título lo busque en la colección de libros
	 * de la biblioteca y devuelva una referencia al Libro cuyo título coincida con el indicado como parámetro,
	 * o bien un null en caso de no encontrar ese libro. Este método además de devolver el libro, lo extrae de
	 * la colección de libros de la biblioteca.
	 */
	@Override
	public Libro sacarLibro(String tit) {
		Libro libroSacado = null;

		for (Libro libro : librosDisponibles) {
			if (libro.getTitulo().equalsIgnoreCase(tit) && libroSacado == null) {
				libroSacado=libro;
			}
		}

		if (libroSacado != null) {
			librosDisponibles.remove(libroSacado);
		}

		return libroSacado;
	}

	/**
	 * Un método Usuario buscarUsuario(String nombre) que busque un usuario en la colección de
	 * usuarios de la biblioteca, y devuelva una referencia al objeto usuario cuyo nombre coincide con la
	 * cadena de caracteres dada como argumento. Devolverá null en caso de no existir un usuario con dicho
	 * nombre.
	 */
	@Override
	public Usuario buscarUsuario(String nom) {
		Usuario usuarioBuscado = null;

		for (Usuario usuario : usuariosBiblioteca) {
			if (usuario.getNombreUsuario().equalsIgnoreCase(nom)) {
				usuarioBuscado = usuario;
			}
		}

		return usuarioBuscado;
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
		Libro libroAprestar = null;
		Usuario usuarioEncontrado = null;
		boolean exito = false;

		// Buscar libro en la biblioteca
		for (Libro libro : librosDisponibles) {
			if (libro.getTitulo().equalsIgnoreCase(titulo) && libroAprestar == null) {
				libroAprestar = libro;
			}
		}

		// Buscar usuario en la biblioteca
		for (Usuario usuario : usuariosBiblioteca) {
			if (usuario.getNombreUsuario().equalsIgnoreCase(nombre) && usuarioEncontrado == null) {
				usuarioEncontrado = usuario;
			}
		}

		// Si ambos existen, realizar el préstamo
		if (libroAprestar != null && usuarioEncontrado != null) {
			// Intentar añadir el libro al usuario
			exito = usuarioEncontrado.sacaLibro(libroAprestar);
			if (exito) {
				// Si se añadió correctamente al usuario, quitar de la biblioteca
				librosDisponibles.remove(libroAprestar);
			}
		}

		return exito;
	}

	/**
	 * Un método boolean devuelveLibro(String titulo, String nombre) que tenga el efecto esperado
	 * de una devolución de un Libro sacado previamente por el usuario indicado, es decir, el libro ya no estará
	 * en la colección de libros sacados por el usuario, y volverá a la colección de libros de la biblioteca.
	 */
	@Override
	public boolean devolverLibro(String titulo, String nombre) {
		Usuario usuarioEncontrado = null;
		Libro libroADevolver = null;
		boolean exito = false;

		// Buscar usuario en la biblioteca
		for (Usuario usuario : usuariosBiblioteca) {
			if (usuario.getNombreUsuario().equalsIgnoreCase(nombre) && usuarioEncontrado == null) {
				usuarioEncontrado = usuario;
			}
		}

		// Si existe el usuario, pedirle que devuelva el libro
		if (usuarioEncontrado != null) {
			libroADevolver = usuarioEncontrado.devuelveLibro(titulo);
			if (libroADevolver != null) {
				// Si el libro existía en su colección, añadirlo a la biblioteca
				librosDisponibles.add(libroADevolver);
				exito = true;
			}
		}

		return exito;
	}

	/**
	 * Método String librosDisponibles() devuelve una cadena con todas los libros disponibles en la
	 * biblioteca
	 */
	@Override
	public String librosDisponibles() {
		String libros = "";

		for (Libro libro : librosDisponibles) {
			libros += libro.getTitulo() + " ";
		}

		return libros;
	}

	/**
	 * Método String librosPrestadosUsuario(String nombre) devuelve una cadena con todos las libros
	 * sacados por un determinado usuario.
	 */
	@Override
	public String librosPrestadosUsuario(String nombre) {
		String cadena = "";

		for (Usuario usuario : usuariosBiblioteca) {
			if (usuario.getNombreUsuario().equalsIgnoreCase(nombre)) {
				for (Libro usuario2 : usuario.getColeccionLibros()) {
					cadena += usuario2.getTitulo() + " ";
				}
			}
		}

		return cadena;
	}

	/**
	 * Un método SortedSet<Libro> copias(String titulo) que devuelve un conjunto con todos los
	 * libros que hay con el título que se pasa como argumento.
	 */
	@Override
	public SortedSet<Libro> copias(String titulo) {
		SortedSet<Libro> copias = new TreeSet<>();

		for (Libro libro : librosDisponibles) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				copias.add(libro);
			}
		}

		return copias;
	}

	/**
	 * Un método Set<Libro> getLibrosUsuario(String nomCli) que devuelve una colección con los
	 * libros sacados por un determinado usuario.
	 */
	@Override
	public Set<Libro> getLibrosUsuario(String nomCli) {
		Set<Libro> librosUsu = new TreeSet<>();

		for (Usuario usuario : usuariosBiblioteca) {
			if (usuario.getNombreUsuario().equalsIgnoreCase(nomCli)) {
				librosUsu.addAll(usuario.getColeccionLibros());
			}
		}

		return librosUsu;
	}
}
