package trabajadores;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestTrabajadoresEmpresa {

	public static void main(String[] args) {

		Empleado empleado1 = new Empleado("Pepe García", LocalDate.of(1997, 4, 29), EnumCategoria.PROGRAMADOR_JUNIOR, 0);
		Empleado empleado2 = new Empleado("Juan López", LocalDate.of(1990, 7, 16), EnumCategoria.ANALISTA, 2);

		List<EnumPlus> plusesEmpleada3 = Arrays.asList(EnumPlus.BENEFICIOS_EXTRAS, EnumPlus.FORMACION);
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

		SortedSet<Empleado> empleados = new TreeSet<>();
		empleados.add(empleado1);
		empleados.add(empleado2);
		empleados.add(empleado3);
		empleados.add(empleado4);
		empleados.add(empleado5);
		empleados.add(empleado6);


		Empresa empresa1 = new Empresa(empleados);
		
		System.out.println("\n" + empresa1);
	}

}
