package desdeJava8;

import java.time.*;

/**
 * Veamos a continuaci�n un peque�o ejemplo con operaciones sobre 
 * fechas teniendo en cuenta que los d�as festivos son los s�bados 
 * y domingos.
 * 
 * Averiguamos cu�ntos d�as festivos caen en s�bado o domingo
 * 
 * @author profesor
 *
 */

public class Ejemplo8FestivosFinde {

	public static void main(String[] args) {
		
		MonthDay[] fiestas = new MonthDay[8];
		int numDias;
		LocalDate diaTest;
		
		fiestas[0] = MonthDay.of(1, 1); // 1 de enero
		fiestas[1] = MonthDay.of(5, 1); // 1 de mayo
		fiestas[2] = MonthDay.of(8, 15);  // 15 de agosto
		fiestas[3] = MonthDay.of(10, 12); // 12 de octubre
		fiestas[4] = MonthDay.of(11, 1);  // 1 de noviembre
		fiestas[5] = MonthDay.of(12, 6);  // 6 de diciembre
		fiestas[6] = MonthDay.of(12, 8);  // 8 de diciembre
		fiestas[7] = MonthDay.of(12, 25); // 25 de diciembre
		
		for (int año=2019; año<2030; año++) {
			numDias = 0;
			for (MonthDay test:fiestas) {
				diaTest = test.atYear(año);
				if ((diaTest.getDayOfWeek()==DayOfWeek.SATURDAY) || 
				    (diaTest.getDayOfWeek()==DayOfWeek.SUNDAY))
					numDias++;
			}
			System.out.println("En "+año+" hay "+numDias+
					" d�a(s) festivo(s) que caen en sábado o domingo");
			
		}
	}

}
