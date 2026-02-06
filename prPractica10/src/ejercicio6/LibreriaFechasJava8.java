package ejercicio6;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class LibreriaFechasJava8 {

	
	/**
	 * Este m�todo convierte una fecha en formato String a LocalDate
	 * 
	 * @param fechaString
	 * @return La fecha como objeto LocalDate, o un valor null, si su formato
	 *         no era v�lido
	 */
	public static LocalDate convierteStringToLocalDate(String fechaString) {
		
		
		try {
		   String [] arrayFecha = fechaString.split("/"); // Extraigo el d�a, mes y a�o
			
		   LocalDate fecha = LocalDate.of(
	  			    Integer.parseInt(arrayFecha[2]),  // A�o
	  			    Integer.parseInt(arrayFecha[1]),  // Mes 
				 	Integer.parseInt(arrayFecha[0])); // D�a 
	  	  
	  	   		 // Si la fecha no es v�lida el m�todo of, lanzar� una excepci�n (DateTimeException)
	  	         // Si la fecha no ten�a el formato dd/mm/yyyy, saltar� la excepci�n
	  	         // de array desbordado
	  	   
		   return fecha;
		}
		catch (DateTimeException e) {
//			System.out.println("Fecha incorrecta "+fechaString);
			return null;
			//return LocalDate.now();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			//	System.out.println("Menos datos de los esperados "+fechaString);
			return null;
			//return LocalDate.now();
		}
		catch (NullPointerException e) {
			return null;
		}
		catch (NumberFormatException e) {
			return null;
		}
	}
	
	
	/**
	 * M�todo que comprueba si una fecha es correcta, consideraremos
	 * fechas correctas las que tenga el formato dd/mm/yyyy
	 * @param fecha
	 * @return
	 */
	public static boolean isFechaCorrecta(String fechaString) {
 		
		try{
			// El m�todo convierteStringToLocalDate, es un m�todo propio, que devuelve
			// null, si la fecha no es v�lida, o no tiene el formato adecuado
			if (convierteStringToLocalDate(fechaString)==null)
				return false;
			
			LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("d/M/yyyy")); 
			  // Si el formato no es el esperado, el m�todo parse lanzar� una excepcion (DateTimeParseExcepcion)
			  // Lleva solo una d y una M, para que admita tambi�n 3/2/2022, sino esta fecha
			  // no ser�a v�lida y s�lo admitir�a 03/02/2022
		}

		catch (DateTimeParseException e) {  // Esta saltar� con fechas como "12/10/20" 
		//	System.out.println("Formato incorrecto "+fechaString);
			return false;
		}

		return true;
	}
	
	/*
	 * Esta versi�n no funciona bien, ya que si le paso, por ejemplo 31/09/2020
	 * me da la fecha por v�lida, ya que me cambia el 31 por 30 �?
	 * public static boolean isFechaCorrecta(String fechaString) {
	 		
		try {
			LocalDate fecha = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println(fecha);
		}
		catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	*/
	
	/**
	 * M�todo que devuelve una fecha formateada en formato corto 
	 * Ejemplo: 15/09/2008
	 * 
	 * @param fecha --> Se supone que la fecha es correcta, se habr� 
	 *                  validado previamente, si llega a null, se devuelve 
	 *                  la cadena vac�a
	 * @return
	 */
	public static String getFechaShort(LocalDate fecha) {
		
		if (fecha == null) return "";
	    return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	/**
	 * M�todo que devuelve una fecha formateada en formato largo 
	 * Ejemplo: 15/09/2008
	 * 
	 * @param fecha --> Se supone que la fecha es correcta, se habr� 
	 *                  validado previamente, si llega a null, se devuelve 
	 *                  la cadena vac�a
	 * @return
	 */
	public static String getFechaFull(LocalDate fecha) {
		
		if (fecha == null) return "";
	    return fecha.format(DateTimeFormatter.ofPattern("EEEE',' d 'de' MMMM 'de' yyyy"));

	}
	
	
	/**
	 * M�todo que calcula la edad de una persona
	 * @param fechaNacimiento
	 * @return
	 */
	public static int getEdad(LocalDate fechaNacimiento) {
			
	   return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	   
	}
	
	/**
	 * M�todo que suma un n�mero de d�as a una fecha que llega como par�metro
	 * @param fechaInicio
	 * @param dias
	 * @return
	 */
	public static LocalDate sumaDias(LocalDate fechaInicio, int dias) {
		return fechaInicio.plusDays(dias);
	}
}
