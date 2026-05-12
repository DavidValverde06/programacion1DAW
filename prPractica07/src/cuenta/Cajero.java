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
	public void sacar(Cuenta cuentaCliente, int numeroSecreto, int cantidad) {
		int contBilletes10=0,contBilletes20=0,contBilletes50=0,contBilletes100=0,cantidadRestante = cantidad;

		if (!cuentaCliente.validar(numeroSecreto)) {
			System.out.println("PIN incorrecto.");
			return;
		}
		if (cuentaCliente.saldoActual<cantidad) {
			System.out.println("No hay suficiente dinero en la cuenta.");
			return;
		}
		if (disponible()<cantidad) {
			System.out.println("No hay suficiente dinero en el cajero.");
			return;
		}

		while (cantidadRestante>0) {
			if (cantidadRestante>=100 && this.billete100>0) {
				cantidadRestante-=100;
				this.billete100--;
				contBilletes100++;
			}
			else if (cantidadRestante>=50 && this.billete50>0) {
				cantidadRestante-=50;
				this.billete50--;
				contBilletes50++;
			}
			else if (cantidadRestante>=20 && this.billete20>0) {
				cantidadRestante-=20;
				this.billete20--;
				contBilletes20++;
			}
			else if (cantidadRestante>=10 && this.billete10>0) {
				cantidadRestante-=10;
				this.billete10--;
				contBilletes10++;
			}
			else {
				System.out.println("El cajero no puede dispensar el importe solicitado con los billetes disponibles.");
				return;
			}
		}

		cuentaCliente.saldoActual -= cantidad;

		System.out.println("Operación realizada con éxito.");
		System.out.println("Desglose de billetes entregados:" +
				"\n" + contBilletes10 + " billetes de 10 €" +
				"\n" + contBilletes20 + " billetes de 20 €" +
				"\n" + contBilletes50 + " billetes de 50 €" +
				"\n" + contBilletes100 + " billetes de 100 €");
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
