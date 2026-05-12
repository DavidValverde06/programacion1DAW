package desdeJava8;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class Ejemplo1LocalDate {
	public static void main(String[] args) {
		
		// ---------------------- CREACION DE OBJETO ---------------------------------------
		LocalDate miCumple = LocalDate.of(2019, 10, 17); // 17 de octubre de 2019
		System.out.println("Año: "+miCumple.getYear());       // 2019
		System.out.println("Mes: "+miCumple.getMonth());      // Octubre
		System.out.println("Día: "+miCumple.getDayOfMonth()); // 17
		
		// Podemos usar la enum Month para dar legibilidad al código
		LocalDate miCumple2 = LocalDate.of(2019, Month.OCTOBER, 17); 
		System.out.println("Mi cumpleaños: "+miCumple2);
		
		// Obtener la fecha actual
		LocalDate hoy = LocalDate.now();
		System.out.println("Fecha actual: "+hoy);
		
		
		// ----------------------  MODIFICACION DE OBJETO ---------------------------------------
		// Modificar un LocalDate
		LocalDate date = LocalDate.of(2016, Month.JULY, 25); //2016-07-25
		System.out.println(date);
		LocalDate date1 = date.withYear(2017); //2017-07-25
		System.out.println(date1);
		LocalDate date2 = date.withMonth(8); //2016-08-25
		System.out.println(date2);
		LocalDate date3 = date.withDayOfMonth(27); //2016-07-27
		System.out.println(date3);
		LocalDate date4 = date.with(ChronoField.MONTH_OF_YEAR, 9); //2016-09-25
		System.out.println(date4);
		LocalDate date5 = date.with(ChronoField.YEAR, 2022); 
		System.out.println(date5);

	}
}
