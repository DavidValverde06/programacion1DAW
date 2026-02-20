package desdeJava8;

import java.time.*;

public class Ejemplo7PruebasVarias {

	public static void main(String[] args) {

		// -------------------------------------------------------------------------
		// Prueba de método of
		// Creación de una fecha con LocalDate 
		LocalDate navidad;
		navidad = LocalDate.of(2021, 12, 25);
		System.out.println("Navidad: "+navidad);

			
		// ----------------------------------------------------
		// Prueba de método from
		LocalDateTime ahora;
		ahora = LocalDateTime.now();
		System.out.println("Fecha y hora actual: "+ahora);
		
		// Transforma en LocalDate con pérdida de hora
		LocalDate hoy;
		hoy = LocalDate.from(ahora);
		System.out.println("Fecha actual: "+hoy);

		
		// ----------------------------------------------------
		// Prueba de parse
		LocalTime reloj;
		reloj = LocalTime.parse("22:45:03");
		System.out.println("Hora: "+reloj);
		
		// ----------------------------------------------------
		// Prueba de with
		LocalTime nuevaHora = reloj.withHour(9);
		System.out.println("Hora modificada: "+nuevaHora);
		
		
		// ----------------------------------------------------
		// Prueba de plus y minus
		LocalDate pascua = LocalDate.of(2021, 4, 20);
		LocalDate ascension = pascua.plusDays(39);
		System.out.println("Pascua: "+pascua);
		System.out.println("Ascensión: "+ascension);
		
		
		// ----------------------------------------------------
		// Prueba de at
		LocalDate diaPartido = LocalDate.of(2020, 7, 13);
		LocalTime horaPartido = LocalTime.of(21, 00);
		LocalDateTime fin = diaPartido.atTime(horaPartido);
		
		System.out.println("Partido: "+fin);
		
		
		
	}

}
