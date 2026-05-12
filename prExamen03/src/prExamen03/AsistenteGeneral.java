package prExamen03;

public class AsistenteGeneral extends Asistente {

	/**
	 * Variables de instancia 
	 */
	private boolean inscripcionAnticipada;

	/**
	 * Constructor
	 */
	public AsistenteGeneral(String dni, String nombre, String fechaNacimiento, String fechaInscripcion,
			boolean inscripcionAnticipada) {
		super(dni, nombre, fechaNacimiento, fechaInscripcion);
		this.inscripcionAnticipada = inscripcionAnticipada;
	}

	/**
	 * Getter's y setter's
	 */
	public boolean isInscripcionAnticipada() {return inscripcionAnticipada;}
	public void setInscripcionAnticipada(boolean inscripcionAnticipada) {this.inscripcionAnticipada = inscripcionAnticipada;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tVenta anticipada: " + ((this.inscripcionAnticipada==true)?"SI":"NO");
	}

	/**
	 * Método para calcular el precio de la inscripción
	 * 
	 * Coste base = 50€
	 * Si es menor de edad, descuento del 10%
	 * Si se ha inscrito de forma anticipada descuento del 20%
	 */
	@Override
	public double calcularPrecioInscripcion() {
		double precio = this.COSTE_BASE;

		if (LibFechas8.getEdad(getFechaNacimiento())<18) {
			precio = precio - (precio * this.DESCUENTO_MENOR_EDAD);
		}
		if (this.inscripcionAnticipada) {
			precio = precio - (precio * this.DESCUENTO_INSCRIPCION_ANTICIPADA);
		}

		return precio;
	}

}
