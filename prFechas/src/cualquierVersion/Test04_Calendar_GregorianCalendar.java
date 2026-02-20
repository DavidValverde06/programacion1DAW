package cualquierVersion;

import java.util.*;

public class Test04_Calendar_GregorianCalendar {

	public static void main(String[] args) {

		// ----------------------------------------------------
		// Crear varios objeto de tipo Calendar
		// ----------------------------------------------------
		Calendar fec1 = GregorianCalendar.getInstance(); 
		Calendar fec2 = new GregorianCalendar();

		Calendar fec3 = new GregorianCalendar();
		fec3.setTime(new Date(1518188744443L));
		
		Calendar fec4 = new GregorianCalendar(2010, 9, 15);
		GregorianCalendar fec5 = new GregorianCalendar(2018, 3, 2);
		
		System.out.println("Fecha 1: "+fec1);
		
		System.out.println("Fecha 1: "+toString(fec1));  
		   // toString, es un método "provisional" que est� m�s abajo, para poder 
		   // visualizar en un formato legible la fecha
		
		System.out.println("Fecha 2: "+toString(fec2));
		System.out.println("Fecha 3: "+toString(fec3));
		System.out.println("Fecha 4: "+toString(fec4));
		System.out.println("Fecha 5: "+toString(fec5));
		
		// ----------------------------------------------------------
		// Probar varias de las constante que trae la Clase Calendar
		// ----------------------------------------------------------
		System.out.println("--------------");
		System.out.println("Era: "+fec1.get(Calendar.ERA));
		System.out.println("Year: "+fec1.get(Calendar.YEAR));
		System.out.println("Month: "+fec1.get(Calendar.MONTH));
		System.out.println("Dia del mes: "+fec1.get(Calendar.DAY_OF_MONTH));
		System.out.println("D de la S en mes:"
						       +fec1.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("No de semana: "+fec1.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Semana del mes: "+fec1.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Fecha: "+fec1.get(Calendar.DATE));
		System.out.println("Hora: "+fec1.get(Calendar.HOUR));
		System.out.println("Tiempo del dia: "+fec1.get(Calendar.AM_PM));
		System.out.println("Hora del dia: "+fec1.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minuto: "+fec1.get(Calendar.MINUTE));
		System.out.println("Segundo: "+fec1.get(Calendar.SECOND));
		System.out.println("Dif. horaria: "+fec1.get(Calendar.ZONE_OFFSET));
		
		
		// ----------------------------------------------------------
		// Calcular cuando fue nuestro cumpleaños en el año 2020
		// ----------------------------------------------------------
		Calendar fecCumple = new GregorianCalendar(2026,4,3);
		int diaCumple = fecCumple.get(Calendar.DAY_OF_WEEK);
		System.out.println("\nMi cumple en 2026 fue: "+
								fecCumple.get(Calendar.DAY_OF_WEEK)); 	
					// Día 1 es Sunday (Domingo)
		
		if (diaCumple==7)
			System.out.println("Sábado");
		
		if (diaCumple==Calendar.SATURDAY)
			System.out.println("Sábado\n");
		
		// ----------------------------------------------------------
		// Modificar los atributos o propiedades de una fecha
		// ----------------------------------------------------------
		// Cambiar el a�o de el cumple a 2017
		fecCumple.set(Calendar.YEAR, 2017);
		System.out.println("Mi cumple en 2017 fue: "+
				fecCumple.get(Calendar.DAY_OF_WEEK)); 	
		
		// Crear una nueva fecha con un valor no valido
		Calendar fec6 = new GregorianCalendar(2019,1,45); // 45/02/2019
		System.out.println("\nFecha 6:"+toString(fec6));
		
		fec6.set(Calendar.YEAR, 2018);
		fec6.set(Calendar.MONTH, 1);
		fec6.set(Calendar.DAY_OF_MONTH, 14);
		System.out.println("Fecha 6:"+toString(fec6));
		
		fec6.set(2001, 4, 15);
		System.out.println("Fecha 6:"+toString(fec6));
		
		
		// ----------------------------------------------------------
		// Sumar y restar valores a determinadas propiedades de una 
		// fecha, método add y roll (solo aumenta su propiedad)
		// ----------------------------------------------------------
		Calendar fec7 = new GregorianCalendar(2019, 1, 27);
		System.out.println("Fecha 7: "+toString(fec7));
		
		fec7.add(Calendar.DAY_OF_MONTH, 3);  // Sumar 3 días
		System.out.println("Fecha 7 (más 3 días): "+toString(fec7));
		
		fec7.add(Calendar.MONTH, 11); // Sumar 11 meses
		System.out.println("Fecha 7 (más 11 meses): "+toString(fec7));
		
		
		fec7.set(2020,1,27);
		System.out.println("Fecha 7: "+toString(fec7));
		fec7.roll(Calendar.DAY_OF_MONTH, 3);  // Sumar 3 días
		System.out.println("Fecha 7 (más 3 días): "+toString(fec7));
		
		fec7.roll(Calendar.MONTH, 11); // Sumar 11 meses
		System.out.println("Fecha 7 (más 11 meses): "+toString(fec7));
		
		
		// ----------------------------------------------------------
		// Calcular el tiempo entre dos fechas
		// ----------------------------------------------------------
		Calendar fechaActual = new GregorianCalendar();
		Calendar fechaUltimoDiaClase = new GregorianCalendar(2025,5,24);
		
		long diasRestantes = fechaUltimoDiaClase.getTime().getTime()
					             - fechaActual.getTime().getTime();

		long diasRestantes2 = fechaUltimoDiaClase.getTimeInMillis()
								 - fechaActual.getTimeInMillis();

		System.out.println("Quedan "+diasRestantes/(3600*24*1000)+" días ");
		System.out.println("Quedan "+diasRestantes2/(3600*24*1000)+" días ");
		
		
	}

	
	
	/**
	 * Método "provisional" para formatear la salida de una fecha
	 * más adelante usaremos la clase SimpleDateFormat 
	 * @param fecha
	 * @return
	 */
	public static String toString(Calendar fecha) {
		
		return fecha.get(Calendar.DAY_OF_MONTH) + "/" + 
			   (fecha.get(Calendar.MONTH) + 1) + "/" +
			   fecha.get(Calendar.YEAR);
	}
}









