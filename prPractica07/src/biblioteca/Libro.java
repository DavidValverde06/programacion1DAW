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

public class Libro extends Publicacion implements Prestable {

	/**
	 * Variables de instancia
	 */
	private boolean prestado;
	
	/**
	 * Constructor
	 */
	public Libro(int codISBN, String titulo, int anioPublicacion) {
		super(codISBN, titulo, anioPublicacion);
	}
	
	/**
	 * Getter's y setter's
	 */

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nPrestado: " + (this.prestado==true?"Si":"No");
	}

	/**
	 * Método de la interfaz Prestable
	 */
	@Override
	public void presta() {
		this.prestado=true;
		System.out.println("Libro prestado...");
	}

	@Override
	public void devuelve() {
		this.prestado=false;
		System.out.println("Libro devuelto...");
	}

	@Override
	public boolean estaPrestado() {
		return this.prestado;
	}
}
