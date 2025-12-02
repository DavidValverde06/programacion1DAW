package biblioteca;

/**
 *  Se quiere informatizar una biblioteca. Crea las clases Publicacion, Libro y Revista.
 *  
 *  Las clases deben estar implementadas con la jerarquía correcta. 
 *  Las características comunes de las revistas y de los libros son el código ISBN, el título, y el año de publicación.
 *  Los libros tienen además un atributo prestado.
 *  
 *  Cuando se crean los libros, no están prestados.
 *  
 *  Las revistas tienen un número.
 *   
 *  La clase Libro debe implementar la interfaz Prestable que tiene los métodos presta, devuelve y estaPrestado.
 */

public class Publicacion {

	/**
	 * Variables de instancia
	 */
	private int codISBN;
	private String titulo;
	private int anioPublicacion;
	
	/**
	 * Constructor
	 */
	public Publicacion(int codISBN, String titulo, int anioPublicacion) {
		this.codISBN = codISBN;
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
	}
	
	/**
	 * Getter's y setter's
	 */
	public int getCodISBN() {
		return codISBN;
	}

	public void setCodISBN(int codISBN) {
		this.codISBN = codISBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() +
				"\nCódigo ISBN: " + this.codISBN +
				"\nTitulo: " + this.titulo +
				"\nAño de publicación: " + this.anioPublicacion;
	}
}
