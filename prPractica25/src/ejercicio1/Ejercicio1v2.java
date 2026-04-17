package ejercicio1;

import java.io.*;
import java.util.*;

public class Ejercicio1v2 {

	public static void main(String[] args) {

		// Definir el buffer para la escritura como un array de 32 kilobytes
		byte[] buffer = new byte[1024*32];

		// Rellenar el array con 1's
		Arrays.fill(buffer, (byte)1);


		try (BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(
						new File("./src/ejercicio1/buffered2.dat")))) {

			// Escribir los datos del array en el archivo
			out.write(buffer);

			System.out.println("El fichero ha sido creado correctamente");
		}
		catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el archivo");
		}
		catch (IOException e) {
			System.out.println("Problema al escribir en el archivo");
		}
	}
}
