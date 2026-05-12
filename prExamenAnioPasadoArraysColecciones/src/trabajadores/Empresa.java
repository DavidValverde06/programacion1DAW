package trabajadores;

import java.time.LocalDate;
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
		String cadena = "EMPLEADOS DE LA EMPRESA\n\t";

		for (Empleado empleado : empleadosEmpresa) {
			cadena += empleado.toStringLineal() + "\n\t";
		}

		return cadena;
	}

	/**
	 * Método para buscar empleados, este método estará sobrecargado, ya que nos puede llegar un
	 * objeto empleado, para comprobar si ya existe o no. O bien el nombre y la fecha de nacimiento,
	 * en cuyo caso, deberemos comprobar si algún empleado tiene esos atributos, y devolverlo.
	 */
	public Empleado buscarEmpleado(Empleado empleado) {
		Iterator<Empleado> it = empleadosEmpresa.iterator();
		Empleado empleadoEncontrado=null;
		boolean encontrado=false;
		while (it.hasNext() && encontrado!=true) {
			Empleado elem = it.next();
			if (elem.equals(empleado)) {
				empleadoEncontrado=elem;
				encontrado=true;
			}
		}
		return empleadoEncontrado;
	}

	public Empleado buscarEmpleado(String nombre, LocalDate fechaNacimiento) {
		Iterator<Empleado> it = empleadosEmpresa.iterator();
		Empleado empleadoEncontrado=null;
		boolean encontrado=false;
		while (it.hasNext() && encontrado!=true) {
			Empleado elem = it.next();
			if (elem.getFechaNacimiento().equals(fechaNacimiento) && elem.getNombre().equalsIgnoreCase(nombre)) {
				empleadoEncontrado=elem;
				encontrado=true;
			}
		}
		return empleadoEncontrado;
	}

	/**
	 * Método para borrar empleados, también sobrecargado como el método de buscar.
	 */
	public boolean borrarEmpleado(Empleado empleado) {
		return this.empleadosEmpresa.remove(buscarEmpleado(empleado));
	}

	//	public boolean borrarEmpleado(Empleado empleado) {
	//	    Iterator<Empleado> it = empleadosEmpresa.iterator();
	//	    boolean eliminado = false;
	//
	//	    while (it.hasNext() && !eliminado) {
	//	        Empleado elem = it.next();
	//	        if (elem.equals(empleado)) {
	//	            it.remove();   // elimina correctamente durante el recorrido
	//	            eliminado = true;
	//	        }
	//	    }
	//
	//	    return eliminado;
	//	}

	public boolean borrarEmpleado(String nombre, LocalDate fechaNacimiento) {
		return this.empleadosEmpresa.remove(buscarEmpleado(nombre, fechaNacimiento));
	}

	/**
	 * Método ordenaSalarioNeto, que nos devuelva una copia de la colección de empleados ordenada
	 * por salario neto de menor a mayor. La copia debe ser una colección tipo List.
	 */
	public List<Empleado> ordenaSalarioNeto() {
		List<Empleado> empleadosOrdenados = new ArrayList<>(this.empleadosEmpresa);
		empleadosOrdenados.sort(new ComparatorSalarioNeto());
		return empleadosOrdenados;
	}

	/**
	 * Método toStringListaOrdenadaSalario, que nos devuelva una cadena con la colección anterior,
	 * similar al toString.
	 */
	public String toStringListaOrdenadaSalario() {
		String cadena = "EMPLEADOS DE LA EMPRESA\n\t";

		for (Empleado empleado : ordenaSalarioNeto()) {
			cadena += empleado.toStringLineal() + "\n\t";
		}

		return cadena;
	}

	/**
	 * Método agregarPlus, que nos permita añadir un determinado plus a todos los empleados de la
	 * empresa que estén a tiempo completo.
	 */
	public void agregarPlus(EnumPlus plus) {
		for (Empleado e : empleadosEmpresa) {
			if (e instanceof EmpleadoTiempoCompleto) {
				((EmpleadoTiempoCompleto) e).añadirPlus(plus);
			}
		}
	}

	/**
	 * Método que permite convertir Empleados a Empleados a tiempo completo.
	 * 
	 * Ayuda: Tendréis que sacar los empleados a modificar a una nueva colección temporal, donde ya los guardaréis como
	 * Empleados a tiempo completo, después tendréis que borrarlos de la colección original, y por último, añadir los
	 * empleados desde la colección temporal, a la colección original de empleados. No podréis hacerlo todo “a la vez sobre
	 * la colección original”, porque os dará la excepción java.util.ConcurrentModificationException, ya que no se puede
	 * borrar y modificar una colección de manera simultánea dentro de un iterador.
	 */
	public void convertirATiempoCompleto() {
		List<EmpleadoTiempoCompleto> coleccionTemporal = new ArrayList<>();

		for (Empleado elemento : empleadosEmpresa) {
			if (!(elemento instanceof EmpleadoTiempoCompleto)) {
				coleccionTemporal.add(new EmpleadoTiempoCompleto(elemento.getNombre(), elemento.getFechaNacimiento(),
						elemento.getCategoriaProfesional(), elemento.getNumHijos(), 0)); 
			}
		}

		// Borrar antiguos
		empleadosEmpresa.removeIf(e -> !(e instanceof EmpleadoTiempoCompleto));

		// Añadir los nuevos
		empleadosEmpresa.addAll(coleccionTemporal);
	}
}
