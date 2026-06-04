package modelo;

import java.text.DecimalFormat;
import java.util.Objects;

public abstract class Planta {

	/**
	 * Variables de instancia
	 */
	private String idPlanta;
	private String nombreComunPlanta;
	private double precioBasePlanta;
	private int stockDisponible;

	/**
	 * Constructor
	 */
	public Planta(String idPlanta, String nombreComunPlanta, double precioBasePlanta, int stockDisponible) {
		this.idPlanta = idPlanta;
		this.nombreComunPlanta = nombreComunPlanta;
		this.precioBasePlanta = precioBasePlanta;
		this.stockDisponible = stockDisponible;
	}

	/**
	 * Getter y Setter
	 */
	public String getIdPlanta() {return idPlanta;}
	public void setIdPlanta(String idPlanta) {this.idPlanta = idPlanta;}

	public String getNombreComunPlanta() {return nombreComunPlanta;}
	public void setNombreComunPlanta(String nombreComunPlanta) {this.nombreComunPlanta = nombreComunPlanta;}

	public double getPrecioBasePlanta() {return precioBasePlanta;}
	public void setPrecioBasePlanta(double precioBasePlanta) {this.precioBasePlanta = precioBasePlanta;}

	public int getStockDisponible() {return stockDisponible;}
	public void setStockDisponible(int stockDisponible) {this.stockDisponible = stockDisponible;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return toStringLineal() + "\n\t" + obtenerFichaCuidados();
	}

	/**
	 * toString lineal
	 */
	public String toStringLineal() {
		DecimalFormat patron = new DecimalFormat("0.00");

		return idPlanta + " - " + nombreComunPlanta + " - (Stock: " + stockDisponible +
				") - P. Base: " + precioBasePlanta + "€ - Precio de venta: " + patron.format(this.calcularPrecioVenta()) + "€";
	}

	/**
	 * equals y hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idPlanta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		return Objects.equals(idPlanta, other.idPlanta);
	}

	/**
	 * Método abstracto 1
	 */
	public abstract double calcularPrecioVenta();

	/**
	 * Método abstracto 2
	 */
	public abstract String obtenerFichaCuidados();
}
