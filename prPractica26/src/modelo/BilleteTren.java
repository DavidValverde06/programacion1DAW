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
	 * Variables de instancia
	 */
	private Punto coordenadaOrigen;
	private Punto coordenadaDestino;
	private EnumDescuentos tipoDescuento;
	private double distancia;
	private double precio;

	/**
	 * Constructor
	 */
	public BilleteTren(Punto coordenadaOrigen, Punto coordenadaDestino, EnumDescuentos tipoDescuento, double distancia,
			double precio) {

		this.coordenadaOrigen = coordenadaOrigen;
		this.coordenadaDestino = coordenadaDestino;
		this.tipoDescuento = tipoDescuento;
		this.distancia = distancia;
		this.precio = precio;
	}

	/**
	 * Getter's
	 */
	public Punto getCoordenadaOrigen() {
		return coordenadaOrigen;
	}

	public Punto getCoordenadaDestino() {
		return coordenadaDestino;
	}

	public EnumDescuentos getTipoDescuento() {
		return tipoDescuento;
	}

	public double getDistancia() {
		return distancia;
	}

	public double getPrecio() {
		return precio;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "BilleteTren [coordenadaOrigen=" + coordenadaOrigen + ", coordenadaDestino=" + coordenadaDestino
				+ ", tipoDescuento=" + tipoDescuento + ", distancia=" + distancia + ", precio=" + precio + "]";
	}
}
