package desdeJava8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Este ejemplo muestra cómo calcular una serie de fechas recurrentes, 
 * como los tres próximos domingos desde una fecha dada.
 */
public class Test08AjustadoresTempo {

	public static void main(String[] args) {
		 LocalDate startDate = LocalDate.now();
	        System.out.println("Fecha inicial: " + startDate);

	        // Calcular los tres próximos domingos
	        for (int i = 1; i <= 3; i++) {
	            startDate = startDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
	            System.out.println("Próximo domingo " + i + ": " + startDate);
	        }
	}

}
