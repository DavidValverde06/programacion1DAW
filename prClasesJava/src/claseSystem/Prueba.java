package claseSystem;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		
		// ---------------------------------------------------------
		// Lectura de datos mediante la entrada estándar System.in
		// ---------------------------------------------------------
		Scanner obLectura = new Scanner(System.in);
		System.out.print("Introduce tu nombre: ");
		String nombre = obLectura.nextLine();
		obLectura.close();

		// ---------------------------------------------------------
		// Salida estándar mediante System.out
		// ---------------------------------------------------------
		System.out.println("Hola, mundo!");
		System.out.println("Nombre: " + nombre);
		
		// ---------------------------------------------------------
		// Salida estándar de error mediante System.err
		// ---------------------------------------------------------
		System.err.println("Error: Entrada no válida");
		
		// Llamada al recolector de basura (es una sugerencia)
		System.gc();
		
		System.out.println("Finalizando programa...");
		System.exit(0);

	}

}
