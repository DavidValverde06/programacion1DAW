package cualquierVersion;

import java.util.Calendar;

public class Test02_Calendar {

	public static void main(String[] args) {

		Calendar obCalendar = Calendar.getInstance(); // Obtiene la fecha y hora actual
        int year = obCalendar.get(Calendar.YEAR);
        int month = obCalendar.get(Calendar.MONTH) + 1; // Los meses comienzan en 0
        int day = obCalendar.get(Calendar.DAY_OF_MONTH);
        
        System.out.println("Fecha actual: " + day + "/" + month + "/" + year);
        
        // Sumar 10 días
        obCalendar.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println("Nueva fecha: " + obCalendar.get(Calendar.DAY_OF_MONTH) + "/" 
                           + (obCalendar.get(Calendar.MONTH) + 1) + "/" + obCalendar.get(Calendar.YEAR));
	}
}
