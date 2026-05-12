package desdeJava8;

import java.time.*;
import java.time.temporal.ChronoField;

public class Ejemplo3LocalDateTime {
	
	public static void main(String[] args) {

		// ---------------------- CREACION DE OBJETO ---------------------------------------
		// La clase LocalDateTime permite crear una fecha/hora  haciendo
		// uso de todos los campos (año, mes, día, hora, minuto, segundo, nanosegundo)
		LocalDateTime miDateTime = LocalDateTime.of(1989, 11, 11, 5, 30, 45, 35); //1989-11-11T05:30:45.000000035
		System.out.println(miDateTime);
		
		// También, se puede crear un objeto LocalDateTime basado en los tipos LocalDate y LocalTime,
		LocalDate date = LocalDate.of(1989, 11, 11);
		LocalTime time = LocalTime.of(5, 30, 45, 35);
		LocalDateTime miDateTime2 = LocalDateTime.of(date, time);
		System.out.println(miDateTime2);
		
		// DateTime actual
		LocalDateTime miDateTime3 = LocalDateTime.now();
		System.out.println(miDateTime3+"\n");
		
		
		// ----------------------  MODIFICACION DE OBJETO ---------------------------------------
		// Modificando un LocalDateTime
		LocalDateTime dateTime = LocalDateTime.of(2016, Month.JULY, 25, 22, 11, 30);
		System.out.println(dateTime);
		LocalDateTime dateTime1 = dateTime.withYear(2017);
		System.out.println(dateTime1);
		LocalDateTime dateTime2 = dateTime.withMonth(8);
		System.out.println(dateTime2);
		LocalDateTime dateTime3 = dateTime.withDayOfMonth(27);
		System.out.println(dateTime3);
		LocalDateTime dateTime4 = dateTime.withHour(20);
		System.out.println(dateTime4);
		LocalDateTime dateTime5 = dateTime.withMinute(25);
		System.out.println(dateTime5);
		LocalDateTime dateTime6 = dateTime.withSecond(23);
		System.out.println(dateTime6);
		LocalDateTime dateTime7 = dateTime.withNano(24);
		System.out.println(dateTime7);
		LocalDateTime dateTime8 = dateTime.with(ChronoField.HOUR_OF_DAY, 23);
		System.out.println(dateTime8);
	}
}
