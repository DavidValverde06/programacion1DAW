package cuenta;

import java.util.Objects;

/**
 * 2. Crear la clase Cuenta que mantiene la siguiente información por cada cuenta: 
 * número de la cuenta, nombre del titular y saldo.
 * 
 * Además, existen un tipo de interés que es común a todas las cuentas y que se
 * mantiene siempre fijo en el 3% y un acumulador del disponible que hay en el banco en cada momento
 * (es decir, del dinero que tiene el banco entre todas las cuentas).
 * 
 * El interfaz de esta clase debe proporcionar al menos:
 * ✓ Inicializador estático: Inicializa las variables de clase, si es que las hay.
 * ✓ Constructor: inicializa las variables miembro de objeto con los datos de creación de la cuenta.
 * ✓ Ingreso: Ingresa la cantidad indicada en la cuenta que se especifique.
 * ✓ Reintegro: Saca la cantidad indicada de la cuenta que se especifique, siempre y cuando haya saldo
 * suficiente.
 * 
 * ✓ ReseteaAcumuladorBanco: Método que pone a 0 el acumulador del banco.
 * 
 * ✓ calcularIntereses(): Este método calcula los beneficios obtenidos por el cliente en función de su saldo
 * y el interés que mantiene fijo el banco.
 * 
 * ✓ Métodos get, set, equals y toString, este ultimo con un formato de salida similar a:
 * 		Datos cuenta bancaria
 * 		Nº de cuenta: 1234565432
 * 		Titular: José García Pozo
 * 		Saldo: 10000.0
 * 		Interés obtenido: 300.0
 * 
 * ✓ Finalizador: Mostrará un mensaje que diga “Objeto destruido”.
 * 
 * Hacer un algoritmo para probar el funcionamiento de la clase.
 */

public class Cuenta {

	/**
	 * Variables de instancia
	 */
	private int numCuenta;
	private String nombreTitular;
	private float saldo;

	/**
	 * Variables de clase
	 */
	final static int INTERES=3;
	static int acumulador;

	/**
	 * Inicializador
	 */
	static {
		acumulador=0;
		System.out.println("Inicializador estático ejecutado");
	}

	/**
	 * Constructor
	 */
	public Cuenta(int numCuenta, String nombreTitular, float cantidad) {
		this.numCuenta = numCuenta;
		this.nombreTitular = nombreTitular;
		this.saldo = cantidad;
		Cuenta.acumulador += saldo; // añadir saldo inicial al acumulador
	}

	/**
	 * Método Ingreso
	 * 
	 * Ingresa la cantidad indicada en la cuenta que se especifique.
	 */
	public void ingreso(float cantidad) {
		if (saldo>0) {
			this.saldo+=cantidad;
			Cuenta.acumulador+=saldo;
		}
		else {
			System.out.println("La cantidad a ingresar debe ser positiva");
		}
	}

	/**
	 * Método Reintegro
	 * 
	 * Saca la cantidad indicada de la cuenta que se especifique, siempre y cuando haya saldo
	 */
	public void reintegro(float saldo) {

		if (saldo>0) {
			if (this.saldo>=saldo) {
				this.saldo-=saldo;
				Cuenta.acumulador-=saldo;
			}	
			else {
				System.out.println("Saldo insuficiente");
			}
		}
		else {
			System.out.println("La cantidad a retirar debe ser positiva");
		}
	}

	/**
	 * reseteaAcumuladorBanco()
	 * 
	 * Método que pone a 0 el acumulador del banco.
	 */
	public int reseteaAcumuladorBanco() {
		return Cuenta.acumulador=0;
	}

	/**
	 * calcularIntereses()
	 * 
	 * Este método calcula los beneficios obtenidos por el cliente en función de su saldo
	 * y el interés que mantiene fijo el banco.
	 */
	public float calcularIntereses() {
		return this.saldo * INTERES/100.0f;
	}

	/**
	 * Getter's y setter's
	 */
	public int getNumCuenta() {
		return numCuenta;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public float getSaldo() {
		return saldo;
	}

	public static int getInteres() {
		return INTERES;
	}

	public static int getAcumulador() {
		return acumulador;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public static void setAcumulador(int acumulador) {
		Cuenta.acumulador = acumulador;
	}

	/**
	 * Método equals redefinido
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombreTitular, numCuenta, saldo);
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
		return Objects.equals(nombreTitular, other.nombreTitular) && numCuenta == other.numCuenta
				&& saldo == other.saldo;
	}

	/**
	 * Método toString redefinido
	 * 
	 * Datos cuenta bancaria
	 * 		Nº de cuenta: 1234565432
	 * 		Titular: José García Pozo
	 * 		Saldo: 10000.0
	 * 		Interés obtenido: 300.0
	 */
	@Override
	public String toString() {
		return "Datos cuenta bancaria" +
				"\n\tNº de cuenta: " + this.numCuenta +
				"\n\tTitular: " + this.nombreTitular +
				"\n\tSaldo: " + this.saldo +
				"\n\tInterés obtenido: " + calcularIntereses();
	}

	/**
	 * Finalizador (Deprecated)
	 */
//	@Override
//	protected void finalize() throws Throwable {
//		System.out.println("Objeto destruido");
//		super.finalize();
//	}

}
