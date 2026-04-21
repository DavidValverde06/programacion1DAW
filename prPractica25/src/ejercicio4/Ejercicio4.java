package ejercicio4;

import java.io.*;
import java.util.*;

/**
 * 4.- Vamos a desarrollar un ejercicio que nos permita escribir una serie de cadenas de texto que tendremos
 * almacenadas en una colección tipo List<String>. Iremos recorriendo dicha colección y escribiendo cada
 * cadena en el fichero con la ayuda de un flujo BufferedWriter.
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		// Crear una colección de cadenas de caracteres
		List<String> listaQuijote = Arrays.asList(new String[] {"En un lugar de la Mancha",
																"de cuyo nombre no quiero acordarme",
																"no ha mucho tiempo que vivía un hidalgo",
																"de los lanza en astillero",
																"adarga antigua, rocín falco y galgo corredor"});

		// Escribir la colección anterior en un archivo de texto
		// con la ayuda de un "flujo (stream)" BufferedWriter
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter(
						new File("./src/ejercicio4/quijote.txt"),true))){

			for (String elem: listaQuijote) {
				bw.write(elem);
				bw.newLine();
			}

			System.out.println("Fichero creado");

		}
		catch (FileNotFoundException e) {
			System.out.println("Ruta no válida");
		}
		catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}

}
