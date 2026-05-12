package cualquierVersion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test10_SimpleDateFormat {

	public static void main(String[] args) {
		
		Calendar fecha = new GregorianCalendar(2027,8,22);

		SimpleDateFormat patron1 = new SimpleDateFormat("EEEE dd-MMM-yyyy, HH:mm:ss");
		SimpleDateFormat patron2 = new SimpleDateFormat("dd/MM//yy");
		SimpleDateFormat patron3 = new SimpleDateFormat("'Hola hoy es' EEEE, dd 'de' MMMM 'de' yyyy, HH:mm:ss");
		
		System.out.println(patron1.format(fecha.getTime()));
		System.out.println(patron2.format(fecha.getTime()));
		System.out.println(patron3.format(fecha.getTime()));
		
	}

}
