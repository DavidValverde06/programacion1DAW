package modelo;

/**
 * A todo lo anterior hay que sumar, que cuando la persona que viaja es familiar directo de un trabajador
 * de la compañía de tren, se le aplica un descuento adicional del 25%, en estos casos también interesa
 * conocer el nombre de la persona que realiza el viaje.
 */
public class BilleteTrenFamiliar extends BilleteTren {

	/**
	 * Variable de clase
	 */
	private static int PORCENTAJE_DESCUENTO = 25;

	/**
	 * Variables de instancia
	 */
	private String nombreViajero;

	/**
	 * Constructor
	 */
	public BilleteTrenFamiliar(Punto coordenadaOrigen, Punto coordenadaDestino, EnumDescuentos tipoDescuento, String nombreViajero) {
		super(coordenadaOrigen, coordenadaDestino, tipoDescuento);
		this.nombreViajero = nombreViajero;
	}

	/**
	 * Getter's
	 */
	public String getNombreViajero() {return nombreViajero;}

	/**
	 * toString 
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tDescuento extra por familia: " + PORCENTAJE_DESCUENTO + "%" +
				"\n\tFamiliar: " + nombreViajero;
	}

	@Override
	public float calculaPrecio() {
		return super.calculaPrecio() - (super.calculaPrecio() * (PORCENTAJE_DESCUENTO / 100));
	}

}
