package prExamen03;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Asistente {

	/**
	 * Variables de clase
	 */
	final double COSTE_BASE = 50;
	final double DESCUENTO_MENOR_EDAD = 0.10;
	final double DESCUENTO_INSCRIPCION_ANTICIPADA = 0.20;
	final int SUPLEMENTO = 30;

	/**
	 * Variables de instancia
	 */
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private LocalDate fechaInscripcion;

	/**
	 * Constructor
	 */
	public Asistente(String dni, String nombre, String fechaNacimiento, String fechaInscripcion) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = LibFechas8.convierteStringToLocalDate(fechaNacimiento);
		this.fechaInscripcion = LibFechas8.convierteStringToLocalDate(fechaInscripcion);
	}

	/**
	 * Getter's y setter's
	 */
	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public LocalDate getFechaNacimiento() {return fechaNacimiento;}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

	public LocalDate getFechaInscripcion() {return fechaInscripcion;}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {this.fechaInscripcion = fechaInscripcion;}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() +
				"\n\tCoste de la inscripción: " + this.calcularPrecioInscripcion() + "€" +
				"\n\tNombre: " + this.nombre + " (" + this.dni +")" +
				"\n\tFecha inscripción: " + LibFechas8.getFechaFull(this.fechaInscripcion) +
				"\n\tEdad: " + LibFechas8.getEdad(this.fechaNacimiento);
	}

	/**
	 * equals y hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asistente other = (Asistente) obj;
		return Objects.equals(dni, other.dni);
	}

	/**
	 * Método abstracto para calcular el precio de la inscripción
	 */
	public abstract double calcularPrecioInscripcion();
}
