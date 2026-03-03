package trabajadores;

import java.time.LocalDate;
import java.util.*;

public class TestTrabajadoresEmpresa {

	public static void main(String[] args) {

		Empleado empleado1 = new Empleado("Pepe García", LocalDate.of(1997, 4, 29), EnumCategoria.PROGRAMADOR_JUNIOR, 0);
		Empleado empleado2 = new Empleado("Juan López", LocalDate.of(1990, 7, 16), EnumCategoria.ANALISTA, 2);

		List<EnumPlus> plusesEmpleada3 = new ArrayList<>(Arrays.asList(EnumPlus.BENEFICIOS_EXTRAS, EnumPlus.FORMACION));
		EmpleadoTiempoCompleto empleado3 = new EmpleadoTiempoCompleto("María Ríos", LocalDate.of(1985, 9, 18), EnumCategoria.JEFE_DE_EQUIPO, 3, 3, plusesEmpleada3);
		EmpleadoTiempoCompleto empleado4 = new EmpleadoTiempoCompleto("Lorena Montilla", LocalDate.of(2000, 5, 14), EnumCategoria.PROGRAMADOR_JUNIOR, 0, 1);

		EmpleadoPorHoras empleado5 = new EmpleadoPorHoras("Luis González", LocalDate.of(2000, 12, 4), EnumCategoria.PROGRAMADOR_SENIOR, 0, 12);
		EmpleadoPorHoras empleado6 = new EmpleadoPorHoras("Martín Luque", LocalDate.of(1995, 10, 16), EnumCategoria.PROGRAMADOR_JUNIOR, 1, 120);

		System.out.println("=== Empleados ===");
		System.out.println(empleado1.toString());
		System.out.println("\n" + empleado1.toStringLineal());
		System.out.println("\n" + empleado2);

		System.out.println("\n=== Empleados a tiempo completo ===");
		System.out.println(empleado3);
		System.out.println("\n" + empleado4);

		System.out.println("\n=== Empleados por horas ===");
		System.out.println(empleado5);
		System.out.println("\n" + empleado6);

		// --- Crear empresa y añadir empleados ---
		SortedSet<Empleado> empleadosSet = new TreeSet<>();
		empleadosSet.add(empleado1);
		empleadosSet.add(empleado2);
		empleadosSet.add(empleado3);
		empleadosSet.add(empleado4);
		empleadosSet.add(empleado5);
		empleadosSet.add(empleado6);

		Empresa empresa1 = new Empresa(empleadosSet);

		System.out.println("\n=== Empresa inicial ===");
		System.out.println(empresa1);

		// --- Buscar empleados ---
		System.out.println("\n=== Buscar empleados ===");
		Empleado bus1 = empresa1.buscarEmpleado(empleado3);
		Empleado bus2 = empresa1.buscarEmpleado("Juan López", LocalDate.of(1990, 7, 16));
		System.out.println("Buscando por objeto: " + (bus1 != null ? bus1.toStringLineal() : "No encontrado"));
		System.out.println("Buscando por nombre y fecha: " + (bus2 != null ? bus2.toStringLineal() : "No encontrado"));

		// --- Borrar empleados ---
		System.out.println("\n=== Borrar empleados ===");
		empresa1.borrarEmpleado(empleado1);
		empresa1.borrarEmpleado("Martín Luque", LocalDate.of(1995, 10, 16));
		System.out.println("Empresa después de borrar Pepe y Martín:");
		System.out.println(empresa1);

		// --- Ordenar por salario neto ---
		System.out.println("\n=== Lista ordenada por salario neto ===");
		System.out.println(empresa1.toStringListaOrdenadaSalario());

		// --- Agregar plus a empleados a tiempo completo ---
		System.out.println("\n=== Agregar plus a empleados a tiempo completo ===");
		empresa1.agregarPlus(EnumPlus.BENEFICIOS_EXTRAS); // ejemplo
		System.out.println(empresa1);

		// --- Convertir empleados a tiempo completo ---
		System.out.println("\n=== Convertir empleados a tiempo completo ===");
		empresa1.convertirATiempoCompleto();
		System.out.println(empresa1);
	}
}
