package desdeJava8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		LocalDate nextWeek = today.plusWeeks(1);
		System.out.println("Hoy: " + today);
		System.out.println("Dentro de una semana: " + nextWeek);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse("16-01-2025", formatter);
		String formattedDate = date.format(formatter);
		System.out.println(formattedDate);
		
		Date date1 = new Date();
		Instant instant = date1.toInstant();
		LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		
	}

}
