package desdeJava8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Test03 {

	public static void main(String[] args) {
		// Creación
        LocalDate date = LocalDate.of(2025, 1, 16);
        LocalDateTime dateTime = LocalDateTime.now();

        // Modificación
        LocalDate nextWeek = date.plusWeeks(1);
        LocalDate firstDayOfMonth = date.withDayOfMonth(1);

        // Formato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);

        // Comparación
        boolean isBefore = date.isBefore(LocalDate.of(2025, 12, 31));

        // Impresión
        System.out.println("Fecha original: " + date);
        System.out.println("Fecha formateada: " + formattedDate);
        System.out.println("Fecha dentro de una semana: " + nextWeek);
        System.out.println("Primer día del mes: " + firstDayOfMonth);
        System.out.println("¿La fecha es antes de fin de año? " + isBefore);
	}

}
