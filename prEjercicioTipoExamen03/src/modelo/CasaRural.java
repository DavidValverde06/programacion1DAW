package modelo;

/**
 * C) Los alojamientos podrán ser Casas Rurales o Apartamentos Rurales, en el caso de las Casas Rurales,
 * también queremos saber el número de habitaciones de las que dispone, y en el caso de los Apartamentos
 * Rurales, si estos disponen de cocina y de parking. 
 */
public class CasaRural extends Alojamiento {

	/**
	 * Variables de instancia
	 */
	private int numHabitaciones;

	/**
	 * Constructor
	 */
	public CasaRural(String nombre, EnumUbicaciones ubicacion, float precioBase, int numHabitaciones) {
		super(nombre, ubicacion, precioBase);
		this.numHabitaciones = numHabitaciones;
	}

	/**
	 * Getter y Setter
	 */
	public int getNumHabitaciones() {return numHabitaciones;}

	public void setNumHabitaciones(int numHabitaciones) {this.numHabitaciones = numHabitaciones;}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nNúmero de habitaciones: " + numHabitaciones;
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
		float descuento = 0;

		if (numNoches > 10) {
			descuento = precioAlojamiento * (10/100f);
		}
		else if (numNoches > 5) {
			descuento = precioAlojamiento * (5/100f);
		}

		return precioAlojamiento-= descuento;
	}

}
