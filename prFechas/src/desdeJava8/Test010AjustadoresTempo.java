package desdeJava8;

import java.time.LocalDate;
import java.time.Month;

/**
 * En este ejemplo, encontramos el primer día del próximo trimestre fiscal.
 */
public class Test010AjustadoresTempo {

	public static void main(String[] args) {
		 LocalDate today = LocalDate.now();

	        // Calcular el primer día del próximo trimestre
	        LocalDate nextQuarterStart = today.with(temporal -> {
	            LocalDate date = LocalDate.from(temporal);
	            Month nextQuarter = date.getMonth().plus(3 - (date.getMonthValue() - 1) % 3);
	            return LocalDate.of(date.getYear(), nextQuarter, 1);
	        });

	        System.out.println("Hoy: " + today);
	        System.out.println("Inicio del próximo trimestre fiscal: " + nextQuarterStart);

	}

}
