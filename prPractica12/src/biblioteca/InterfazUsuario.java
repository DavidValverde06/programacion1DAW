package biblioteca;

/**
 *  Diseña un interfaz InterfazUsuario, que defina los comportamientos esenciales de cualquier usuario que
 *  interactúe con libros en un sistema de gestión de biblioteca. Estos comportamientos serán:
 */
public interface InterfazUsuario {

	/**
	 * boolean sacaLibro(Libro lib). Método que añada el libro a la estructura de datos donde se
	 * almacenen los libros sacados por el usuario que reciba el mensaje.
	 */
	public boolean sacaLibro(Libro lib);

	/**
	 * int cantidadLibrosSacados(). Método que informe del número de libros sacados por el usuario.
	 */
	public int cantidadLibrosSacados();

	/**
	 * boolean puedeSacarMasLibros(). Método que informe de si el usuario puede o no sacar más libros.
	 */
	public boolean puedeSacarMasLibros();

	/**
	 * Libro devuelveLibro(String tit). Método que extraiga el libro con título tit de la estructura de
	 * datos de libros sacados por el usuario que recibe el mensaje. 
	 */
	Libro devuelveLibro(String titulo);
}
