package ejercicio6;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibreriaFechas {
	
	/**
	 * M�todo que permite cambiar el d�a de una fecha
	 * @param fecha
	 * @return
	 */
	public static void setDia(Calendar fecha, int nuevoDia) {
		fecha.set(Calendar.DAY_OF_MONTH, nuevoDia);
	}
	
	/**
	 * M�todo que permite cambiar el mes de una fecha
	 * @param fecha
	 * @param nuevoMes
	 */
	public static void setMes(Calendar fecha, int nuevoMes) {
		fecha.set(Calendar.MONTH, nuevoMes);
	}

	/**
	 * M�todo que permite cambiar el a�o de una fecha
	 * @param fecha
	 * @param nuevoA�o
	 */
	public static void setAño(Calendar fecha, int nuevoAño) {
		fecha.set(Calendar.YEAR, nuevoAño);
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
	 * M�todo que recibe una fecha tipo Calendar y la devuelve la fecha en formato corto con 4 digitos para el a�o:
	 *    Ejemplo: 09/10/2015)
	 */
	public static String getFechaShort2(Calendar fechaCalendar) {
		SimpleDateFormat formatoFecha = 
			new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
		return formatoFecha.format(fechaCalendar.getTime());
	}
	
	/**
	 * M�todo que comprueba si una fecha que llega como String (dd/mm/aaaa) es 
	 * correcta o no
	 */
	public static boolean esFechaCorrecta(String fecha) 
	{
	   try {
		SimpleDateFormat formatoFecha = 
			new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
			
		// El m�todo setLenient a false obliga a que la fecha 
		// "tenga sentido estricto", y por lo tanto rechaza un 
		// "30 de febrero" o un "29 de febrero de 2007" como fechas v�lidas.
		// 	Si no establecemos el lenient a false, al parsear una fecha 
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
	 */
	public static Calendar convierteFechaStringACalendar(String fechaCadena) {

		Calendar fechaCalendar = Calendar.getInstance();
		SimpleDateFormat formatoFecha =
					new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault()); 
		Date fechaDate=null;
		try {
			formatoFecha.setLenient(false);   // Probar a quit�rselo, y pasarle la fecha 29/02/2015"
			fechaDate = formatoFecha.parse(fechaCadena);
			fechaCalendar.setTime(fechaDate);
		} catch (ParseException e) {
			System.out.println("Error de parseo");
		} catch (NullPointerException e) {
			System.out.println("Puntero nulo");
		}
			
		return fechaCalendar;
	}
	
	/**
	 * Este m�todo se encarga de sumar a "fecha", los d�as indicados
	 * @param fecha
	 * @param dias
	 */
	public static void sumaDias(Calendar fecha, int dias) {
		fecha.add(Calendar.DATE, dias);
	}
	
/*	public static Calendar sumaDias(Calendar fecha, int dias) {
		Calendar fechaNueva = copiaFecha(fecha);
		fechaNueva.add(Calendar.DATE, dias);
		return fechaNueva;
	}
	*/
	
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
	
	public static Calendar copiaFecha2(Calendar fecha) {
		return (Calendar) fecha.clone();
	}
	

	/**
	 * M�todo que a partir de dos fechas en formato calendar, devuelve el n�mero de d�as
	 * transcurrido entre ellas
	 */
	public static int getRestaFechas(Calendar f1, Calendar f2) {
	
		//Obtengo los objetos Date para cada una de ellas
		Date fec1 = f1.getTime();
		Date fec2 = f2.getTime();
	
		//Realizo la operaci�n
		long time = Math.abs(fec2.getTime() - fec1.getTime());
	
		//Muestro el resultado en d�as
		return (int)(time/(3600*24*1000));
	}
	
	
	/**
	 * Otra forma de hacerlo, aunque as� no funciona bien, ya que si le pongo el
	 * 29/02/1999 (fecha inexistente), devuelve el 29/03/1999. 
	 */
	public static Calendar getFechaCalendar2(String fecha){
		StringTokenizer fechaST = new StringTokenizer(fecha);
		int dia = Integer.parseInt(fechaST.nextToken("/"));
		int mes = Integer.parseInt(fechaST.nextToken("/"));
		int año = Integer.parseInt(fechaST.nextToken("/"));
		GregorianCalendar gc = new GregorianCalendar(año, mes, dia);
		return gc;
	}
	
	/**
	 * M�todo que convierte una hora en formato String a objeto Calendar
	 * @param horaString
	 * @return
	 */
	public static Calendar convierteHoraStringACalendar(String horaString) {

		Calendar hora = Calendar.getInstance();
		SimpleDateFormat formatoHora =
				new SimpleDateFormat("HH:mm:ss",Locale.getDefault()); 

		Date horaDate=null;
		try {
			formatoHora.setLenient(false);
			horaDate = formatoHora.parse(horaString);
			hora.setTime(horaDate); 
		} catch (ParseException e) {
			System.out.println("Formato de hora no v�lido");
		}
		return hora;
	}
	
	/**
	 * M�todo que devuelve la forma de la visita formateada
	 * @return
	 */
	public static String toStringHora(Calendar hora) {
		DecimalFormat patron = new DecimalFormat("00");
		return patron.format(hora.get(Calendar.HOUR_OF_DAY))+":"+
			   patron.format(hora.get(Calendar.MINUTE))+":"+
			   patron.format(hora.get(Calendar.SECOND));
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
