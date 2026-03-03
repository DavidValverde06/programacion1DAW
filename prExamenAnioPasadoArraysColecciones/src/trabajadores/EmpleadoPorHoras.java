package trabajadores;

import java.time.LocalDate;

/**
 * Si el empleado está por horas, necesitamos conocer el número de horas trabajadas.
 */
public class EmpleadoPorHoras extends Empleado {

	/**
	 * Variables de instancia
	 */
	private int horasTrabajadas;

	/**
	 * Constructor
	 */
	public EmpleadoPorHoras(String nombre, LocalDate fechaNacimiento, EnumCategoria categoriaProfesional, int numHijos,
			int horasTrabajadas) {
		super(nombre, fechaNacimiento, categoriaProfesional, numHijos);
		this.horasTrabajadas = horasTrabajadas;
	}

	/**
	 * Getter's y setter's
	 */
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	/**
	 * Un método para calcular el salario bruto, cuyo cálculo se detalla a continuación:
	 * o Se tomará como base la categoría profesional del empleado.
	 * o Se incrementará en 50€ por hijo.
	 * o Si el empleado está por horas, se dividirá el cálculo de los dos primeros puntos entre 150 (horas
	 * que se estima se trabajan en un mes), y se multiplicará por el número de horas trabajadas.
	 */
	public double calculoSalarioBruto() {
		return (super.calculoSalarioBruto() / this.HORAS_ESTIMADAS_TRABAJADAS) * this.horasTrabajadas;
	}

	@Override
	public double calculoSalarioNeto() {
		double porcentajeIRPF;

		if (calculoSalarioBruto()>=3500) porcentajeIRPF = 0.20;
		else if (calculoSalarioBruto()>=2500) porcentajeIRPF = 0.15;
		else if (calculoSalarioBruto()>=1500) porcentajeIRPF = 0.10;
		else porcentajeIRPF = 0.05;

		return calculoSalarioBruto() - (calculoSalarioBruto()*PORCENTAJE_IVA) - (calculoSalarioBruto()*porcentajeIRPF);
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tEmpleado por horas: " + this.horasTrabajadas + " horas trabajadas";
	}
}
