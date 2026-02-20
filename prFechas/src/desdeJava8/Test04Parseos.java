package desdeJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Test04Parseos {

	public static void main(String[] args) {

		// --------------------------------------------------------
		// Prueba de "parseo" de fechas
	    // --------------------------------------------------------
	    LocalDate fechaPrueba = LocalDate.parse("2020-07-06");
	    
	    // Formato por defecto, ISO 8601, podr�a incluir horas, si utilizamos
	    // una clase que maneje horas
	    System.out.println("Fecha creada a trav�s de parseo por defecto: "+fechaPrueba);
	    
	    // Formato propio mediante la clase DatTimeFormatter y su m�todo ofPattern()
	    LocalDate seisNov = LocalDate.parse("6/11/2020", DateTimeFormatter.ofPattern("d/M/yyyy") );
	    System.out.println("Fecha creada a través de parseo propio: "+seisNov);

	    // Formato propio, y creación de fecha a partir de parseo
	    DateTimeFormatter miFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String text = fechaPrueba.format(miFormato);
	    LocalDate parseDate = LocalDate.parse(text,miFormato);
	    System.out.println("Fecha (con formato propio): " +text);  
	    System.out.println("Fecha (creada a partir de formato propio): " +parseDate);  

	    
	    // Ejemplo de patr�n personalizado utilizando los caracteres apropiados
	    System.out.println("Fecha con patrón personalizado: " +fechaPrueba.format(
	    		              DateTimeFormatter.ofPattern("EEEE',' d 'de' MMMM 'de' yyyy")));

	    
	    //Formato personalizado de conversi�n a texto
	    LocalDateTime fechaConHora = LocalDateTime.parse("2020-07-06T20:40:15");
	    System.out.println("\nFormato personalizado de conversi�n a texto:");
	    System.out.println("Formato por defecto: " + fechaConHora);
	    System.out.println("Formato ISO 8601 (expl�cito): " + 
	                          fechaConHora.format(DateTimeFormatter.ISO_DATE_TIME));
	       	// Existen diversos formateadores ya predefinidos en forma de constantes de 
	        // DateTimeFormatter como el que hemos usado (ISO_DATE_TIME), hay m�s
	    
	    DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	    System.out.println("Formato espa�ol (manual): " + fechaConHora.format(esDateFormat));
	    
	    
	    // Otro ejemplo de formato personalizado incluyendo el idioma espa�ol
	    DateTimeFormatter esDateFormatLargo = 
	    					DateTimeFormatter
	    						.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss")
	    							.withLocale(new Locale("es", "ES"));
	    System.out.println("Formato espa�ol (largo, localizado): " + fechaConHora.format(esDateFormatLargo));

	    
	    // Ejemplo similar al anterior, pero tenindo en cuenta el pais e idioma del usuario
	    String idiomaLocal = System.getProperty("user.language");
	    String paisLocal = System.getProperty("user.country");
	    System.out.println("Formato actual del sistema (" + idiomaLocal + "-" + paisLocal + "): " + 
	      fechaConHora.format(
	        //Nota: LONG o FULL no funcionan por ser un dato sin zona horaria
	        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
	          .withLocale(
	            new Locale(idiomaLocal, paisLocal)
	          )
	        )
	      );
	}

}
