package desdeJava8;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class Ejemplo2LocalTime {

	public static void main(String[] args) {
		
		// Haciendo uso del método of(), esta clase puede crear un LocalTime 
		// teniendo en cuenta la hora y minuto; hora, minuto y segundo y 
		// finalmente hora, minuto, segundo y nanosegundo.
		
		// ---------------------- CREACION DE OBJETO ---------------------------------------
		// Creación de una hora con hora, minutos, segundos y nanosegundos
		LocalTime hora = LocalTime.of(5, 30, 45, 35); //05:30:45:35
		System.out.println("Hora: "+hora.getHour()); //5
		System.out.println("Minutos: "+hora.getMinute()); //30
		System.out.println("Segundos: "+hora.getSecond()); //45
		System.out.println("Nanosegundos: "+hora.getNano()); //35
		System.out.println("Hora: "+hora);
		
		// Creación de una hora con hora y minutos
		LocalTime horaSalida = LocalTime.of(15, 0);
		System.out.println("Hora salida: "+horaSalida);
		
		// Creación de un objeto con la hora actual
		LocalTime horaActual = LocalTime.now();
		System.out.println("Hora actual: "+horaActual);
		
		
		// ----------------------  MODIFICACION DE OBJETO ---------------------------------------
		// Modificando un LocalTime
		LocalTime time = LocalTime.of(14, 30, 35); //14:30:35
		System.out.println(time);
		LocalTime time1 = time.withHour(20); //20:30:35
		System.out.println(time1);
		LocalTime time2 = time.withMinute(25); //14:25:35
		System.out.println(time2);
		LocalTime time3 = time.withSecond(23); //14:30:23
		System.out.println(time3);
		LocalTime time4 = time.withNano(24); //14:30:35.000000024
		System.out.println(time4);
		LocalTime time5 = time.with(ChronoField.HOUR_OF_DAY, 23); //23:30:35
		System.out.println(time5);
	}

}
