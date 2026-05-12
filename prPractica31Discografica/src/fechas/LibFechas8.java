package fechas;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LibFechas8 {

	
	/**
	 * Este método convierte una fecha en formato String a LocalDate
	 * 
	 * @param fechaString
	 * @return La fecha como objeto LocalDate, o un valor null, si su formato
	 *         no era válido
	 */
	public static LocalDate convierteStringToLocalDate(String fechaString) {
		
		
		try {
		   String [] arrayFecha = fechaString.split("/"); // Extraigo el día, mes y año
			
		   LocalDate fecha = LocalDate.of(
	  			    Integer.parseInt(arrayFecha[2]),  // Año
	  			    Integer.parseInt(arrayFecha[1]),  // Mes 
				 	Integer.parseInt(arrayFecha[0])); // Día 
	  	  
	  	   		 // Si la fecha no es válida el método of, lanzará una excepción (DateTimeException)
	  	         // Si la fecha no tenía el formato dd/mm/yyyy, saltará la excepción
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
			// El método convierteStringToLocalDate, es un método propio, que devuelve
			// null, si la fecha no es válida, o no tiene el formato adecuado
			if (convierteStringToLocalDate(fechaString)==null)
				return false;
			
			LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("d/M/yyyy")); 
			  // Si el formato no es el esperado, el m�todo parse lanzará una excepcion (DateTimeParseExcepcion)
			  // Lleva solo una d y una M, para que admita también 3/2/2022, sino esta fecha
			  // no sería válida y sólo admitiría 03/02/2022
		}

		catch (DateTimeParseException e) {  // Esta saltará con fechas como "12/10/20" 
		//	System.out.println("Formato incorrecto "+fechaString);
			return false;
		}

		return true;
	}
	
	/*
	 * Esta versión no funciona bien, ya que si le paso, por ejemplo 31/09/2020
	 * me da la fecha por valida, ya que me cambia el 31 por 30 ¿?
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
	 * Método que devuelve una fecha formateada en formato corto 
	 * Ejemplo: 15/09/2008
	 * 
	 * @param fecha --> Se supone que la fecha es correcta, se habrá
	 *                  validado previamente, si llega a null, se devuelve 
	 *                  la cadena vacía
	 * @return
	 */
	public static String getFechaShort(LocalDate fecha) {
		
		if (fecha == null) return "";
	    return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	/**
	 * Metodo que devuelve una fecha formateada en formato largo 
	 * Ejemplo: 15/09/2008
	 * 
	 * @param fecha --> Se supone que la fecha es correcta, se habra 
	 *                  validado previamente, si llega a null, se devuelve 
	 *                  la cadena vacia
	 * @return
	 */
	public static String getFechaFull(LocalDate fecha) {
		
		if (fecha == null) return "";
	    return fecha.format(DateTimeFormatter.ofPattern("EEEE',' d 'de' MMMM 'de' yyyy"));

	}
	
	
	/**
	 * Metodo que calcula la edad de una persona
	 * @param fechaNacimiento
	 * @return
	 */
	public static int getEdad(LocalDate fechaNacimiento) {
			
	   return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	   
	}
	
	/**
	 * Metodo que suma un numero de dias a una fecha que llega como par�metro
	 * @param fechaInicio
	 * @param dias
	 * @return
	 */
	public static LocalDate sumaDias(LocalDate fechaInicio, int dias) {
		return fechaInicio.plusDays(dias);
	}
	
	
	/**
	 * Método que devuelve una colección con objetos de tipo LocalDate con 
	 * los días de una semana de un determinado año
	 * @param numSemana
	 * @param año
	 * @return
	 */
	public static List<LocalDate> getDiasSemana(int numSemana, int año) {

		LocalDate fechaInicioSemana = LocalDate.ofYearDay(año, 1)
				.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)) // Ir al lunes de la semana 1
				.plusWeeks(numSemana - 1); // Mover a la semana deseada

		List<LocalDate> diasSemana = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			diasSemana.add(fechaInicioSemana.plusDays(i));
		}

		return diasSemana;
	}
	
	/**
	 * Obtener el número de semana en el año, a partir de un objeto LocalDate
	 * @param fecha
	 * @return
	 */
	public static int getNumeroSemana(LocalDate fecha) {
		// Configurar el campo de la semana según el estándar ISO y el idioma inglés
		WeekFields weekFields = WeekFields.of(Locale.getDefault());

		// Obtener el número de la semana
		int numeroSemana = fecha.get(weekFields.weekOfWeekBasedYear());

		return numeroSemana;
	}
	
	
	/**
	 * Método que devuelve una cadena con el AñoMesDiaMinutoSegundo
	 * @param fecha
	 * @return
	 */
	public static String getFechaSinDelimitadores(LocalDateTime fecha) {
		DecimalFormat patron = new DecimalFormat("00");
		
		return "" +
		       fecha.getYear()+
			   patron.format(fecha.getMonthValue()) +
			   patron.format(fecha.getDayOfMonth()) +
			   patron.format(fecha.getMinute()) +
			   patron.format(fecha.getSecond());
	}

	/**
	 * M�todo que transforma una fecha leida en formato aaaa-mm-dd a dd/mm/aaaa
	 * Se utiliza cuando recuperamos fechas de una BD, que nos la devuelve en ese formato
	 * 
	 * @param fecha -- > aaaa-mm-dd
	 * @return --> dd/mm/aaaa
	 */
	public static String transformaFecha(String fecha) {
		
		String [] arrayFecha = fecha.split("-"); 
		
		String nuevaFecha = arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0];
	
		return nuevaFecha;
	}
	
}


