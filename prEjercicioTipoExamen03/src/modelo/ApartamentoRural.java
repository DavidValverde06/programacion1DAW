package modelo;

/**
 * C) Los alojamientos podrán ser Casas Rurales o Apartamentos Rurales, en el caso de las Casas Rurales,
 * también queremos saber el número de habitaciones de las que dispone, y en el caso de los Apartamentos
 * Rurales, si estos disponen de cocina y de parking. 
 */
public class ApartamentoRural extends Alojamiento {

	/**
	 * Variables de instancia
	 */
	private boolean tieneCocina;
	private boolean tieneParking;

	/**
	 * Constructor
	 */
	public ApartamentoRural(String nombre, EnumUbicaciones ubicacion, float precioBase, boolean tieneCocina,
			boolean tieneParking) {
		super(nombre, ubicacion, precioBase);
		this.tieneCocina = tieneCocina;
		this.tieneParking = tieneParking;
	}

	/**
	 * Getter y Setter
	 */
	public boolean isTieneCocina() {return tieneCocina;}
	public void setTieneCocina(boolean tieneCocina) {this.tieneCocina = tieneCocina;}

	public boolean isTieneParking() {return tieneParking;}
	public void setTieneParking(boolean tieneParking) {this.tieneParking = tieneParking;}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nTiene cocina: " + ((tieneCocina==true)?"Si":"No") +
				"\nTiene parking: " + ((tieneParking==true)?"Si":"No");
	}

	/**
	 * D) La forma de realizar el cálculo del precio por noche de alojamiento será el obtenido de multiplicar el
	 * precio base por noche de alojamiento por el número de noches, teniendo en cuenta que:
	 * 
	 * • Si se trata de una casa, a ese importe habrá que aplicar un descuento del 5%, si el número de noches
	 * es superior a 5, y del 10%, si el número de noches es superior a 10.
	 * 
	 * • Si se trata de un apartamento, ese importe se verá incrementado en 10€ si tiene dispone de parking y
	 * en otros 10€ si dispone de cocina.
	 * 
	 * • Por ejemplo:
	 * 		o Una casa, con precio base de 100€ por noche, para una estancia de 4 noches, pagaría un total
	 * 		de 400€, pero si esa estancia es de 12 noches pagaría 1080€, ya que tendría un descuento del
	 * 		10%, y si la estancia fuese de 8 noches pagaría 760€ al tener un descuento del 5%.
	 * 
	 * 		o Un apartamento, con precio base 80€ y que disponga de cocina y parking, se verá incrementado
	 * 		en 20€ (10 de cocina y 10 de parking), por lo que resultará un precio base por noche de 100€.
	 */
	@Override
	public float calculaPrecioAlojamiento(int numNoches) {
		float precioAlojamiento = getPrecioBase() * numNoches;

		if (tieneCocina == true) {
			precioAlojamiento+=10;
		}
		if (tieneParking == true) {
			precioAlojamiento+=10;
		}

		return precioAlojamiento;
	}

}
