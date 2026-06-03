package modelo;

import java.util.Objects;

/**
 * B) Una clase abstracta Alojamiento, sobre un alojamiento queremos conocer su nombre, su ubicación y el
 * precio base por noche de alojamiento. Esta clase debe proporcionar, al menos, los siguientes métodos:
 * 
 * • Constructor, en el que controlaremos que el precio base por noche no sea negativo.
 * 
 * • Métodos get, set y toString.
 * 
 * • Método para poder comparar alojamientos, se considerarán iguales si coincide su nombre.
 * 
 * • Método abstracto que calcule el precio del alojamiento para el número de noches recibido como
 * parámetro (en el apartado D, se explica cómo realizar el cálculo).
 */
public abstract class Alojamiento {

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private EnumUbicaciones ubicacion;
	private float precioBase;

	/**
	 * Constructor
	 */
	public Alojamiento(String nombre, EnumUbicaciones ubicacion, float precioBase) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		if (precioBase < 0) {
			this.precioBase = 0;
		}
		else {
			this.precioBase = precioBase;

		}
	}

	/**
	 * Getter y Setter
	 */
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public EnumUbicaciones getUbicacion() {return ubicacion;}
	public void setUbicacion(EnumUbicaciones ubicacion) {this.ubicacion = ubicacion;}

	public float getPrecioBase() {return precioBase;}
	public void setPrecioBase(float precioBase) {this.precioBase = precioBase;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return nombre + " - " + ubicacion + " - " + precioBase + "€/noche";
	}

	/**
	 * equals y hashCode (son iguales si coincide el nombre)
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alojamiento other = (Alojamiento) obj;
		return Objects.equals(nombre, other.nombre);
	}

	/**
	 * Método abstracto que calcule el precio del alojamiento para el número de noches recibido como
	 * parámetro (en el apartado D, se explica cómo realizar el cálculo).
	 */
	public abstract float calculaPrecioAlojamiento(int numNoches);

}
