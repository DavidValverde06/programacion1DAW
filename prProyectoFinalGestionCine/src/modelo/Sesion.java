package modelo;

import java.time.*;

public class Sesion {

	/**
	 * Variables de instancia
	 */
	private LocalDate fecha;
	private int hora;
	private double precio;

	/**
	 * Constructor
	 */
	public Sesion(LocalDate fecha, int hora, double precio) {
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}

	/**
	 * Métodos Getter's y Setter's
	 */
	// Getter's
	public LocalDate getFecha() {
		return fecha;
	}

	public int getHora() {
		return hora;
	}
	public double getPrecio() {
		return precio;
	}

	// Setter's
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Hora de la sesión: " + hora + ":00\nPrecio: " + precio + "€\n" + fecha;
	}
}
