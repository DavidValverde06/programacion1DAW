package ejercicio0;

import java.io.*;
import java.util.List;

public class Ejercicio0v5 {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");

		try (BufferedReader flujoEscritura = new BufferedReader(
				new FileReader("./src/ejercicio0/Fichero.txt"))) {

			List<String> cadena;

			System.out.println("Leyendo datos:\n");

			cadena = flujoEscritura.readAllLines();
			for (String string : cadena) {
				System.out.println(string);
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
