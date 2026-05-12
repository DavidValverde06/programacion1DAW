package inmobiliaria;

public enum TipoPropiedad {

	LOCAL("Local comercial"),
	APARCAMIENTO("Plaza de aparcamiento"),
	VIVIENDA("Vivienda"),
	FINCA("Finca rústica"),
	SOLAR("Solar");

	/**
	 * Variable de instancia
	 */
	private String descripcion;

	/**
	 * Constructor
	 */
	private TipoPropiedad(String descripcion) {
		this.descripcion = descripcion;
	}

	// Getter
	public String getDescripcion() {
		return descripcion;
	}
}
