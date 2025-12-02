package cuenta;

/**
 * Implementa un interfaz con, al menos, los siguientes métodos:
 * • constructor. Crea un objeto de la clase Cajero.
 * 
 * • disponible( ). Devuelve el dinero que en ese momento tiene disponible el cajero.
 * 
 * • toString(). Devuelve una cadena con un formato similar al siguiente:
 * 		Disponible cajero:
 * 			4 billetes de 10 €
 * 			5 billetes de 20 €
 * 			0 billetes de 50 €
 * 			2 billetes de 100 €
 * 
 * • sacar(Cuenta ob, int numeroSecreto, int cantidad). Permitirá a un cliente (de cualquiera de los tres
 * tipos de cuentas) poder sacar dinero del cajero, para ello deberá verificarse que la contraseña sea
 * correcta, que el cliente disponga del dinero que pretende sacar, y que el cajero tenga la cantidad y
 * los billetes necesarios para el reintegro. Este método deberá mostrar un mensaje indicando el
 * desglose de billetes suministrados al cliente. Asimismo deberá actualizar el cajero con su nuevo
 * disponible.
 */

public interface InterfazCajero {

	/**
	 * disponible(). Devuelve el dinero que en ese momento tiene disponible el cajero.
	 */
	public float disponible();

	/**
	 * toString()
	 */
	public String toString();

	/**
	 * sacar(Cuenta ob, int numeroSecreto, int cantidad). 
	 * Permitirá a un cliente (de cualquiera de los tres tipos de cuentas) poder sacar 
	 * dinero del cajero, para ello deberá verificarse que la contraseña sea
	 * correcta, que el cliente disponga del dinero que pretende sacar, y que el cajero tenga la cantidad y
	 * los billetes necesarios para el reintegro. Este método deberá mostrar un mensaje indicando el
	 * desglose de billetes suministrados al cliente. Asimismo deberá actualizar el cajero con su nuevo
	 * disponible.
	 */
	public void sacar(Cuenta ob,int numeroSecreto,int Cantidad);
}
