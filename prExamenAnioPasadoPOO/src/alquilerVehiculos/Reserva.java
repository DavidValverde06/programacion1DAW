package alquilerVehiculos;

import java.util.Objects;

/**
 * D) Clase Reserva, de una reserva queremos saber el cliente que la realiza, el vehículo que alquila, el número
 * de días de alquiler y si incluye un seguro adicional. Desarrollaremos los siguientes métodos:
 * 
 * • Constructor y métodos get y set.
 * 
 * • Un método que calcule el precio total a pagar por el alquiler, para ellos tendremos en cuenta:
 * 		o El precio por día de alquiler del vehículo alquilado y el número de días de alquiler.
 * 
 * 		o Si los impuestos anuales que paga el vehículo alquilado superan los 100€, el precio se incrementará
 * 		en 10€, y si no superan los 100€ se incrementará en 5€.
 * 
 * 		o Si incluye seguro adicional, el coste se incrementa en un 20%.
 * 
 * 		o Si es cliente VIP, se le hará un descuento de 10%.
 * 
 * • Un método para comparar reservas, consideraremos que dos reservas son iguales si coincide el cliente,
 * el vehículo y el número de días.
 * 
 * • Un método toString, con un formato similar a los siguientes ejemplos:
 * 		Reserva: Juan Pérez (DNI: 12345678A) ha alquilado un Hyundai Tucson por 3 días. Precio total: 186.0€
 * 		Reserva: María López (DNI: 87654321B) ha alquilado un Renault Kangoo por 2 días. Precio total: 130.0€
 * 		Reserva: Manuel García (DNI: 222333444X) ha alquilado un Renault Kangoo por 2 días. Precio total: 117.0€
 * 
 * • Un método toStringDetallado, que nos dé más información sobre la Reserva, y cuya salida sea similar
 * a la que podéis ver en los siguientes ejemplos:
 */

public class Reserva {

	/**
	 * Variables de instancia
	 */
	private Cliente clienteReserva;
	private Vehiculo vehiculoReserva;
	private int numDiasAlquiler;
	private boolean seguroAdicional;

	/**
	 * Constructor
	 */
	public Reserva(Cliente clienteReserva, Vehiculo vehiculoReserva, int numDiasAlquiler, boolean seguroAdicional) {
		this.clienteReserva = clienteReserva;
		this.vehiculoReserva = vehiculoReserva;
		this.numDiasAlquiler = numDiasAlquiler;
		this.seguroAdicional = seguroAdicional;
	}

	/**
	 * Getter's y setter's
	 */
	public Cliente getClienteReserva() {
		return clienteReserva;
	}

	public Vehiculo getVehiculoReserva() {
		return vehiculoReserva;
	}

	public int getNumDiasAlquiler() {
		return numDiasAlquiler;
	}

	public boolean isSeguroAdicional() {
		return seguroAdicional;
	}

	public void setClienteReserva(Cliente clienteReserva) {
		this.clienteReserva = clienteReserva;
	}

	public void setVehiculoReserva(Vehiculo vehiculoReserva) {
		this.vehiculoReserva = vehiculoReserva;
	}

	public void setNumDiasAlquiler(int numDiasAlquiler) {
		this.numDiasAlquiler = numDiasAlquiler;
	}

	public void setSeguroAdicional(boolean seguroAdicional) {
		this.seguroAdicional = seguroAdicional;
	}

	/**
	 * Un método que calcule el precio total a pagar por el alquiler, para ellos tendremos en cuenta:
	 * 		o El precio por día de alquiler del vehículo alquilado y el número de días de alquiler.
	 * 
	 * 		o Si los impuestos anuales que paga el vehículo alquilado superan los 100€, el precio se incrementará
	 * 		en 10€, y si no superan los 100€ se incrementará en 5€.
	 * 
	 * 		o Si incluye seguro adicional, el coste se incrementa en un 20%.
	 * 
	 * 		o Si es cliente VIP, se le hará un descuento de 10%.
	 */
	public float precioTotalPagar() {
		float totalPagar=this.vehiculoReserva.getPrecioPorDia()*this.numDiasAlquiler;
		if (this.vehiculoReserva.pagoImpuestos()>100) {
			totalPagar+=10;
		}
		else {
			totalPagar+=5;
		}
		
		if (this.seguroAdicional) {
			totalPagar = totalPagar * 1.20f;
		}
		
		if (this.clienteReserva.isVip()) {
			totalPagar = totalPagar * 0.90f;
		}
		
		return totalPagar;

	}

	/**
	 * Un método para comparar reservas, consideraremos que dos reservas son iguales si coincide el cliente,
	 * el vehículo y el número de días.
	 */
	@Override
	public boolean equals(Object obj) {
		Reserva otraReserva = (Reserva) obj;
		return Objects.equals(clienteReserva, otraReserva.clienteReserva) && numDiasAlquiler == otraReserva.numDiasAlquiler
				&& Objects.equals(vehiculoReserva, otraReserva.vehiculoReserva);
	}

	/**
	 * Un método toString, con un formato similar a los siguientes ejemplos:
	 * 		Reserva: Juan Pérez (DNI: 12345678A) ha alquilado un Hyundai Tucson por 3 días. Precio total: 186.0€
	 * 		Reserva: María López (DNI: 87654321B) ha alquilado un Renault Kangoo por 2 días. Precio total: 130.0€
	 * 		Reserva: Manuel García (DNI: 222333444X) ha alquilado un Renault Kangoo por 2 días. Precio total: 117.0€
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + this.clienteReserva.getNombreCompleto() + " (DNI: " + this.clienteReserva.getDni() + ") ha alquilado"
				+ " un " + this.vehiculoReserva.getModelo() + " por " + this.numDiasAlquiler + " días. Precio total: " + this.precioTotalPagar() + "€";
	}
	
	/**
	 * Un método toStringDetallado, que nos dé más información sobre la Reserva, y cuya salida sea similar
	 * a la que podéis ver en los siguientes ejemplos:
	 * 
	 * RESERVA: Precio final: 186.0€
	 * 		Cliente: Cliente: Juan Pérez (DNI: 12345678A, Tlf.: 600123456 - NO VIP)
	 * 		Vehículo: ABC1234 - Hyundai Tucson
	 * 			Precio por día de alquiler: 50.0€
	 * 			Impuestos anuales: 55.0€
	 * 		Días del alquiler: 3
	 * 		Seguro adicional: SI
	 */
	public String toStringDetallado() {
		return getClass().getSimpleName().toUpperCase() + ": Precio final: " + precioTotalPagar() + "€" +
				"\n\tCliente: " + this.clienteReserva.toString() +
				"\n\tVehículo: " + this.vehiculoReserva.getMatricula() + " - " + this.vehiculoReserva.getModelo() +
				"\n\t\tPrecio por día de alquiler: " + this.vehiculoReserva.getPrecioPorDia() + "€" +
				"\n\t\tImpuestos anuales: " + this.vehiculoReserva.pagoImpuestos() + "€" +
				"\n\tDías del alquiler: " + this.numDiasAlquiler +
				"\n\tSeguro adicional: " + (this.seguroAdicional?"SI":"NO");
	}
}
