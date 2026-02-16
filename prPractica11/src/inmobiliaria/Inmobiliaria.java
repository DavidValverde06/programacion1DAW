package inmobiliaria;

import java.util.*;

/**
 * Diseñar una clase llamada Inmobiliaria, esta clase almacenará una colección de las propiedades que la
 * inmobiliaria tiene a la venta. La colección debe estar ordenada de forma ascendente por el código de la
 * propiedad, y no debe permitir que haya dos propiedades con el mismo código. Utiliza la colección que
 * estimes más conveniente.
 * 
 * La clase debe ofrecer, al menos, los siguientes métodos:
 */
public class Inmobiliaria implements GestionInmobiliaria {

	/**
	 * Variables de instancia
	 */
	private Set<Propiedad> coleccionPropiedad;

	/**
	 * Constructor sobrecargado
	 */
	public Inmobiliaria(Set<Propiedad> coleccionPropiedad) {
		this.coleccionPropiedad = coleccionPropiedad;
	}

	public Inmobiliaria() {
		this.coleccionPropiedad = new TreeSet<Propiedad>();
	}

	/**
	 * Getter's y setter's
	 */
	public Set<Propiedad> getColeccionPropiedad() {
		return coleccionPropiedad;
	}

	public void setColeccionPropiedad(Set<Propiedad> coleccionPropiedad) {
		this.coleccionPropiedad = coleccionPropiedad;
	}

	// ================================================
	// == Métodos de la interfaz GestionInmobiliaria ==
	// ================================================
	/**
	 * Método al cual le llegue una propiedad y la añada a la
	 * colección de propiedades que mantiene la inmobiliaria.
	 */
	@Override
	public boolean añade(Propiedad ob) {
		return this.coleccionPropiedad.add(ob);
	}

	/**
	 * Método que permita buscar una propiedad a partir de su
	 * código en la colección.
	 */
	@Override
	public Propiedad buscar(int codigo) {
		return null;
	}

	/**
	 * Método que comprueba si una determinada propiedad
	 * existe en la colección.
	 */
	@Override
	public boolean buscar(Propiedad p) {
		return this.coleccionPropiedad.contains(p);
	}

	/**
	 * Método que permita borrar una propiedad a partir de su código.
	 */
	@Override
	public Propiedad borra(int cod) {
		return null;

	}

	/**
	 * Método que permita borrar una propiedad a partir del objeto Propiedad.
	 */
	@Override
	public boolean borra(Propiedad p) {
		return false;

	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase() +
				"\nColección de propiedades " + this.coleccionPropiedad;
	}

	/**
	 * ✓ List<Propiedad> getPropiedadesOrdenPrecio(). Método que devuelve una nueva colección
	 * con las propiedades ordenadas por precio.
	 */
	public List<Propiedad> getPropiedadesOrdenPrecio() {
		return null;
	}

	/**
	 * ✓ String getPropiedadesOrdenPrecioString(). Método que devuelve una cadena con un
	 * resumen de todas las propiedades ordenadas por su precio, por ejemplo:
	 * 			LISTA ORDENADA POR PRECIO
	 * 			23 - 60000.0 - LOCAL
	 * 			12 - 240000.0 - VIVIENDA
	 * 			2 - 400000.0 - FINCA
	 */
	public String getPropiedadOrdenPrecioString() {
		return null;
	}

}
