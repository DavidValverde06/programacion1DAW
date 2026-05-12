package cuenta;

import java.time.LocalDate;

/**
 * Crear, a partir de la clase anterior, las siguientes clases con los métodos que consideres oportunos.
 * 
 * - CuentaEmpresarial, este tipo de cuenta, tiene como información adicional el nombre de la empresa,
 * así como la suma de todos los ingresos y de todos los reintegros que se realizan sobre la cuenta a
 * partir de una fecha dada.
 * 
 * Estos últimos totales se podrán poner a cero en el momento que el
 * empresario lo desee, quedando recogida la fecha del evento. La fecha inicial será la del día de la
 * creación de la cuenta, estando inicialmente estos totales a cero
 */

public class CuentaEmpresarial extends Cuenta {

	/**
	 * Variables de instancia
	 */
	private String nombreEmpresa;
	private float sumaTotalIngresos;
	private float sumaTotalReintegros;
	private LocalDate fecha;

	/**
	 * Constructor
	 */
	public CuentaEmpresarial(int numCuenta, String nombreTitular, float saldoActual, int numSecreto,
			String nombreEmpresa, float sumaTotalIngresos, float sumaTotalReintegros, LocalDate fecha) {
		super(numCuenta, nombreTitular, saldoActual, numSecreto);
		this.nombreEmpresa = nombreEmpresa;
		this.sumaTotalIngresos = 0;
		this.sumaTotalReintegros = 0;
		this.fecha = LocalDate.now();
	}

	/**
	 * Registrar ingresos
	 */
	public void registrarIngreso(float cantidad) {
		super.imposicion(cantidad);
		this.sumaTotalIngresos+=cantidad;
	}

	/**
	 * Registrar reintegros
	 */
	public void registrarReintegro(float cantidad) {
		super.reintegro(cantidad);
		this.sumaTotalReintegros-=cantidad;
	}

	/**
	 * Reiniciar 
	 */
	public void reiniciarTotales() {
		sumaTotalIngresos = 0;
		sumaTotalReintegros = 0;
		fecha = LocalDate.now();
	}

	/**
	 * toString redefinido
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\nNombre de la empresa: " + nombreEmpresa +
				"\nTotales desde " + fecha +
				"\nIngresos acumulados: " + sumaTotalIngresos + " €" +
				"\nReintegros acumulados: " + sumaTotalReintegros + " €";
	}
}
