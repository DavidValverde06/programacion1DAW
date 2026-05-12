package trabajadores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Si está a tiempo completo también necesitamos saber su número de trienios, así como el plus o pluses que tiene (puede no tener
 * pluses).
 */
public class EmpleadoTiempoCompleto extends Empleado {

	/**
	 * Variables de instancia
	 */
	private int numTrienios;
	private List<EnumPlus> pluses;

	/**
	 * Constructor
	 */
	public EmpleadoTiempoCompleto(String nombre, LocalDate fechaNacimiento, EnumCategoria categoriaProfesional,
			int numHijos, int numTrienios, List<EnumPlus> pluses) {
		super(nombre, fechaNacimiento, categoriaProfesional, numHijos);
		this.numTrienios = numTrienios;
		this.pluses = pluses;
	}

	public EmpleadoTiempoCompleto(String nombre, LocalDate fechaNacimiento, EnumCategoria categoriaProfesional,
			int numHijos, int numTrienios) {
		super(nombre, fechaNacimiento, categoriaProfesional, numHijos);
		this.numTrienios = numTrienios;
		this.pluses = new ArrayList<>();
	}

	/**
	 * Getter's y setter's
	 */
	public int getNumTrienios() {
		return numTrienios;
	}

	public void setNumTrienios(int numTrienios) {
		this.numTrienios = numTrienios;
	}

	public List<EnumPlus> getPluses() {
		return pluses;
	}

	public void setPluses(List<EnumPlus> pluses) {
		this.pluses = pluses;
	}

	/**
	 * Un método para calcular el salario bruto, cuyo cálculo se detalla a continuación:
	 * o Se tomará como base la categoría profesional del empleado.
	 * o Se incrementará en 50€ por hijo.
	 * o Si el empleado está a tiempo completo, se le sumarán 100€ por cada trienio, más los pluses que
	 * tenga reconocidos.
	 */
	public double calculoSalarioBruto() {
		int sumaPluses = 0;
		if (pluses!=null) {
			for (EnumPlus enumPlus : pluses) {
				sumaPluses += enumPlus.getImporteIncrementaSalario();
			}
		}
		return super.calculoSalarioBruto() + (this.PRECIO_INCREMENTO_POR_TRIENIO * this.numTrienios) + sumaPluses;
	}

	/**
	 * En el caso de empleados a tiempo completo, se deben poder añadir algún plus en el momento que
	 * se desee.
	 */
	public boolean añadirPlus(EnumPlus plus) {
		return this.pluses.add(plus);
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return super.toString() +
				"\n\tEmpleado a tiempo completo" +
				"\n\tNúmero de trienios: " + this.numTrienios +
				"\n\tPlus: " + (this.pluses.isEmpty() ? "No tiene" : this.pluses);
	}
}
