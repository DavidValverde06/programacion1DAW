package ejemplos;

import java.util.Objects;

/**
 * 2.- La información que maneja una sucursal bancaria sobre las cuentas de sus clientes es la siguiente:
 * número de cuenta, nombre del titular de la cuenta, saldo actual de la cuenta y número secreto de la
 * tarjeta o libreta.
 * 
 * Desarrollar la clase Cuenta, con al menos los siguientes métodos:
 * ▪ Constructor. Crea una cuenta nueva.
 * ▪ Métodos set y get.
 * ▪ imposicion(real cantidad). Ingresa cantidad en la cuenta.
 * ▪ reintegro(real cantidad). Saca cantidad de la cuenta.
 * ▪ toString( ). Devuelve toda la información disponible sobre la cuenta, excepto el nº secreto.
 * ▪ Método equals. Dos cuentas serán iguales si coincide su número.
 * ▪ validar(int clave). Devuelve true si el número secreto de la tarjeta o libreta es correcto y false en caso
 * 	 contrario. 
 */

public class Cuenta {
	
	/**
	 * Variables de instancia
	 */
	private int numCuenta;
	private String nombreTitular;
	protected float saldoActual;
	private int numSecreto;
	
	/**
	 * Constructor
	 */
	public Cuenta(int numCuenta, String nombreTitular, float saldoActual, int numSecreto) {
		super();
		this.numCuenta = numCuenta;
		this.nombreTitular = nombreTitular;
		this.saldoActual = saldoActual;
		this.numSecreto = numSecreto;
	}
	
	/**
	 * Métodos getter's y setter's
	 */
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public float getSaldoActual() {
		return saldoActual;
	}
	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}
	public int getNumSecreto() {
		return numSecreto;
	}
	public void setNumSecreto(int numSecreto) {
		this.numSecreto = numSecreto;
	}
	
	/**
	 * imposicion(real cantidad). Ingresa cantidad en la cuenta.
	 */
	public void imposicion(float cantidad) {
		this.saldoActual+=cantidad;
	}
	
	/**
	 * reintegro(real cantidad). Saca cantidad de la cuenta.
	 */
	public void reintegro(float cantidad) {
		this.saldoActual-=cantidad;
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() +
				"\nNúmero de la cuenta: " + this.numCuenta +
				"\nNombre del titular de la cuenta: " + this.nombreTitular +
				"\nSaldo actual de la cuenta: " + this.saldoActual + " €";
	}
	
	/**
	 * Método equals redefinido
	 */
	@Override
	public int hashCode() {
		return Objects.hash(numCuenta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return numCuenta == other.numCuenta;
	}
	
	/**
	 * validar(int clave).
	 * 
	 * Devuelve true si el número secreto de la
	 * tarjeta o libreta es correcto y false en caso contrario.
	 */
	public boolean validar(int clave) {
		if (clave == this.numSecreto) {
			return true;
		}
		return false;
	}
}
