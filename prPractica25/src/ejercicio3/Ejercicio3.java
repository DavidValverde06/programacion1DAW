package ejercicio3;

import java.io.*;
import java.nio.charset.*;

/**
 * 3.- En este ejercicio vamos a realizar un programa que nos permite escribir en un fichero de caracteres una
 * cadena que contengan el comienzo del El Quijote. Los caracteres los debéis escribir uno a uno en el
 * fichero con la ayuda de un flujo FileWriter. Modificar el programa para que os escriba la cadena en una
 * sola sentencia de escritura. El archivo que debéis crear se llama introQuijote.txt.
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		String intro = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme camión";

		try (FileWriter flujoEscritura = new FileWriter(
				new File("./src/ejercicio3/introQuijote.txt"),Charset.defaultCharset(),true);) {
			// Escribir la cadena completa
			flujoEscritura.write(intro);
			flujoEscritura.write('\n');

			// Escribir caracter a caracter
			for (char c:intro.toCharArray()) {
				flujoEscritura.write(c);
			}
			flujoEscritura.write('\n');

			// Se va a escribir la cadena dos veces ya que hemos escrito primero la cadena completa
			// y luego la hemos escrito tambien pero caracter a caracter

			System.out.println("Fichero creado");
		}
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}

}
