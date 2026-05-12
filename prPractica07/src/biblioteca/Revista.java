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

public class Revista extends Publicacion {

	/**
	 * Variables de instancia
	 */
	private int numeroRevista;

	/**
	 * Constructor
	 */
	public Revista(int codISBN, String titulo, int anioPublicacion, int numeroRevista) {
		super(codISBN, titulo, anioPublicacion);
		this.numeroRevista = numeroRevista;
	}
	
	/**
	 * Getter's y setter's
	 */
	public int getNumeroRevista() {
		return numeroRevista;
	}

	public void setNumeroRevista(int numeroRevista) {
		this.numeroRevista = numeroRevista;
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nNúmero de revista: " + this.numeroRevista;
	}
	
}
