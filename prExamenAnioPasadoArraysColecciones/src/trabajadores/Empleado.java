package trabajadores;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase Empleado, sobre un empleado queremos conocer su nombre, fecha de nacimiento, categoría
 * profesional y el número de hijos que tiene, ya que la empresa promociona la natalidad.
 * 
 * Los empleados además pueden estar a tiempo completo o por horas.
 * 
 * Se puede dar el caso de que un empleado, transcurrido un tiempo de trabajo en la empresa se
 * convierta en empleado a tiempo completo. El mismo caso se puede dar con un empleado por horas,
 * es decir, que se convierta en empleado a tiempo completo.
 */
public class Empleado implements Comparable<Empleado> {

	/**
	 * Variables de clase
	 */
	final int PRECIO_INCREMENTO_POR_HIJO = 50;
	final int PRECIO_INCREMENTO_POR_TRIENIO = 100;
	final int HORAS_ESTIMADAS_TRABAJADAS = 150;
	final double PORCENTAJE_IVA = 0.04;

	/**
	 * Variables de instancia
	 */
	private String nombre;
	private LocalDate fechaNacimiento;
	private EnumCategoria categoriaProfesional;
	private int numHijos;

	/**
	 * Constructor
	 */
	public Empleado(String nombre, LocalDate fechaNacimiento, EnumCategoria categoriaProfesional, int numHijos) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.categoriaProfesional = categoriaProfesional;
		this.numHijos = numHijos;
	}

	/**
	 * Getter's y setter's
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EnumCategoria getCategoriaProfesional() {
		return categoriaProfesional;
	}

	public void setCategoriaProfesional(EnumCategoria categoriaProfesional) {
		this.categoriaProfesional = categoriaProfesional;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	/**
	 * Un método para calcular el salario bruto, cuyo cálculo se detalla a continuación:
	 * 		o Se tomará como base la categoría profesional del empleado.
	 * 		o Se incrementará en 50€ por hijo.
	 */
	public double calculoSalarioBruto() {
		return (this.categoriaProfesional.getSalarioBase() + (this.PRECIO_INCREMENTO_POR_HIJO * this.numHijos));
	}

	/**
	 * Un método para calcular el salario neto, para su cálculo al salario bruto habrá que aplicarle los
	 * impuestos que serán un 4% de Seguridad Social, y un porcentaje de IRPF en función de los siguientes
	 * tramos y porcentajes:
	 * 		o Inferior a 1500€ - retención 5%
	 * 		o Superior o igual a 1500€ e inferior a 2500€ - retención 10%
	 * 		o Superior o igual a 2500€ e inferior a 3500€ - retención 15%
	 * 		o Superior o igual a 3500 – retención 20%
	 */
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
		return this.nombre + " - Categoría: " + this.categoriaProfesional +
				"\n\tFecha de nacimiento: " + LibreriaFechasJava8.getFechaShort(this.fechaNacimiento) + " (" + LibreriaFechasJava8.getEdad(this.fechaNacimiento) + ")" +
				"\n\tSalario Bruto: " + this.calculoSalarioBruto() + "€" +
				"\n\tSalario Neto: " + this.calculoSalarioNeto() + "€" +
				"\n\tHijos: " + this.numHijos;
	}

	/**
	 * toStringLineal
	 * 
	 * 		18/09/1985 María Ríos (Salario neto: 2535.3€) – EmpleadoTiempoCompleto
	 */
	public String toStringLineal() {
		return LibreriaFechasJava8.getFechaShort(fechaNacimiento) + " " + this.nombre + " (Salario neto: " +
				this.calculoSalarioNeto() + "€) - " + this.getClass().getSimpleName();
	}

	/**
	 * equals y hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento);
	}

	@Override
	public int compareTo(Empleado o) {
		// Primero fecha de nacimiento: más joven primero
		int compare = o.getFechaNacimiento().compareTo(this.fechaNacimiento); // o-año más joven primero
		if (compare != 0) {
			return compare;
		}
		
		// Si coinciden fechas, ordenar por nombre
		return this.nombre.compareToIgnoreCase(o.getNombre());
	}
}
