package modelo;

public enum EnumClasificacion {

	CLASIFICACION_A("Todas las edades"),
	CLASIFICACION_7("+7 años"),
	CLASIFICACION_12("+12 años"),
	CLASIFICACION_16("+16 años"),
	CLASIFICACION_18("+18 años");

	/**
	 * Variables de instancia
	 */
	private String descripcion;

	/**
	 * Constructor
	 */
	private EnumClasificacion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Método Getter
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return this.descripcion;
	}
}
