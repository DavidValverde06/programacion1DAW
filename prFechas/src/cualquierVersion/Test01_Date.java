package cualquierVersion;

import java.time.Instant;
import java.util.Date;

public class Test01_Date {

	public static void main(String[] args) {
		
		// Crear varios objetos tipo Date
		Date fec1 = new Date();  // Fecha y hora actual
		Date fec2 = new Date(1998, 10, 23);  // Constructor obsoleto, habÍa que 
		                                     // restar 1900 al año, observar salida
		Date fec3 = new Date(1518188744443L);
		
		System.out.println("Fecha 1:"+fec1);
		System.out.println("Fecha 2:"+fec2);
		System.out.println("Fecha 3:"+fec3);
		
		System.out.println("Fecha 1 en milisegundos "+fec1.getTime());
		
		if (fec1.before(fec3))
			System.out.println("La fecha 1 es anterior a la fecha 3");
		else
			System.out.println("La fecha 3 es anterior a la fecha 1");
		
		if (fec1.after(fec3))
			System.out.println("La fecha 1 es posterior a la fecha 3");
		else
			System.out.println("La fecha 3 es posterior a la fecha 1");
		
		// -------------------------------------------------------------------------------
		// Crear una instancia de Date con la fecha y hora actuales
        Date hoy = new Date();
        System.out.println("Fecha y hora actuales: " + hoy);
        
        // Obtener el número de milisegundos desde el Epoch
        long milliseconds = hoy.getTime();
        System.out.println("Milisegundos desde el Epoch: " + milliseconds);
        
        // Establecer una nueva fecha a partir de milisegundos
        Date nuevaFecha = new Date(milliseconds + 24 * 60 * 60 * 1000); // Sumar un día
        System.out.println("Nueva fecha: " + nuevaFecha);
        
        
        // -------------------------------------------------------------------------------
        // Mezcla con el nuevo paquete java.time
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println("Instant: " + instant);
	}
}


