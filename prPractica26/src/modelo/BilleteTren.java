package modelo;

/**
 * b) Por otro lado vamos a desarrollar la clase BilleteTren, sobre un billete de tren interesa conocer
 * coordenadas de origen, coordenadas de destino, tipo de descuento (niño menor de 7 años, jubilado, …),
 * distancia entre origen y destino, así como el precio a pagar por el billete. La distancia y el precio serán
 * datos que se obtendrán a partir de los anteriores. Los métodos que debe proporcionar esta clase como
 * mínimo serán:
 * 
 * - Constructor.
 * 
 * - Métodos get() y toString.
 * 
 * - Método de clase getPorcentaje(String t), devuelve el porcentaje a aplicar según el tipo de
 * descuento.
 * 
 * - Método float calculaPrecio(). Este método calcula el precio a pagar por un billete de tren teniendo
 * en cuenta la distancia a recorrer y el tipo de descuento a aplicar. Para el cálculo del precio hay que
 * saber que el coste del kilómetro depende del número de kilómetros (consultar tabla) y que los
 * descuentos a aplicar se muestran en la siguiente tabla:
 * 
 * - Método String getPrecio(), este método devolverá una cadena con el precio a pagar por el billete,
 * desglosado en euros y céntimos. 
 */
public class BilleteTren {

	/**
	 * Variables de clase
	 */
	final static float CENTS_KM_1_20 = 0.20f; 	// 20 céntimos por km
	final static float CENTS_KM_21_50 = 0.18f; 	// 18 céntimos por km
	final static float CENTS_KM_50 = 0.16f; 	// 16 céntimos por km

	/**
	 * Variables de instancia
	 */
	private Punto coordenadaOrigen;
	private Punto coordenadaDestino;
	private EnumDescuentos tipoDescuento;
	private float distancia;
	private float precio;
	/**
	 * Constructor
	 */
	public BilleteTren(Punto coordenadaOrigen, Punto coordenadaDestino, EnumDescuentos tipoDescuento) {
		this.coordenadaOrigen = coordenadaOrigen;
		this.coordenadaDestino = coordenadaDestino;
		this.tipoDescuento = tipoDescuento;
		this.distancia = coordenadaOrigen.distancia(coordenadaDestino);
		this.precio = calculaPrecio();
	}

	/**
	 * Getter's
	 */
	public Punto getCoordenadaOrigen() {return coordenadaOrigen;}
	public Punto getCoordenadaDestino() {return coordenadaDestino;}
	public EnumDescuentos getTipoDescuento() {return tipoDescuento;}
	public float getDistancia() {return distancia;}
	public float getPrecio() {return precio;}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() +
				"\n\tOrigen: " + coordenadaOrigen +
				"\n\tDestino: " + coordenadaDestino +
				"\n\tDescuento aplicado: " + tipoDescuento.getDescuento() + "% (" + tipoDescuento.getDescripcion() + ")" +
				"\n\tDistancia: " + distancia +
				"\n\tCoste del billete: " + getPrecioString();
	}

	/**
	 * Método float calculaPrecio(). Este método calcula el precio a pagar por un billete de tren teniendo
	 * en cuenta la distancia a recorrer y el tipo de descuento a aplicar. Para el cálculo del precio hay que
	 * saber que el coste del kilómetro depende del número de kilómetros (consultar tabla) y que los
	 * descuentos a aplicar se muestran en la siguiente tabla:
	 */
	public float calculaPrecio() {

		float descuento = tipoDescuento.getDescuento();
		float precioBase;

		if (distancia>50) {
			precioBase = distancia * CENTS_KM_50; // 16 céntimos por km
		}
		else if (distancia>20) {
			precioBase = distancia * CENTS_KM_21_50; // 18 céntimos por km
		}
		else {
			precioBase = distancia * CENTS_KM_1_20; // 20 céntimos por km
		}

		return precioBase - precioBase * (descuento / 100);
	}

	/**
	 * Método String getPrecioString(), este método devolverá una cadena con el precio a pagar por el billete,
	 * desglosado en euros y céntimos. 
	 */
	public String getPrecioString() {

		float dinero = getPrecio();
		int euros = (int)dinero;
		int centimos = (int)Math.round((dinero - euros) * 100);

		return euros + " € y " + centimos + " céntimos";
	}
}
