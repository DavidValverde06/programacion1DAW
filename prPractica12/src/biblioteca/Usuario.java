package biblioteca;

import java.util.*;

/**
 * Desarrolla una clase Usuario que implemente la interfaz anterior, y que represente a un usuario con su
 * nombre y los libros sacados por dicho usuario en un momento determinado. Los libros que tiene sacados
 * un usuario se almacenarán en una colección que no permita elementos repetidos (por ejemplo, un
 * HashSet). Defínanse los siguientes constructores y métodos:
 */
public class Usuario implements InterfazUsuario{

	/**
	 * Variables de instancia
	 */
	private String nombreUsuario;
	private Set<Libro> coleccionLibrosSacados;

	/**
	 * Constructor
	 */
	public Usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.coleccionLibrosSacados = new HashSet<Libro>();
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombreUsuario() {return nombreUsuario;}
	public void setNombreUsuario(String nombreUsuario) {this.nombreUsuario = nombreUsuario;}

	public Set<Libro> getColeccionLibros() {return coleccionLibrosSacados;}
	public void setColeccionLibros(Set<Libro> coleccionLibros) {this.coleccionLibrosSacados = coleccionLibros;}

	/**
	 * boolean sacaLibro(Libro lib). Método que añada el libro lib al conjunto de libros sacados
	 * por el usuario que reciba el mensaje.
	 */
	@Override
	public boolean sacaLibro(Libro lib) {
		return this.coleccionLibrosSacados.add(lib);
	}

	/**
	 * int cantidadLibrosSacados().
	 */
	@Override
	public int cantidadLibrosSacados() {
		return this.coleccionLibrosSacados.size();
	}

	/**
	 * boolean puedeSacarMasLibros(). El usuario no podrá sacar más de 10 libros.
	 */
	@Override
	public boolean puedeSacarMasLibros() {
		if (this.coleccionLibrosSacados.size()>10) {
			return false;
		}
		return true;
	}

	/**
	 * Libro devuelveLibro(String tit). Método que extraiga el libro con título tit del conjunto de
	 * libros sacados por el usuario que recibe el mensaje. Dicho libro será devuelto como resultado del
	 * método; si el libro no ha sido sacado por dicho usuario debe devolverse null.
	 */
	@Override
	public Libro devuelveLibro(String titulo) {
		for (Libro libro : coleccionLibrosSacados) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				return libro;
			}
		}
		return null;
	}

	/**
	 * Métodos equals y hashCode de la clase Object. Dos usuarios son iguales si tienen el
	 * mismo nombre (sin distinguir mayúsculas y minúsculas).
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombreUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombreUsuario, other.nombreUsuario);
	}

	/**
	 * Redefinición de toString, con una salida similar a los siguientes ejemplos (sólo se mostrará el título del
	 * libro):
	 * 		José Mª García (El Señor de los Anillos; Don Quijote de la Mancha;)
	 * 		María López (No tiene libros sacados)
	 */
	@Override
	public String toString() {
		return this.nombreUsuario + " (" + this.coleccionLibrosSacados + ")";
	}
}
