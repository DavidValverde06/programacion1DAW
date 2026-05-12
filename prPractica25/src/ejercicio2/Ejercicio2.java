package ejercicio2;

import java.io.*;
import java.util.Arrays;

/**
 * 2.- Realizar un programa que nos permita leer byte a byte el contenido del fichero creado en el ejercicio
 * anterior, ayudaros de la clase BufferedInputStream. Los datos leídos los mostraremos en consola.
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		try (BufferedInputStream flujoLectura = new BufferedInputStream(new FileInputStream("./src/ejercicio1/buffered.dat"))) {

			System.out.println(Arrays.toString(flujoLectura.readAllBytes()));

		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
