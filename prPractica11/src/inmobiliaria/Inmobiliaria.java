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
	private Set<Propiedad> coleccionPropiedadesEnVenta;

	/**
	 * Constructor sobrecargado
	 */
	public Inmobiliaria(Set<Propiedad> coleccionPropiedad) {
		this.coleccionPropiedadesEnVenta = coleccionPropiedad;
	}

	public Inmobiliaria() {
		this.coleccionPropiedadesEnVenta = new TreeSet<Propiedad>();
	}

	/**
	 * Getter's y setter's
	 */
	public Set<Propiedad> getColeccionPropiedad() {return coleccionPropiedadesEnVenta;}
	public void setColeccionPropiedad(Set<Propiedad> coleccionPropiedad) {this.coleccionPropiedadesEnVenta = coleccionPropiedad;}

	// ================================================
	// == Métodos de la interfaz GestionInmobiliaria ==
	// ================================================

	/**
	 * Método al cual le llegue una propiedad y la añada a la
	 * colección de propiedades que mantiene la inmobiliaria.
	 */
	@Override
	public boolean añade(Propiedad ob) {
		return this.coleccionPropiedadesEnVenta.add(ob);
	}

	/**
	 * Método que permita buscar una propiedad a partir de su
	 * código en la colección.
	 * 
	 * Tienes que:
	 * 1. Recorrer la colección.
	 * 2. Comparar el código de cada propiedad.
	 * 3. Si coincide → devolver esa propiedad.
	 * 4. Si termina el bucle y no encuentra nada → devolver null.
	 */
	@Override
	public Propiedad buscar(int codigo) {
		for (Propiedad propiedad : coleccionPropiedadesEnVenta) {
			if (propiedad.getCodigo()==codigo) {
				return propiedad;
			}
		}
		return null;
	}

	/**
	 * Método que comprueba si una determinada propiedad
	 * existe en la colección.
	 */
	@Override
	public boolean buscar(Propiedad p) {
		return this.coleccionPropiedadesEnVenta.contains(p);
	}

	/**
	 * Método que permita borrar una propiedad a partir de su código.
	 * 
	 * 1️. Llamar a buscar(cod)
	 * 2️. Guardar lo que devuelve en una variable
	 * 3️. Si esa variable NO es null → eliminarla de la colección
	 * 4️. Devolver esa misma variable
	 */
	@Override
	public Propiedad borra(int cod) {
		Propiedad propiedad = buscar(cod);
		if (propiedad!=null) {
			this.coleccionPropiedadesEnVenta.remove(propiedad);
		}
		return propiedad;
	}

	/**
	 * Método que permita borrar una propiedad a partir del objeto Propiedad.
	 */
	@Override
	public boolean borra(Propiedad p) {
		return this.coleccionPropiedadesEnVenta.remove(p);
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		String coleccionPropiedades="";
		for (Propiedad propiedad : coleccionPropiedadesEnVenta) {
			coleccionPropiedades += propiedad.toString() + "\n\n";
		}
		return (coleccionPropiedades.isEmpty()?"No existen propiedades en esta inmobiliaria":coleccionPropiedades);
	}

	/**
	 * ✓ List<Propiedad> getPropiedadesOrdenPrecio(). Método que devuelve una nueva colección
	 * con las propiedades ordenadas por precio.
	 */
	public List<Propiedad> getPropiedadesOrdenPrecio() {

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

	}

}
