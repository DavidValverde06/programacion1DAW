package desdeJava8;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Ejemplo6Period {

	public static void main(String[] args) {
		
		// Hace referencia a la diferencia que existe entre dos fechas.
		LocalDate localDate1 = LocalDate.of(2016, Month.JULY, 18);
		LocalDate localDate2 = LocalDate.of(2018, Month.MARCH, 21);
		Period period = Period.between(localDate1, localDate2);
		System.out.println(period);
			// Devolverá P1Y8M3D, es decir, 1 año, 8 meses y 3 días
		System.out.println(period.get(ChronoUnit.DAYS));
		System.out.println(period.get(ChronoUnit.YEARS));
		System.out.println(period.get(ChronoUnit.MONTHS));
		
		// Se puede crear Period basado en el método 
		// of(int years, int months, int days). 
		// En el siguiente ejemplo, se crea un período de 1 año 2 meses y 3 días
		Period period2 = Period.of(1, 2, 3);
		System.out.println(period2);
		
		// Tabmién se puede crear Period basado en los métodos ofDays(int days),
		// ofMonths(int months), ofWeeks(int weeks), ofYears(int years).
		Period period3 = Period.ofYears(1);
		System.out.println(period3);
	}

}
