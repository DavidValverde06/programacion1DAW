package prExamen03;

public class AsistenteVIP extends Asistente {

	/**
	 * Variables de instancia
	 */
	private String packRegalo;

	/**
	 * Constructor
	 */
	public AsistenteVIP(String dni, String nombre, String fechaNacimiento, String fechaInscripcion, String packRegalo) {
		super(dni, nombre, fechaNacimiento, fechaInscripcion);
		this.packRegalo = packRegalo;
	}

	/**
	 * Getter's y setter's
	 */
	public String getPackRegalo() {return packRegalo;}
	public void setPackRegalo(String packRegalo) {this.packRegalo = packRegalo;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tPack de regalo: " + this.packRegalo;
	}

	/**
	 * Método para calcular el precio de la inscripción
	 * 
	 * Coste base = 50€
	 * Añade suplemento = 30€
	 */
	@Override
	public double calcularPrecioInscripcion() {
		return this.COSTE_BASE + this.SUPLEMENTO;
	}
}
