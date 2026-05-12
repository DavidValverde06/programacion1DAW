package desdeJava8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Test02 {

	public static void main(String[] args) {
		// Fecha actual
        LocalDate today = LocalDate.now();
        System.out.println("Hoy es: " + today);

        // Hora actual
        LocalTime now = LocalTime.now();
        System.out.println("Hora actual: " + now);

        // Fecha y hora actuales
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Fecha y hora: " + currentDateTime);

        // Manipulación
        LocalDate nextMonth = today.plusMonths(1);
        System.out.println("Fecha dentro de un mes: " + nextMonth);
        
        System.out.println("Hoy es: " +LocalDate.now()
        										   .format(DateTimeFormatter
        											  .ofPattern("EEEE',' d 'de' MMMM 'de' yyyy")));

	}

}
