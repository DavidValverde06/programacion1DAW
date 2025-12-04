package vinos;

import java.util.Objects;

/**
 * A) Clase Enólogo, sobre un enólogo nos interesa conocer su nombre, la minuta por hora de trabajo y si está
 * colegiado o no. Debéis proporcionar, al menos los siguientes métodos:
 * 		- Constructor sobrecargado, uno al que le llegue toda la información referente a un enólogo, y otro al
 * 		que solo le llegue su nombre y minuta, en este último caso se sobreentenderá que no está colegiado.
 * 
 * 		- Métodos get y set.
 * 
 * 		- Método toString, que devuelva la información de un enólogo con un formato similar a los siguientes
 * 		ejemplos, en los que se separa la información por guiones:
 * 			Juan García - 29.0 - Colegiado
 * 			María González - 45.0 - No colegiado
 * 
 * 		- Método equals, consideraremos que dos enólogos son iguales si coincide su nombre y su minuta
 */

public class Enologo {
	
	/**
	 * Variables de instancia
	 */
	private String nombre;
	private double minutaPorHora;
	private boolean colegiado;
	
	/**
	 * Constructores
	 */
	public Enologo(String nombre, double minutaPorHora, boolean colegiado) {
		this.nombre = nombre;
		this.minutaPorHora = minutaPorHora;
		this.colegiado = colegiado;
	}
	
	public Enologo(String nombre, double minutaPorHora) {
		this.nombre = nombre;
		this.minutaPorHora = minutaPorHora;
		this.colegiado = false;
	}
	
	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getMinutaPorHora() {
		return minutaPorHora;
	}

	public void setMinutaPorHora(double minutaPorHora) {
		this.minutaPorHora = minutaPorHora;
	}

	public boolean isColegiado() {
		return colegiado;
	}

	public void setColegiado(boolean colegiado) {
		this.colegiado = colegiado;
	}
	
	/**
	 * toString redefinido
	 * 
	 * 		Juan García - 29.0 - Colegiado
	 * 		María González - 45.0 - No colegiado
	 */
	@Override
	public String toString() {
		return this.nombre + " - " + this.minutaPorHora + " - " + (this.colegiado?"Colegiado":"No colegiado");
	}
	
	/**
	 * equals redefinido
	 */
	@Override
	public boolean equals(Object obj) {
		Enologo otroEnologo = (Enologo) obj;
		return Double.doubleToLongBits(minutaPorHora) == Double.doubleToLongBits(otroEnologo.minutaPorHora)
				&& Objects.equals(nombre, otroEnologo.nombre);
	}
	
}
