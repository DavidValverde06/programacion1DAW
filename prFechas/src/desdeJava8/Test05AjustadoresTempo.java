package desdeJava8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Test05AjustadoresTempo {

	public static void main(String[] args) {
		// Fecha actual
        LocalDate today = LocalDate.now();
        System.out.println("Hoy: " + today);

        // Primer día del mes
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("Primer día del mes: " + firstDayOfMonth);

        // Último día del mes
        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Último día del mes: " + lastDayOfMonth);

        // Siguiente lunes
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Siguiente lunes: " + nextMonday);

        // Último viernes del mes
        LocalDate lastFriday = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println("Último viernes del mes: " + lastFriday);

        
        // Ajustador personalizado: Avanzar 10 días
        TemporalAdjuster addTenDays = temporal -> temporal.plus(10, java.time.temporal.ChronoUnit.DAYS);

        LocalDate futureDate = today.with(addTenDays);

        System.out.println("Hoy: " + today);
        System.out.println("En 10 días: " + futureDate);
	}

}
