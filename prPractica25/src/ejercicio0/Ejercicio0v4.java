package ejercicio0;

import java.io.*;

public class Ejercicio0v4 {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");

		try (BufferedReader flujoLectura = new BufferedReader(
				new FileReader("./src/ejercicio0/fichero.txt"))) {

			String cadena;

			System.out.println("Leyendo datos:\n");

			cadena = flujoLectura.readAllAsString(); // Método nuevo de Java 25
			System.out.println((String)cadena);

			System.out.println("\nFin de programa");
		}
		catch (FileNotFoundException e) {
			System.out.println("Problema al abrir el archivo");
		}
		catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}

}
