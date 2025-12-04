package alquilerVehiculos;

/**
 * E) Clase de testeo de todo lo desarrollado anteriormente.
 */

public class TestAlquilerVehiculos {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("David Valverde", "5141898H", "654289143");
		Turismo turismo1 = new Turismo("4785BDL", "Honda Civic", 5, 50, 50, "Sedan", false);
		Furgoneta furgo1 = new Furgoneta("3453LKM", "Fiat Ducato", 3, 100, 100, 6);
		Reserva reserva1 = new Reserva(cliente1, turismo1, 15, false);
		
		System.out.println(cliente1+"\n");
		System.out.println(turismo1+"\n");
		System.out.println(furgo1+"\n");
		System.out.println(reserva1.toStringDetallado()+"\n");
		System.out.println(reserva1.toString()+"\n");
	}

}
