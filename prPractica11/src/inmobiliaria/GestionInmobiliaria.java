package inmobiliaria;

/**
 * Diseña un interfaz GestionInmobiliaria que establezca los métodos que cualquier clase que maneje
 * propiedades inmobiliarias debería implementar. Así en un futuro podríamos tener distintas
 * implementaciones distintas de inmobiliarias, por ejemplo, una inmobiliaria especializada sólo en
 * viviendas o en alquileres. Los métodos de esta interfaz deben ser, al menos, los siguientes:
 */
public interface GestionInmobiliaria {

	/**
	 * Método al cual le llegue una propiedad y la añada a la
	 * colección de propiedades que mantiene la inmobiliaria.
	 */
	public boolean añade(Propiedad ob);

	/**
	 * Método que permita buscar una propiedad a partir de su
	 * código en la colección.
	 */
	public Propiedad buscar(int codigo);

	/**
	 * Método que comprueba si una determinada propiedad
	 * existe en la colección.
	 */
	public boolean buscar(Propiedad p);

	/**
	 * Método que permita borrar una propiedad a partir de su código.
	 */
	public Propiedad borra(int cod);

	/**
	 * Método que permita borrar una propiedad a partir del objeto Propiedad.
	 */
	public boolean borra(Propiedad p);
}
