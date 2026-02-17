package inmobiliaria;

/**
 * En el caso de las fincas rústicas también interesa conocer el
 * tipo de terreno (por ejemplo regadío, secano, olivos, etc.), y si dispone de luz, agua y vivienda
 */
public class FincaRustica extends Propiedad {

	/**
	 * Variables de clase
	 */
	final float PORCENTAJE = 0.5f; 

	/**
	 * Variables de instancia
	 */
	private TipoTerreno tipoTerreno;
	private boolean disponeLuz;
	private boolean disponeAgua;
	private boolean disponeVivienda;

	/**
	 * Constructor
	 */
	public FincaRustica(int codigo, TipoPropiedad tipoPropiedad, double superficie, String descripcion,
			String direccion, double precio, TipoTerreno tipoTerreno, boolean disponeLuz, boolean disponeAgua,
			boolean disponeVivienda) {
		super(codigo, tipoPropiedad, superficie, descripcion, direccion, precio);
		this.tipoTerreno = tipoTerreno;
		this.disponeLuz = disponeLuz;
		this.disponeAgua = disponeAgua;
		this.disponeVivienda = disponeVivienda;
	}

	/**
	 * Getter's y setter's
	 */
	public TipoTerreno getTipoTerreno() {return tipoTerreno;}
	public void setTipoTerreno(TipoTerreno tipoTerreno) {this.tipoTerreno = tipoTerreno;}

	public boolean isDisponeLuz() {return disponeLuz;}
	public void setDisponeLuz(boolean disponeLuz) {this.disponeLuz = disponeLuz;}

	public boolean isDisponeAgua() {return disponeAgua;}
	public void setDisponeAgua(boolean disponeAgua) {this.disponeAgua = disponeAgua;}

	public boolean isDisponeVivienda() {return disponeVivienda;}
	public void setDisponeVivienda(boolean disponeVivienda) {this.disponeVivienda = disponeVivienda;}

	/**
	 * El beneficio de las fincas rústicas también se incrementa con respecto al beneficio inicial en un 0.5 %.
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
				"\n\tTipo de terreno: " + this.tipoTerreno +
				"\n\t¿Dispone de luz? " + (this.disponeLuz?"Si":"No") +
				"\n\t¿Dispone de agua? " + (this.disponeAgua?"Si":"No") +
				"\n\t¿Dispone de vivienda? " + (this.disponeVivienda?"Si":"No");
	}
}
