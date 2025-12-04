package jamones;

/**
 * B) Desarrollar la clase Granja, sobre una granja nos interesará conocer el nombre de la misma, si posee o
 * no denominación de origen, y el precio al que vende la arroba de carne de cerdo, independientemente
 * del tipo de este. Debes proporcionar, al menos los siguientes métodos:
 * 
 * - Constructor sobrecargado. Uno al que le llegue toda la información de la granja, y otro al que sólo
 * le llegue el nombre, en este último caso, se sobreentenderá que la granja no posee denominación
 * de origen, y que el precio de la arroba se fija a 15€.
 * 
 * - Métodos get y set.
 * 
 * - Método toString, que devuelva la información de una granja con un formato similar a los
 * siguientes ejemplos:
 * 		Los Jamoneros Andaluces, con denominación de origen - Precio base @: 20.0€
 * 		Hermanos García, S.L, sin denominación de origen - Precio base @: 17.0€

 */

public class Granja {

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private boolean denominacionOrigen;
	private float precioArrobaCarne;

	/**
	 * Constructor sobrecargado
	 */
	public Granja(String nombre, boolean denominacionOrigen, float precioArrobaCarne) {
		this.nombre = nombre;
		this.denominacionOrigen = denominacionOrigen;
		this.precioArrobaCarne = precioArrobaCarne;
	}

	public Granja(String nombre) {
		this.nombre = nombre;
		this.denominacionOrigen = false;
		this.precioArrobaCarne = 15;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isDenominacionOrigen() {
		return denominacionOrigen;
	}

	public void setDenominacionOrigen(boolean denominacionOrigen) {
		this.denominacionOrigen = denominacionOrigen;
	}

	public float getPrecioArrobaCarne() {
		return precioArrobaCarne;
	}

	public void setPrecioArrobaCarne(float precioArrobaCarne) {
		this.precioArrobaCarne = precioArrobaCarne;
	}

	/**
	 * toString redefinido
	 * 
	 * 		Los Jamoneros Andaluces, con denominación de origen - Precio base @: 20.0€
	 * 		Hermanos García, S.L, sin denominación de origen - Precio base @: 17.0€
	 */
	@Override
	public String toString() {
		return this.nombre + ", " + (this.denominacionOrigen?"con denominación de origen":"sin denominación de origen") + " - Precio base @: " + this.precioArrobaCarne + "€";
	}

}
