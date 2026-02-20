package cualquierVersion;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test03_GregorianCalendar {

	public static void main(String[] args) {
	
	//	GregorianCalendar obCalendar = new GregorianCalendar(2025, 0, 14);
		GregorianCalendar obCalendar = new GregorianCalendar(2025, Calendar.JANUARY, 14);
        
        System.out.println("Año: " + obCalendar.get(Calendar.YEAR));
        System.out.println("Mes: " + (obCalendar.get(Calendar.MONTH) + 1)); // Mes comienza en 0
        System.out.println("Día: " + obCalendar.get(Calendar.DAY_OF_MONTH));
        
        // Verificar si es un año bisiesto
        if (obCalendar.isLeapYear(obCalendar.get(Calendar.YEAR))) {
            System.out.println("Es un año bisiesto.");
        } 
        else {
            System.out.println("No es un año bisiesto.");
        }
        
	}

	
	
}
