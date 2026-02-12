package inmobiliaria;

/**
 * En el caso de las viviendas también se guarda información sobre el tipo de 
 * vivienda (casa, piso, adosado, chalet o dúplex), así como el número de baños
 * y de dormitorios.
 */
public class Vivienda extends Propiedad {

	/**
	 * Variables de clase
	 */
	final float PORCENTAJE = 0.25f;
	
	/**
	 * Variables de instancia
	 */
	private TipoVivienda tipoVivienda;

	/**
	 * Constructor
	 */
	public Vivienda(int codigo, TipoPropiedad tipoPropiedad, double superficie, String descripcion, String direccion,
			double precio, TipoVivienda tipoVivienda) {
		super(codigo, tipoPropiedad, superficie, descripcion, direccion, precio);
		this.tipoVivienda = tipoVivienda;
	}

	/**
	 * Getter's y setter's
	 */
	public TipoVivienda getTipoVivienda() {return tipoVivienda;}
	public void setTipoVivienda(TipoVivienda tipoVivienda) {this.tipoVivienda = tipoVivienda;}


	/**
	 * En el caso de las viviendas al beneficio anterior hay que añadirle otro 0.25 % sobre el valor de la vivienda.
	 * Por ejemplo:
	 * 		Local Comercial, precio 60.000 €
	 * 			Beneficio Inmobiliaria: (0.75% de 60000) + 150 = 600 € de beneficio
	 * 
	 * 		Casa, precio 240.000 €
	 * 			Beneficio Inmobiliaria: (0.75% de 240.000) + 150 + (0.25% de 240.000) = 2.550 € de beneficio
	 */

	/**
	 * Método que calcula el beneficio
	 */
	@Override
	public double calculaBeneficio() {
		return super.calculaBeneficio() + (getPrecio()*this.PORCENTAJE/100);
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}
