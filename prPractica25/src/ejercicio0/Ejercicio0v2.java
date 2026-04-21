package ejercicio0;

import java.io.*;

public class Ejercicio0v2 {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");

		try (BufferedReader flujoLectura = new BufferedReader(
				new FileReader("./src/ejercicio0/Fichero.txt"))) {

			int caracter;

			System.out.println("Leyendo datos:\n");

			caracter = flujoLectura.read();
			while (caracter!=-1) {
				System.out.print((char)caracter);
				caracter = flujoLectura.read();
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
