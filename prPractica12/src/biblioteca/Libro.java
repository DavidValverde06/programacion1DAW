package biblioteca;

import java.util.*;

/**
 * Desarrolla una clase Libro que represente copias de libros, de un libro guardaremos su código (que será
 * un String), el título del libro, el nombre del autor (suponemos que un libro tiene un único autor) y una lista
 * de personajes principales.
 * Defínanse los siguientes constructores y métodos:
 */
public class Libro {

	/**
	 * Variables de instancia
	 */
	private String codigo;
	private String titulo;
	private String nombreAutor;
	private List<String> listaPersonajes;

	/**
	 * Constructor
	 */
	public Libro(String codigo, String titulo, String nombreAutor, List<String> listaPersonajes) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.nombreAutor = nombreAutor;
		this.listaPersonajes = listaPersonajes;
	}

	/**
	 * Getter's y setter's
	 */
	public String getCodigo() {return codigo;}
	public void setCodigo(String codigo) {this.codigo = codigo;}

	public String getTitulo() {return titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}

	public String getNombreAutor() {return nombreAutor;}
	public void setNombreAutor(String nombreAutor) {this.nombreAutor = nombreAutor;}

	public List<String> getListaPersonajes() {return listaPersonajes;}
	public void setListaPersonajes(List<String> listaPersonajes) {this.listaPersonajes = listaPersonajes;}

	/**
	 * equals y hashCode
	 * 
	 * La clase Libro debe permitir la comparación entre objetos de la misma. Las copias se compararán
	 * atendiendo al valor numérico de sus códigos. 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(codigo, other.codigo);
	}

	/**
	 * toString redefinido
	 * 
	 * 0005: El Señor de los Anillos (escrito por J.R.R. Tolkien [Gandalf, Aragorn, Frodo Bolsón, Legolas, Gollum])
	 */
	@Override
	public String toString() {
		return this.codigo + ": " + this.titulo + " (escrito por " + this.nombreAutor + " " + this.listaPersonajes + ")";
	}
}
