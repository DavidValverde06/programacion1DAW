package trabajadores;

import java.util.*;

/**
 * Clase Empresa, en la que guardaremos en una colección los empleados de la empresa, los cuales no
 * pueden estar repetidos y deben estar ordenados por su orden natural (fecha de nacimiento de más
 * joven a más mayor, y si esta se repite por nombre).
 */
public class Empresa {

	/**
	 * Variables de instancia
	 */
	private SortedSet<Empleado> empleadosEmpresa;

	/**
	 * Constructor y métodos get y set.
	 */
	public Empresa(SortedSet<Empleado> empleadosEmpresa) {
	    this.empleadosEmpresa = new TreeSet<>(empleadosEmpresa);
	}

	public SortedSet<Empleado> getEmpleadosEmpresa() {
		return empleadosEmpresa;
	}

	public void setEmpleadosEmpresa(SortedSet<Empleado> empleadosEmpresa) {
		this.empleadosEmpresa = empleadosEmpresa;
	}

	/**
	 * Método para poder añadir empleados.
	 */
	public boolean añadirEmpleado(Empleado empleado) {
	    return empleadosEmpresa.add(empleado); // Devuelve false si ya estaba
	}

	/**
	 * Método toString, con un formato de salida similar a:
	 */
	@Override
	public String toString() {
		String cadena = "EMPLEADOS DE LA EMPRESA\n";

		for (Empleado empleado : empleadosEmpresa) {
			cadena += empleado.toStringLineal() + "\n";
		}

		return cadena;
	}

	/**
	 * Método para buscar empleados, este método estará sobrecargado, ya que nos puede llegar un
	 * objeto empleado, para comprobar si ya existe o no. O bien el nombre y la fecha de nacimiento,
	 * en cuyo caso, deberemos comprobar si algún empleado tiene esos atributos, y devolverlo.
	 */
	
	faltan metodos
	
	
	/**
	 * Método para borrar empleados, también sobrecargado como el método de buscar.
	 */

	/**
	 * Método ordenaSalarioNeto, que nos devuelva una copia de la colección de empleados ordenada
	 * por salario neto de menor a mayor. La copia debe ser una colección tipo List.
	 */

	/**
	 * Método toStringListaOrdenadaSalario, que nos devuelva una cadena con la colección anterior,
	 * similar al toString.
	 */

	/**
	 * Método agregarPlus, que nos permita añadir un determinado plus a todos los empleados de la
	 * empresa que estén a tiempo completo.
	 */

	/**
	 * Método que permite convertir Empleados a Empleados a tiempo completo. 2
	 */
}
