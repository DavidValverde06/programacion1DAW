package modelo;

public enum EnumEstiloBonsai {

	CHOKKAN("Vertical Formal (totalmente recto)", 10.0),
	MOYOGI("Vertical Informal (en forma de S)", 25.0),
	SHAKAN("Inclinado (como si el viento lo empujase)", 45.0),
	KENGAI("Cascada (el tronco cae hacia abajo)", 100.0);

	/**
	 * Variables de instancia
	 */
	private String descripcionEstilo;
	private double recargoSobrePrecioFinal;

	/**
	 * Constructor
	 */
	private EnumEstiloBonsai(String descripcionEstilo, double recargoSobrePrecioFinal) {
		this.descripcionEstilo = descripcionEstilo;
		this.recargoSobrePrecioFinal = recargoSobrePrecioFinal;
	}

	/**
	 * Getter y Setter
	 */
	public String getDescripcionEstilo() {return descripcionEstilo;}
	public void setDescripcionEstilo(String descripcionEstilo) {this.descripcionEstilo = descripcionEstilo;}

	public double getRecargoSobrePrecioFinal() {return recargoSobrePrecioFinal;}
	public void setRecargoSobrePrecioFinal(double recargoSobrePrecioFinal) {this.recargoSobrePrecioFinal = recargoSobrePrecioFinal;}

}