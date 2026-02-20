package desdeJava8;

import java.time.LocalDate;
import java.time.Month;

public class TestLibreria {

	public static void main(String[] args) {
		
		// -------------------------------------------------------------------
		// Prueba del método de validación de fechas
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("12/10/2020"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("32/10/2020"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("29/02/2021"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("29/02/2020"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("hola"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("31/09/2020"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("30/09/2020"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("30/09/20"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("30-09-2020"));
		System.out.println(LibreriaFechasJava8.isFechaCorrecta("30/11"));
	
		
		// -------------------------------------------------------------------
		// Prueba del método de conversión de String a LocalDate
		System.out.println(LibreriaFechasJava8.convierteStringToLocalDate("24/12/2019"));
		System.out.println(LibreriaFechasJava8.convierteStringToLocalDate("32/12/2019"));
		System.out.println(LibreriaFechasJava8.convierteStringToLocalDate("29/02/2021"));
		System.out.println(LibreriaFechasJava8.convierteStringToLocalDate("29/02/2020"));
		
		// -------------------------------------------------------------------
		// Prueba de los métodos de formateo personalizado de la salida de la fecha
		LocalDate fecha = LocalDate.of(1991, Month.OCTOBER, 5);
		System.out.println("Fecha: "+ LibreriaFechasJava8.getFechaFull(fecha));
		System.out.println("Fecha: "+ LibreriaFechasJava8.getFechaShort(fecha));
		
		System.out.println("Fecha: "+ LibreriaFechasJava8.getFechaFull(
							LibreriaFechasJava8.convierteStringToLocalDate("24/12/2019")));
		
		System.out.println("Fecha: "+ LibreriaFechasJava8.getFechaShort(
				LibreriaFechasJava8.convierteStringToLocalDate("24/12/2019")));

		System.out.println("Fecha: "+ LibreriaFechasJava8.getFechaFull(
				LibreriaFechasJava8.convierteStringToLocalDate("24/14/2019")));
		
		System.out.println("Fecha: "+ LibreriaFechasJava8.getFechaShort(
				LibreriaFechasJava8.convierteStringToLocalDate("24/14/2019")));
		
		
		// -------------------------------------------------------------------
		// Método que calcula la edad de una persona
		System.out.println("Edad: "+LibreriaFechasJava8.getEdad(fecha));
		System.out.println("Edad: "+LibreriaFechasJava8.getEdad(LocalDate.of(1987, 05, 17)));
	}

}
