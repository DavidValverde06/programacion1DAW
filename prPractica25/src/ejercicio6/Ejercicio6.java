package ejercicio6;

import java.io.*;

/**
 * 6.- Programa que lee un fichero de forma secuencial (línea a línea) y lo visualiza por pantalla. Debéis
 * realizar varias versiones del mismo ejercicio, utilizando las clases FileReader, BufferedReader, Scanner,
 * el método Files.readAllLines, el método Files.newBufferedReader, o cualquier otra forma que se os
 * ocurra.
 * El fichero que vamos a leer va a ser el propio programa que estáis desarrollando, para ello tenéis que
 * indicar adecuadamente la ruta de vuestro archivo, en mi caso el archivo a leer se llama
 * LecturaFichero.java y se encuentra en un paquete llamado ejercicio6:
 * File fichero = new File("./src/ejercicio6/LecturaFichero.java");
 * O bien
 * Path fichero = Paths.get("./src/ejercicio6/LecturaFichero.java");
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");

		// BufferedReader
		try (BufferedReader flujoLectura = new BufferedReader(
				new FileReader("./src/ejercicio6/Ejercicio6.java"))) {

			String cadena;

			System.out.println("Leyendo datos:\n");

			cadena = flujoLectura.readLine();
			while (cadena!=null) {
				System.out.println((String)cadena);
				cadena = flujoLectura.readLine();
			}

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
