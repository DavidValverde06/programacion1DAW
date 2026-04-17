package ejercicio1;

import java.io.*;
import java.util.*;

/**
 * 1.- Desarrollar un programa que os permita escribir bytes en un fichero con la ayuda de un objeto
 * BufferedOutputstream, realizaremos una única escritura a través de un array de tipo byte, que
 * previamente habremos rellenado con el valor “1”, este array también funcionará como una “especie de
 * buffer”, ya que nos va a permitir escribir más de una dato con una sola sentencia de escritura. El tamaño
 * del buffer vuestro (el array) no debe ser ni muy pequeño ni muy grande, por ejemplo de 32Kilobytes. El
 * archivo creado se llamará buffered.dat.
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		// Definir el buffer para la escritura como un array de 32 kilobytes
		byte[] buffer = new byte[1024*32];

		BufferedOutputStream out = null;

		// Rellenar el array con 1's
		Arrays.fill(buffer, (byte)1);

		try {
			out = new BufferedOutputStream(
					new FileOutputStream(
							new File("./src/ejercicio1/buffered.dat")));

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
		finally {
			try {
				if (out!=null) out.close();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
