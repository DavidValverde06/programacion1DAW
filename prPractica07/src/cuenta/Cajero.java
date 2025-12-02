package cuenta;

/**
 * Asimismo vamos a desarrollar la clase Cajero para gestionar un cajero automático. Un cajero guardará
 * información sobre el número de billetes de 10, 20, 50 y 100 euros de los que dispone en cada momento.
 */

public class Cajero implements InterfazCajero {
	
	/**
	 * Variables de instancia
	 */
	private int billete10;
	private int billete20;
	private int billete50;
	private int billete100;
	
	/**
	 * Constructor
	 */
	public Cajero(int billete10, int billete20, int billete50, int billete100) {
		this.billete10 = billete10;
		this.billete20 = billete20;
		this.billete50 = billete50;
		this.billete100 = billete100;
	}
	
	/**
	 * disponible(). Devuelve el dinero que en ese momento tiene disponible el cajero.
	 */
	@Override
	public float disponible() {
		return (this.billete10*10 + this.billete20*20 + this.billete50*50 + this.billete100*100);
	}
	
	/**
	 * sacar(Cuenta ob, int numeroSecreto, int cantidad).
	 * 
	 * Permitirá a un cliente (de cualquiera de los tres tipos de cuentas) poder sacar 
	 * dinero del cajero, para ello deberá verificarse que la contraseña sea correcta,
	 * que el cliente disponga del dinero que pretende sacar, y que el cajero tenga la cantidad y
	 * los billetes necesarios para el reintegro.
	 * 
	 * Este método deberá mostrar un mensaje indicando el
	 * desglose de billetes suministrados al cliente. Asimismo deberá actualizar el cajero con su nuevo
	 * disponible.
	 */
	@Override
	public float sacar(Cuenta cuentaCliente, int numeroSecreto, int cantidad) {
		if (!cuentaCliente.validar(numeroSecreto)) {
			System.out.println("PIN incorrecto.");
			return 0;
		}
		if (cuentaCliente.saldoActual<cantidad) {
			System.out.println("No hay suficiente dinero para sacar de la cuenta.");
			return 0;
		}
		if (disponible()<cantidad) {
			System.out.println("No hay suficiente dinero en el cajero para sacar.");
			return 0;
		}
		return 
	}
	
	/**
	 * toString redefinido con el siguiente formato:
	 * 
	 * Disponible cajero:
	 * 		4 billetes de 10 €
	 * 		5 billetes de 20 €
	 * 		0 billetes de 50 €
	 * 		2 billetes de 100 €
	 */
	@Override
	public String toString() {
		return "Disponible cajero: " +
				"\n\t" + this.billete10 + " billetes de 10 €" +
				"\n\t" + this.billete20 + " billetes de 20 €" +
				"\n\t" + this.billete50 + " billetes de 50 €" +
			   "\n\t" + this.billete100 + " billetes de 100 €";
	}
}
