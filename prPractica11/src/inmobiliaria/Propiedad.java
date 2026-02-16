package inmobiliaria;

import java.util.Objects;

/**
 * A) Diseñar una clase llamada Propiedad, en la que al menos aparezcan los siguientes métodos:
 * 		✓ Constructor, métodos get y set.
 * 
 * 		✓ Método que calcule el beneficio.
 * 
 * 		✓ Método para poder comparar si dos propiedades son iguales. Se considerará que dos propiedades
 * 		son iguales si coincide si código.
 * 
 * 		✓ Redefinición del método toString, que devuelva la información sobre una propiedad.
 */
public class Propiedad {

	/**
	 * Variables de clase
	 */
	final float GASTOS_GESTION = 150;
	final float PORCENTAJE = 0.75f;

	/**
	 * Variables de instancia
	 * 
	 * Se almacena el código de propiedad, tipo de propiedad, su dirección, el número de metros cuadrados, una descripción con
	 * información sobre la propiedad, y el precio
	 */
	private int codigo;
	private TipoPropiedad tipoPropiedad;
	private double superficie;
	private String descripcion;
	private String direccion;
	private double precio;

	/**
	 * Constructor
	 */
	public Propiedad(int codigo, TipoPropiedad tipoPropiedad, double superficie, String descripcion, String direccion, double precio) {
		this.codigo = codigo;
		this.tipoPropiedad = tipoPropiedad;
		this.superficie = superficie;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.precio = precio;
	}

	/**
	 * Getter's y setter's
	 */
	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}

	public TipoPropiedad getTipoPropiedad() {return tipoPropiedad;}
	public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {this.tipoPropiedad = tipoPropiedad;}

	public double getSuperficie() {return superficie;}
	public void setSuperficie(double superficie) {this.superficie = superficie;}

	public String getDescripcion() {return descripcion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

	public String getDireccion() {return direccion;}
	public void setDireccion(String direccion) {this.direccion = direccion;}

	public double getPrecio() {return precio;}
	public void setPrecio(double precio) {this.precio = precio;}

	/**
	 * Sobre la venta de cada propiedad la inmobiliaria obtiene un beneficio que en la mayoría de los
	 * casos es del 0.75% sobre el valor de la propiedad más 150 € de gastos de gestoría. Pero en el caso de las
	 * viviendas al beneficio anterior hay que añadirle otro 0.25 % sobre el valor de la vivienda, de igual forma el
	 * beneficio de las fincas rústicas también se incrementa con respecto al beneficio inicial en un 0.5 %.
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
	public double calculaBeneficio() {
		return (this.precio*this.PORCENTAJE/100) + this.GASTOS_GESTION;
	}

	/**
	 * equals y hashCode redefinido
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo, descripcion, direccion, precio, superficie, tipoPropiedad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return codigo == other.codigo && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(direccion, other.direccion)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Double.doubleToLongBits(superficie) == Double.doubleToLongBits(other.superficie)
				&& tipoPropiedad == other.tipoPropiedad;
	}

	/**
	 * toString redefinido
	 * 
	 * 			LOCAL COMERCIAL
	 * 				Beneficio obtenido: 600.0€
	 * 				Código: 23
	 * 				Superficie: 70.0 metros cuadrados
	 * 				Descripción: El local no tiene baño e instalaciones de agua, luz y teléfono
	 * 				Dirección: C/Infante, 45
	 * 				Precio: 60000.0 €
	 */
	@Override
	public String toString() {
		return this.tipoPropiedad.getDescripcion().toUpperCase() +
				"\n\tBeneficio obtenido: " + this.calculaBeneficio() + " €" +
				"\n\tCódigo: " + this.codigo +
				"\n\tSuperficie: " + this.superficie + " metros cuadrados" +
				"\n\tDescripción: " + this.descripcion +
				"\n\tDirección: " + this.direccion +
				"\n\tPrecio: " + this.precio + " €";
	}
}
