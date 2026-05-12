package desdeJava8;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * Supongamos que estás trabajando con fechas y necesitas realizar cálculos específicos como encontrar
 * el último lunes del mes o el próximo viernes 13.
 */

public class Test06AjustadoresTempo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();

        // Último lunes del mes actual
        LocalDate lastMonday = today.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        System.out.println("Último lunes del mes: " + lastMonday);

        // Primer martes del mes siguiente
        LocalDate firstTuesdayNextMonth = today.with(TemporalAdjusters.firstDayOfNextMonth())
                                               .with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println("Primer martes del mes siguiente: " + firstTuesdayNextMonth);

        // Próximo viernes 13
        LocalDate nextFriday13 = today.with(temporal -> {
            LocalDate date = LocalDate.from(temporal);
            do {
                date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            } while (date.getDayOfMonth() != 13);
            return date;
        });
        System.out.println("Próximo viernes 13: " + nextFriday13);

	}

}
