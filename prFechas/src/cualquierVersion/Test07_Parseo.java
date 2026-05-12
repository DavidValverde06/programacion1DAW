package cualquierVersion;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test07_Parseo {

	public static void main(String[] args) {
		
		// Crear un objeto calendar con la fecha actual
		Calendar obCalendar = GregorianCalendar.getInstance();
		
		// Crear un objeto date con los milisegundos de la fecha actual
		Date obDate = obCalendar.getTime(); 
	 	System.out.println("Fecha actual: " + obDate.toString());  
	  
	 	// Crear un objeto DateFormat para darle formato de salida a la fecha
	 	DateFormat obDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);  
	 	
	 	// Convertir a String el objeto DateFormat
	 	String fechaCadena = obDateFormat.format(obDate);  
	 	System.out.println("Fecha como String en formato corto: " + fechaCadena);
	 	
	 	try {  
	 		// Conversión de la fecha como String en Date
	 		Date obDate2 = obDateFormat.parse(fechaCadena);  // Parseo de la fecha
	 		System.out.println("Fecha parseada = " + obDate2.toString());  
	 		
	 		System.out.println("Otras fechas parseadas");
	 		System.out.println(obDateFormat.parse("16/11/25").toString());  // Este parseo es válido también
	 		System.out.println(obDateFormat.parse("16/11/2025").toString());  // Este parseo es válido también
	 		System.out.println(obDateFormat.parse("65/11/2025").toString()); 
	 			// Este parseo es válido también, al no estar el lenient activado, devuelve 04/01/2026
	 		
	 		obDateFormat.setLenient(false);
	 		System.out.println(obDateFormat.parse("65/11/2025").toString()); 
	 		    // Ahora ya no es válida y saltará el error de parseo
	 		
	 	} 
	 	catch (ParseException pe) {  
	 		System.out.println("Error de parseo");  
	 	}

	}

}
