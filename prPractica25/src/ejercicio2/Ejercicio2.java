package ejercicio2;

import java.io.*;

/**
 * 2.- Realizar un programa que nos permita leer byte a byte el contenido del fichero creado en el ejercicio
 * anterior, ayudaros de la clase BufferedInputStream. Los datos leídos los mostraremos en consola.
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		System.out.println("Inicio de programa");

		try (BufferedInputStream flujoLectura = new BufferedInputStream(
				new FileInputStream(
						new File("./src/ejercicio1/buffered.dat")))) {

			System.out.println("Leyendo datos:\n");

			int valorLeido;
			while ((valorLeido=flujoLectura.read())!=-1) {
				System.out.print(valorLeido);
			}

			System.out.println("\n\nFin de programa");

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
