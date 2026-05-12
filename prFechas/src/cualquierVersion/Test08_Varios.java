package cualquierVersion;

import java.text.*;
import java.util.*;

public class Test08_Varios {

	public static void main(String[] args) {
		
		if (esFechaCorrecta("hola"))
			System.out.println("Fecha correcta");
		else
			System.out.println("Fecha incorrecta");

		if (esFechaCorrecta("10/08/2006"))
			System.out.println("Fecha correcta");
		else
			System.out.println("Fecha incorrecta");
		

		if (esFechaCorrecta("10-08-2006"))
			System.out.println("Fecha correcta");
		else
			System.out.println("Fecha incorrecta");
		
		if (esFechaCorrecta("29/02/2001"))
			System.out.println("Fecha correcta");
		else
			System.out.println("Fecha incorrecta");
		
	
	}
	
	/**
	 * M�todo que permite validar si una fecha es correcta o no
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaCorrecta(String fecha)
	{
		try {
			SimpleDateFormat formatoFecha =
					new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
			// El m�todo setLenient a false obliga a que la fecha
			// "tenga sentido estricto", y por lo tanto rechaza un
			// "30 de febrero" o un "29 de febrero de 2007" como fechas v�lidas.
			// Si no establecemos el lenient a false, al parsear una fecha
			// "interpretar�" la fecha correcta. Un "30 de febrero" se convertir�
			// en 1 marzo, (en 2 de marzo si es un a�o no bisiesto)...
			formatoFecha.setLenient(false);
			
			// El m�todo parse devuelve un objeto Date, por tanto si el String que
			// le llega no es una fecha correcta, bien por formato (Ej: 12/hola),
			// bien porque el d�a, mes o a�o sean incorrectos (Ej: 30/02/2011)
			// lanza una excepci�n del tipo ParseException
			formatoFecha.parse(fecha);
		}
		catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Convierte un fecha que llega en formato String a objeto Calendar
	 * @throws MiExcepcion 
	 */
	public static Calendar convierteFechaStringACalendar(String fechaCadena) 
			throws MiExcepcion {

		Calendar fechaCalendar = Calendar.getInstance(); 
		SimpleDateFormat formatoFecha =
					new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault()); 
		Date fechaDate=null;
		try {
			formatoFecha.setLenient(false);   // Probar a quit�rselo, y pasarle la fecha 29/02/2015"
			fechaDate = formatoFecha.parse(fechaCadena);
			fechaCalendar.setTime(fechaDate);
		} 
		catch (ParseException e) {
			throw new MiExcepcion("Error de parseo de fechas");
		} 
		catch (NullPointerException e) {
			throw new MiExcepcion("Valor nulo en fecha");
		}
			
		return fechaCalendar;
	}

	/**
	 * Convierte una fecha en formato Date a Calendar
	 * @param fechaDate
	 * @return
	 */
	public static Calendar convierteDateACalendar(Date fechaDate) {
		Calendar fechaCalendar = new GregorianCalendar();
		fechaCalendar.setTime(fechaDate);
		return fechaCalendar;
	}
	
	/**
	 * M�todo que recibe una fecha tipo Calendar y la devuelve la fecha en formato completo:
	 *    Ejemplo: domingo 9 de septiembre de 2001)
	 */
	public static String getFechaFull(Calendar fechaCalendar) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		return df.format(fechaCalendar.getTime());
	}
	
	
	/**
	 * M�todo que recibe una fecha tipo Calendar y la devuelve la fecha en formato corto:
	 *    Ejemplo: 09/10/15)
	 */
	public static String getFechaShort(Calendar fechaCalendar) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(fechaCalendar.getTime());
	}

	
	/**
	 * M�todo que recibe una fecha tipo Calendar y la devuelve la fecha en formato personalizado
	 *    Ejemplo: 09/10/2015)
	 */
	public static String getFechaPersonalizada(Calendar fechaCalendar) {
		SimpleDateFormat formatoFecha =
			new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault()); 
		
		return formatoFecha.format(fechaCalendar.getTime());
	}
	
	
	/**
	 * Este m�todo se encarga de sumar a "fecha", los d�as indicados
	 * @param fecha
	 * @param dias
	 */
	public static Calendar sumaDias(Calendar fecha, int dias) {
		Calendar fechaNueva = copiaFecha(fecha);
		fechaNueva.add(Calendar.DATE, dias);
		return fechaNueva;
	}
	
	
	/**
	 * Este m�todo nos permite crear un nuevo objeto tipo Calendar, a partir de 
	 * otro objeto Calendar ya existente
	 * @param fecha
	 * @return
	 */
	public static Calendar copiaFecha(Calendar fecha) {
		Calendar nuevaFecha = new GregorianCalendar();
		nuevaFecha.setTime(fecha.getTime());
		return nuevaFecha;
	}
	
	
	/**
	 * M�todo que calcula la edad de una persona
	 * @param fecNacim
	 * @return
	 */
	public static byte getEdad(Calendar fecNacim){
		
		Calendar fechaActual = Calendar.getInstance();
		
		// Restar los a�os de la fecha actual y de la fecha nacimiento
		byte años = (byte)(fechaActual.get(Calendar.YEAR) - fecNacim.get(Calendar.YEAR));
		
		// Si hay no ha llegado el d�a del cumple�aos, se resta un a�o
		byte mesCumple = (byte)fecNacim.get(Calendar.MONTH);
		byte mesActual = (byte)fechaActual.get(Calendar.MONTH);
		byte diaCumple = (byte)fecNacim.get(Calendar.DATE);
	    byte diaActual = (byte)fechaActual.get(Calendar.DATE);
	    
	    if ((mesActual < mesCumple) ||
	    		((mesActual==mesCumple) && (diaActual<diaCumple)))
	    	años--;
	    
		return años;
	}


}
