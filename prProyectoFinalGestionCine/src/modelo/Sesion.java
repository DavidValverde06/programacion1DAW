package modelo;

import java.time.*;
import java.util.Objects;

import fechas.*;

public class Sesion {

	/**
	 * Variables de instancia
	 */
	private int id_sesion; // PK
	private int id_pelicula; // FK
	private int id_sala; // FK
	private LocalDate fecha;
	private int hora;
	private double precio;

	/**
	 * Constructor
	 * 
	 * @throws MiExcepcion 
	 */
	public Sesion(int codigo, int id_pelicula, int id_sala, String fecha, int hora, double precio) throws MiExcepcion {

		if (!LibFechas8.isFechaCorrecta(fecha))  // Validar que la fecha sea correcta
			throw new MiExcepcion("Fecha no válida");

		this.id_sesion = codigo;
		this.id_pelicula = id_pelicula;
		this.id_sala = id_sala;
		this.fecha = LibFechas8.convierteStringToLocalDate(fecha);
		this.hora = hora;
		this.precio = precio;
	}

	/**
	 * Métodos Getter's y Setter's
	 */
	// Getter's
	public int getCodigo() {return id_sesion;}
	public int getId_pelicula() {return id_pelicula;}
	public int getId_sala() {return id_sala;}
	public LocalDate getFecha() {return fecha;}
	public int getHora() {return hora;}
	public double getPrecio() {return precio;}

	// Setter's
	public void setCodigo(int codigo) {this.id_sesion = codigo;}
	public void setId_pelicula(int id_pelicula) {this.id_pelicula = id_pelicula;}
	public void setId_sala(int id_sala) {this.id_sala = id_sala;}
	public void setFecha(LocalDate fecha) {this.fecha = fecha;}
	public void setHora(int hora) {this.hora = hora;}
	public void setPrecio(double precio) {this.precio = precio;}

	/**
	 * equals y hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora, id_pelicula, id_sala, id_sesion, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesion other = (Sesion) obj;
		return Objects.equals(fecha, other.fecha) && hora == other.hora && id_pelicula == other.id_pelicula
				&& id_sala == other.id_sala && id_sesion == other.id_sesion
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return "Sesion [id_sesion=" + id_sesion + ", id_pelicula=" + id_pelicula + ", id_sala=" + id_sala + ", fecha="
				+ fecha + ", hora=" + hora + ", precio=" + precio + "]";
	}
	
}
