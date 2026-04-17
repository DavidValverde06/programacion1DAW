package ejercicio0;

import java.io.*;

public class Ejercicio0v4 {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");

		try (BufferedReader flujoEscritura = new BufferedReader(
				new FileReader("./src/ejercicio0/Fichero.txt"))) {

			String cadena;

			System.out.println("Leyendo datos:\n");

			cadena = flujoEscritura.readAllAsString();
			System.out.println((String)cadena);

			System.out.println("\nFin de programa");
		}
		catch (FileNotFoundException e) {
			System.out.println("Problema al abrir el archivo");
		}
		catch (IOException e) {
			// e.printStackTrace();
		}
	}

}
