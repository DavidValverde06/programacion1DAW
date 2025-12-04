package alquilerVehiculos;

import java.util.Objects;

/**
 * B) Clase Cliente, de un cliente nos interesa conocer su nombre completo, DNI, número de teléfono y si es
 * VIP o no. Los métodos que debe proporcionar esta clase serán:
 * 
 * • Constructor, estará sobrecargado, uno recibirá el nombre, DNI y teléfono, y otro sólo el nombre y el
 * DNI. Cuando se crea un cliente, no es VIP, esa condición la adquirirá con el tiempo.
 * 
 * • Métodos get, set y toString, este último con un formato de salida similar a los siguientes ejemplos:
 * 		Cliente: Juan Pérez (DNI: 12345678A, Tlf.: 600123456 – NO VIP)
 * 		Cliente: María López (DNI: 87654321B, Tlf.: No disponible – NO VIP)
 * 		Cliente: Manuel García (DNI: 222333444X, Tlf.: 604987654 - VIP)
 * 
 * • Método para comparar clientes, consideraremos que dos clientes son iguales, si coincide su DNI
 */

public class Cliente {

	/**
	 * Variables de instancia
	 */
	private String nombreCompleto;
	private String dni;
	private String numTlf;
	private boolean vip;

	/**
	 * Constructor
	 */
	public Cliente(String nombreCompleto, String dni, String numTlf) {
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.numTlf = numTlf;
		this.vip = false;
	}

	public Cliente(String nombreCompleto, String dni) {
		this.nombreCompleto = nombreCompleto;
		this.dni = dni;
		this.numTlf = "No disponible";
		this.vip = false;
	}
	/**
	 * Getter's y setter's
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNumTlf() {
		return numTlf;
	}

	public void setNumTlf(String numTlf) {
		this.numTlf = numTlf;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	/**
	 * toString redefinido
	 * 
	 * 		Cliente: Juan Pérez (DNI: 12345678A, Tlf.: 600123456 – NO VIP)
	 * 		Cliente: María López (DNI: 87654321B, Tlf.: No disponible – NO VIP)
	 * 		Cliente: Manuel García (DNI: 222333444X, Tlf.: 604987654 - VIP)
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + this.nombreCompleto +
				"(DNI: " + this.dni + ", Tlf.: " + this.numTlf + " - " + (this.vip?"VIP":"NO VIP");
	}
	
	/**
	 * equals redefinido
	 */
	@Override
	public boolean equals(Object obj) {
		Cliente otroCliente = (Cliente) obj;
		return Objects.equals(dni, otroCliente.dni);
	}
}
