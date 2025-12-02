package cuenta;

/**
 * Crear, a partir de la clase anterior, las siguientes clases con los métodos que consideres oportunos.
 * 
 * - CuentaJoven, en esta clase, además de los datos anteriores interesa conocer la edad del cliente. En
 * este tipo de cuenta se deberá controlar que el cliente no pueda sacar más dinero del disponible en su
 * cuenta, es decir, no podrá estar en números rojos
 */

public class CuentaJoven extends Cuenta {

	/**
	 * Variables de instancia
	 */
	private byte edadCliente;
	
	/**
	 * Constructor
	 */
	public CuentaJoven(int numCuenta, String nombreTitular, float saldoActual, int numSecreto, byte edadCliente) {
		super(numCuenta, nombreTitular, saldoActual, numSecreto);
		this.edadCliente = edadCliente;
	}

	/**
	 * Getter's y setter's
	 */
	public byte getEdadCliente() {
		return edadCliente;
	}

	public void setEdadCliente(byte edadCliente) {
		this.edadCliente = edadCliente;
	}
	
	/**
	 * reintegro(real cantidad) redefinido. Saca cantidad de la cuenta.
	 * 
	 * Se deberá controlar que el cliente no pueda sacar más dinero del disponible en su
	 * cuenta, es decir, no podrá estar en números rojos.
	 */
	@Override
	public float reintegro(float cantidad) {
		if (getSaldoActual()>0) {
		return this.saldoActual-=cantidad;
		}
		return this.saldoActual;
	}
	
	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nEdad del cliente: " + this.edadCliente;
	}
	
}
