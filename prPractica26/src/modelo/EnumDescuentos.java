package modelo;

public enum EnumDescuentos {

	SIN_DESCUENTO("Sin descuento",0),

	MENOR_7("Menor de 7 años", 100),

	MENOR_12("Menor de 12 años",50),

	MENOR_18("Menor de 18 años",25),

	UNIVERSITARIO("Universitario",40),

	MAYOR_65("Mayor de 65", 25),

	DESEMPLEADO("Desempleado",10);

	/**
	 * Variables de instancia
	 */
	private String descripcion;
	private int descuento;

	/**
	 * Constructor
	 */
	private EnumDescuentos(String descripcion,int descuento) {
		this.descripcion = descripcion;
		this.descuento = descuento;
	}

	/**
	 * Getter's
	 */
	public String getDescripcion() {
		return this.descripcion;
	}	

	public int getDescuento() {
		return this.descuento;
	}


}