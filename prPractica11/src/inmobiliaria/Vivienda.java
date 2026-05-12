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
	private int numBanios;
	private int numDormitorios;

	/**
	 * Constructor
	 */
	public Vivienda(int codigo, TipoPropiedad tipoPropiedad, double superficie, String descripcion, String direccion,
			double precio, TipoVivienda tipoVivienda, int numBanios, int numDormitorios) {
		super(codigo, tipoPropiedad, superficie, descripcion, direccion, precio);
		this.tipoVivienda = tipoVivienda;
		this.numBanios = numBanios;
		this.numDormitorios = numDormitorios;
	}

	/**
	 * Getter's y setter's
	 */
	public TipoVivienda getTipoVivienda() {return tipoVivienda;}
	public void setTipoVivienda(TipoVivienda tipoVivienda) {this.tipoVivienda = tipoVivienda;}

	public int getNumBanios() {return numBanios;}
	public void setNumBanios(int numBanios) {this.numBanios = numBanios;}

	public int getNumDormitorios() {return numDormitorios;}
	public void setNumDormitorios(int numDormitorios) {this.numDormitorios = numDormitorios;}

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
		return super.toString() +
				"\n\tTipo de vivienda: " + this.tipoVivienda +
				"\n\tNúmero de baños: " + this.numBanios +
				"\n\tNúmero de dormitorios: " + this.numDormitorios;
	}
}
