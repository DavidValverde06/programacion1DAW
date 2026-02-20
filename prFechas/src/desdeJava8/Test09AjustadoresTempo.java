package desdeJava8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Imagina que necesitas programar reportes que deben ser generados el último día hábil de cada mes.
 */
public class Test09AjustadoresTempo {

	public static void main(String[] args) {
		 LocalDate today = LocalDate.now();

	        // Último día hábil del mes
	        LocalDate lastBusinessDay = today.with(TemporalAdjusters.lastDayOfMonth());
	        if (lastBusinessDay.getDayOfWeek() == DayOfWeek.SATURDAY) {
	            lastBusinessDay = lastBusinessDay.minusDays(1); // Retroceder a viernes
	        } else if (lastBusinessDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
	            lastBusinessDay = lastBusinessDay.minusDays(2); // Retroceder a viernes
	        }

	        System.out.println("Último día hábil del mes: " + lastBusinessDay);
	}

}
