package vinos;

/**
 * B) Clase Cosecha o Vendimia, sobre la cual tendremos la siguiente información: descripción de la misma,
 * tipo de recogida (puede ser manual o mecánica), y el tipo de uva (puede ser blanca o negra).
 * Los métodos que tendremos disponibles serán:
 * 
 * 		- Constructor sobrecargado, uno al que le llegue toda la información de la Cosecha, otro al que le
 * 		llegue sólo la descripción y el tipo de uva, y por último uno al que sólo le llegue la descripción. En
 * 		estos últimos casos si no se especifica el tipo de recogida, se entenderá que es mecánica, al igual que
 * 		si no se especifica el tipo se uva, se entenderá que es blanca.
 * 
 * 		- Métodos get y set.
 * 
 * 		- Método toString con formato similar al del siguiente ejemplo:
 * 		COSECHA:
 * 			Descripción: Cortijo Los Juanes, verano 2015
 * 			Tipo de recogida: Mecánica
 * 			Tipo de uva: Negra
 * 
 * 		- Método toStringLineal con un formato similar a los dos siguientes ejemplos:
 * 		Finca La Soledad, otoño 2016, recogida de forma Mecánica. Uva Blanca
 * 		Cortijo Los Juanes, verano 2015, recogida de forma Mecánica. Uva Negra
 */

public class Cosecha {

	/**
	 * Variables de instancia
	 */
	private String descripcion;
	private boolean tipoRecogida;
	private boolean tipoUva;
	/**
	 * Constructor
	 */
	public Cosecha(String descripcion, boolean tipoRecogida, boolean tipoUva) {
		this.descripcion = descripcion;
		this.tipoRecogida = tipoRecogida;
		this.tipoUva = tipoUva;
	}

	public Cosecha(String descripcion, boolean tipoUva) {
		this.descripcion = descripcion;
		this.tipoUva = tipoUva;
	}

	public Cosecha(String descripcion) {
		this.descripcion = descripcion;
		this.tipoRecogida = false;
		this.tipoUva = true;
	}
	/**
	 * Getter's y setter's
	 */
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isTipoRecogida() {
		return tipoRecogida;
	}

	public void setTipoRecogida(boolean tipoRecogida) {
		this.tipoRecogida = tipoRecogida;
	}

	public boolean isTipoUva() {
		return tipoUva;
	}

	public void setTipoUva(boolean tipoUva) {
		this.tipoUva = tipoUva;
	}
	/**
	 * toString redefinido
	 * 
	 * 		COSECHA:
	 * 			Descripción: Cortijo Los Juanes, verano 2015
	 * 			Tipo de recogida: Mecánica
	 * 			Tipo de uva: Negra
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName().toUpperCase() + ": " +
				"\n\tDescripción: " + this.descripcion +
				"\n\tTipo de recogida: " + (this.tipoRecogida?"Manual":"Mecánica") +
				"\n\tTipo de uva: " + (this.tipoUva?"Blanca":"Negra");
	}

	/**
	 * toStringLineal
	 * 
	 * 		Finca La Soledad, otoño 2016, recogida de forma Mecánica. Uva Blanca
	 * 		Cortijo Los Juanes, verano 2015, recogida de forma Mecánica. Uva Negra
	 */
	public String toStringLineal() {
		return this.descripcion + " - " + (this.tipoRecogida?"Manual":"Mecánica") + " - " + (this.tipoUva?"Blanca":"Negra");
	}
}
