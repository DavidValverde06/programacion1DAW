package cualquierVersion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Test06_DateFormat {

	public static void main(String[] args) {
	
		// ------------------------------------------------------------
		// Prueba de DateFormat
		// ------------------------------------------------------------
		Date d1 = new Date(1000000000000L);
		Calendar fec1 = new GregorianCalendar();

		// Crea un array donde guardaremos los distintos formatos 
		// de mostrar fechas
		DateFormat[] arrayFormatosFechas = new DateFormat[6];
		arrayFormatosFechas[0] = DateFormat.getInstance();
		arrayFormatosFechas[1] = DateFormat.getDateInstance();
		arrayFormatosFechas[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		arrayFormatosFechas[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		arrayFormatosFechas[4] = DateFormat.getDateInstance(DateFormat.LONG);
		arrayFormatosFechas[5] = DateFormat.getDateInstance(DateFormat.FULL);
		
		// Recorrer el array anterior, para mostrar las fechas en distintos formatos
		for(DateFormat df: arrayFormatosFechas) {
	
			System.out.println(df.format(fec1.getTime()));
	
		}
		
		// Prueba de nuestro método getFechaStringFull
		Calendar fec2 = new GregorianCalendar(2012, 5, 30);
		System.out.println("Fecha 2: "+getFechaStringFull(fec2));
		System.out.println("Fecha actual: "+getFechaStringFull(new GregorianCalendar()));
		
		
		// ------------------------------------------------------------
		// Prueba de SimpleDateFormat
		// ------------------------------------------------------------
		Date hoy = new Date();
		
		// Primera prueba, almacena en "salida", la fecha y hora actuales
		// según el formato del patron especificado
		String patron = "EEEE dd-MMM-yyyy, HH:mm:ss";
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		String salida = formato.format(hoy);
		System.out.println("\nFecha según patrón especificado: " + salida);
		
		// Segunda prueba, almacenan en sFecha y sHora la fecha y hora seg�n el
		// formato local predeterminado
		String sFecha, sHora;
		DateFormat formato1;
		formato1 = DateFormat.getDateInstance();
		sFecha = formato1.format(hoy);
		formato1 = DateFormat.getTimeInstance();
		sHora = formato1.format(hoy);
		System.out.println("Fecha: " + sFecha);
		System.out.println("Hora: " + sHora);
		
		// Prueba de nuestro m�todo para formatear de forma personalizada 
		// una fecha
		Calendar fec3 = new GregorianCalendar(2012, 5, 30);
		System.out.println("Fecha 2: "+getFechaStringPersonalizada1(fec3));
		System.out.println("Fecha actual: "+getFechaStringPersonalizada2(new GregorianCalendar()));
	
	}
	
	
	/**
	 * M�todo que recibe una fecha tipo Calendar y la devuelve la fecha
	 * en formato completo:
	 *    Ejemplo: domingo 9 de septiembre de 2001)
	 */
	public static String getFechaStringFull(Calendar fechaCalendar) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		return df.format(fechaCalendar.getTime());
	}
	
	/**
	 * M�todo que recibe una fecha tipo Calendar y la devuelve con
	 * un patr�n que yo estoy personalizando con la ayuda de la clase 
	 * SimpleDateFormat
	 * 
	 * @param fechaCalendar
	 * @return
	 */
	public static String getFechaStringPersonalizada1(Calendar fechaCalendar) {
		SimpleDateFormat formato = 
			new SimpleDateFormat("'Hola hoy es' EEEE, dd 'de' MMMM 'de' yyyy, HH:mm:ss");
		
		return formato.format(fechaCalendar.getTime());
	}
	
	public static String getFechaStringPersonalizada2(Calendar fechaCalendar) {
		SimpleDateFormat formato = new SimpleDateFormat("EEEE dd-MMM-yyyy, HH:mm:ss");
		return formato.format(fechaCalendar.getTime());
	}
	
}



