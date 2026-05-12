package desdeJava8;
import java.time.*;
import java.time.temporal.TemporalAdjuster;
/**
 * Supongamos que quieres calcular el próximo día laboral, saltando fines de semana.
 */
public class Test07AjustadoresTempo {

	public static void main(String[] args) {
		 LocalDate today = LocalDate.now();

	        // Ajustador personalizado: Próximo día laboral
	        TemporalAdjuster nextWorkingDay = temporal -> {
	            LocalDate date = LocalDate.from(temporal);
	            do {
	                date = date.plusDays(1);
	            } while (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
	            return date;
	        };

	        LocalDate nextWorkDay = today.with(nextWorkingDay);
	        System.out.println("Hoy: " + today);
	        System.out.println("Próximo día laboral: " + nextWorkDay);

	}

}
