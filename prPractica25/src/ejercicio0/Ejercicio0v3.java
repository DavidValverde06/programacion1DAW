package ejercicio0;

import java.io.*;

public class Ejercicio0v3 {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");

		try (BufferedReader flujoEscritura = new BufferedReader(
				new FileReader("./src/ejercicio0/Fichero.txt"))) {

			String cadena;

			System.out.println("Leyendo datos:\n");

			cadena = flujoEscritura.readLine();
			while (cadena!=null) {
				System.out.println((String)cadena);
				cadena = flujoEscritura.readLine();
			}

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
