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

/**
 * En cuanto a las interfaces recuerda:
 * 		• La interfaz indica “qué” hay que hacer y la implementación especifica “cómo” se hace.
 * 		• Una interfaz puede tener varias implementaciones.
 * 		• Una interfaz no se puede instanciar.
 * 		• La implementación puede contener métodos adicionales cuyas cabeceras no están en su interfaz.
 */

public interface Prestable {

	/**
	 * Método presta()
	 */
	public void presta();
	
	/**
	 * Método devuelve()
	 */
	public void devuelve();
	
	/**
	 * Método estaPrestado()
	 */
	public boolean estaPrestado();
	
}
