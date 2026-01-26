package prPractica09;

/**
 * 5. A partir de una cadena de entrada con formato “dd/mm/aaaa”, descompón la cadena de forma que
 * obtengas tres números uno con el día, otro con el mes, y otro con el año.
 * 
 * A partir de una cadena de entrada con formato “nombre_usuario@gestor_correo”, descompón la cadena
 * de forma que obtengas dos nuevas cadenas, una con el nombre de usuario, y otra con el del gestor de
 * correo.
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		String cadenaFecha = "22/01/2026";
		String cadenaCorreo = "nombre_usuario@gestor_correo"; 

		String [] arrayFecha = cadenaFecha.split("/");
		System.out.println("Día: " + arrayFecha[0]);
		System.out.println("Mes: " + arrayFecha[1]);
		System.out.println("Año: " + arrayFecha[2]);
		
		System.out.println();
		
		String [] arrayCorreo = cadenaCorreo.split("@");
		System.out.println("Nombre usuario: " + arrayCorreo[0]);
		System.out.println("Gestor de correo: " + arrayCorreo[1]);
	}

}
