package desdeJava8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Ejemplo9PruebasVarias {

	public static void main(String[] args) {

		// --------------------------------------------------------
		// Prueba del m�todo now
		// --------------------------------------------------------
	    System.out.println("--- Pruebas con el m�todo now ---");
		System.out.println("La fecha actual es: " + LocalDate.now());
	    System.out.println("La hora actual es: " + LocalTime.now() );
	    System.out.println("La fecha y hora actuales son: " + LocalDateTime.now() );
	    System.out.println("El instante actual es: " + Instant.now() );
	    System.out.println("La fecha y hora actuales con zona horaria son: " + ZonedDateTime.now() );


		// --------------------------------------------------------
		// Prueba del m�todo of
		// --------------------------------------------------------
	    System.out.println("\n--- Pruebas con el m�todo of ---");
	    System.out.println("Fecha de mi cumplea�os: " + LocalDate.of(1971, Month.OCTOBER, 17) );
	    System.out.println("Con la hora exacta: " + LocalDateTime.of(1971, Month.OCTOBER, 17, 8, 01, 15, 0023) );
	    //Produce un error porque 2019 no fue un a�o bisiesto (descomenta para probar)
	    //System.out.println( "D�a bisiesto de 2019: " + LocalDate.of(2019, Month.FEBRUARY, 29) );

	    
		// --------------------------------------------------------
		// Prueba de m�todos get
	    // --------------------------------------------------------
	    System.out.println("\n--- Pruebas con m�todos get ---");
		LocalDateTime miDateTime = LocalDateTime.now();
		System.out.println("Fecha actual: "+miDateTime);
		System.out.println("A�o: "+miDateTime.getYear());     
		System.out.println("Mes: "+miDateTime.getMonth());      
		System.out.println("D�a: "+miDateTime.getDayOfMonth()); 
		System.out.println("Hora: "+miDateTime.getHour()); 
		System.out.println("Minutos: "+miDateTime.getMinute()); 
		System.out.println("Segundos: "+miDateTime.getSecond()); 
		System.out.println("Nanosegundos: "+miDateTime.getNano()); 
		System.out.println("D�a del a�o: "+miDateTime.getDayOfYear());
		System.out.println("D�a del mes: "+miDateTime.getDayOfMonth());
		System.out.println("D�a de la semana: "+miDateTime.getDayOfWeek());
	    
		// --------------------------------------------------------
		// Prueba de m�todos plus y minus
	    // --------------------------------------------------------
	    System.out.println("\n--- Pruebas con m�todos plus y minus ---");
	    System.out.println("La fecha dentro de 10 d�as: " + LocalDate.now().plusDays(10) );
	    System.out.println("La fecha y hora de hace 32 horas: " + LocalDateTime.now().minusHours(32) );

		
		// --------------------------------------------------------
		// Prueba de ajustadores temporales (TemporalAdjusters)
	    // --------------------------------------------------------
	    System.out.println("\n--- Pruebas con ajustadores temporales ---");
	    System.out.println("El primer d�a del pr�ximo mes es: " + 
	        LocalDate.now().with(
	              TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek() );
	    
	    System.out.println("El �ltimo d�a del mes actual: " + 
	        LocalDate.now().with(
	              TemporalAdjusters.lastDayOfMonth()).getDayOfWeek());
	    
	    
		// --------------------------------------------------------
		// Prueba de intervalos de tiempo
	    // --------------------------------------------------------
	    System.out.println("\n--- Pruebas de intervalos de tiempo ---");
	    
	    // Calcular la edad de un persona
	    LocalDate fNacimiento = LocalDate.of(1981, Month.MAY, 23);
	    System.out.println("Mi edad es de " +  
	          ChronoUnit.YEARS.between(fNacimiento, LocalDate.now()) + " a�os.");
	    
	    // Averiguar los d�as que faltan para que termine el a�o, para ello se ha creado
	    // un objeto LocalDate, con la fecha actual, as� servir� para cualquier a�o,
	    // y se le ha modificado el d�a y el mes. Recordad que los a�os bisiestos tienen
	    // un d�a m�s
	    LocalDate finAño = LocalDate.now();
	    finAño = finAño.withMonth(12);
	    finAño = finAño.withDayOfMonth(31);
	    System.out.println("Hasta final de a�o quedan: " + 
	    		ChronoUnit.DAYS.between(LocalDate.now(),finAño) + " d�as.");
	    		
	    // Otra forma de averiguar los d�as que faltan para que termine el a�o,
	    // en este caso con ayuda de la clase Period
	    LocalDate hoy = LocalDate.now();
	    LocalDate finDeAnio = hoy.with(TemporalAdjusters.lastDayOfYear());
	   
	    Period hastaFinDeAnio = hoy.until(finDeAnio);
	    // La l�nea anterior se podr�a sustituir tambi�n por el m�todo between
	    //Period hastaFinDeAnio = Period.between(hoy, finDeAnio);
	    
	    int meses = hastaFinDeAnio.getMonths();
	    int dias = hastaFinDeAnio.getDays();
	    
	    System.out.println("Faltan " + meses + " meses y " + dias + " d�as hasta final de a�o.");	
	   
	}

}
