package modelo;

public enum EnumDescuentos {

	SIN_DESCUENTO("Sin descuento",0.0f),

	MENOR_7("Menor de 7 años",1.0f),

	MENOR_12("Menor de 12 años",0.50f),

	MENOR_18("Menor de 18 años",0.25f),

	UNIVERSITARIO("Universitario",0.40f),

	MAYOR_65("Mayor de 65",0.25f),

	DESEMPLEADO("Desempleado",0.10f);

	/**
	 * Variables de instancia
	 */
	private String descripcion;
	private float descuento;

	/**
	 * Constructor
	 */
	private EnumDescuentos(String descripcion, float descuento) {
		this.descripcion = descripcion;
		this.descuento = descuento;
	}

	/**
	 * Getter's
	 */
	public String getDescripcion() {return this.descripcion;}
	public float getDescuento() {return this.descuento;}

}