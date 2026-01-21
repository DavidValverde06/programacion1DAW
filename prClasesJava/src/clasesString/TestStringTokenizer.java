package clasesString;

import java.util.StringTokenizer;

public class TestStringTokenizer {

	public static void main(String[] args) {
		
		// -------------------------------------------------------------------------------
		// Prueba de la clase StringTokenizer
		// -------------------------------------------------------------------------------
		StringTokenizer st = new StringTokenizer("Esto es una prueba de StringTokenizer");
		
		while (st.hasMoreTokens())
			System.out.println(st.nextToken());
		
		
		StringTokenizer fecha = new StringTokenizer("12/08/2025","/");
		System.out.println("\nDía: " + fecha.nextToken());
		System.out.println("Mes: " + fecha.nextToken());
		System.out.println("Año: " + fecha.nextToken());
		
		// -------------------------------------------------------------------------------
		// StringTokenizer es una clase obsoleta, mejor utilizar el método split de 
		// la clase String, veamos algunos ejemplos
		// -------------------------------------------------------------------------------
        String cadena = "Java es un lenguaje poderoso";
        String[] tokens = cadena.split(" ");  // Delimitador: espacio

        for (String token : tokens) {
            System.out.println(token);
        }

		String fecha2 = ("26/07/2024");
		String [] arrayFecha = fecha2.split("/");  // Delimitador: /
		System.out.println("\nDía: " + arrayFecha[0]);
		System.out.println("Mes: " + arrayFecha[1]);
		System.out.println("Año: " + arrayFecha[2]);
	}




}
