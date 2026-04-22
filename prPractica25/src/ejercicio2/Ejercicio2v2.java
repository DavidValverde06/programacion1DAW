package ejercicio2;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

/**
 * 2.- Realizar un programa que nos permita leer byte a byte el contenido del fichero creado en el ejercicio
 * anterior, ayudaros de la clase BufferedInputStream. Los datos leídos los mostraremos en consola.
 */
public class Ejercicio2v2 {

	public static void main(String[] args) {

		System.out.println("Inicio de programa");

		byte[] buffer = new byte[1024*32];

		try (InputStream bis = Files.newInputStream(Path.of("./src/ejercicio1/buffered.dat"))) {

			System.out.println("Leyendo datos:\n");

			buffer = bis.readAllBytes();
			System.out.println("Datos leidos: " + Arrays.toString(buffer));

			System.out.println("\nFin de programa");

		} 
		catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("No se puede leer el archivo");
		}
		catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Error de E/S");
		}

	}
}
