package desdeJava8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Test00 {

	public static void main(String[] args) {
		
		// Ejemplo de now
		LocalDate today = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		ZonedDateTime zonedNow = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));

		// Ejemplo de of
		LocalDate date = LocalDate.of(2025, 1, 16); // Año, mes, día
		LocalTime time = LocalTime.of(14, 30, 15); // Hora, minuto, segundo
		LocalDateTime dateTime = LocalDateTime.of(2025, 1, 16, 14, 30); // Fecha y hora
		
		// Ejemplo de from
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		LocalDate dateFromZoned = LocalDate.from(zonedDateTime);
		
		// Ejemplo de parse
		LocalDate parsedDate = LocalDate.parse("2025-01-16");
		LocalTime parsedTime = LocalTime.parse("14:30:00");
		
		// Ejemplo de plus
		LocalDate nextMonth = LocalDate.now().plusMonths(1);
		LocalDateTime nextHour = LocalDateTime.now().plusHours(1);
		
		// Ejemplo de minus
		LocalDate lastYear = LocalDate.now().minusYears(1);
		LocalTime earlierTime = LocalTime.now().minusMinutes(15);
		
		// Ejemplo de with
		LocalDate firstDayOfMonth = LocalDate.now().withDayOfMonth(1); // Primer día del mes
		LocalTime noon = LocalTime.now().withHour(12).withMinute(0);  // Ajustar a las 12:00
		
		// Ejemplo de at
		LocalDate diaPartido = LocalDate.of(2020, 7, 13);
		LocalTime horaPartido = LocalTime.of(21, 00);
		LocalDateTime fin = diaPartido.atTime(horaPartido);
		
		// Ejemplo de until
		LocalDate start = LocalDate.of(2025, 1, 1);
		LocalDate end = LocalDate.of(2025, 1, 16);
		long daysBetween = start.until(end, ChronoUnit.DAYS); // 15 días
	
		// Ejemplo de isBefore y equals
		boolean isBefore = LocalDate.now().isBefore(LocalDate.of(2025, 12, 31));
		boolean isEqual = LocalTime.now().equals(LocalTime.of(14, 30));
		
		// Ejemplo de format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = LocalDate.now().format(formatter);
		
		// Ejemplos de get
		int year = LocalDate.now().getYear();
		int month = LocalDate.now().getMonthValue(); // Número del mes (1-12)
		int day = LocalDate.now().getDayOfMonth();  // Día del mes
		
		// Ejemplo de getDayOfWeek
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek(); // Ejemplo: THURSDAY
	}

}
