package ejercicio6;

import java.io.*;
import java.nio.file.*;

/**
 * 6.- Programa que lee un fichero de forma secuencial (línea a línea) y lo visualiza por pantalla. Debéis
 * realizar varias versiones del mismo ejercicio, utilizando las clases FileReader, BufferedReader, Scanner,
 * el método Files.readAllLines, el método Files.newBufferedReader, o cualquier otra forma que se os
 * ocurra.
 * 
 * El fichero que vamos a leer va a ser el propio programa que estáis desarrollando, para ello tenéis que
 * indicar adecuadamente la ruta de vuestro archivo, en mi caso el archivo a leer se llama
 * LecturaFichero.java y se encuentra en un paquete llamado ejercicio6:
 * 
 * 	File fichero = new File("./src/ejercicio6/LecturaFichero.java");
 * 
 * O bien
 * 
 * 	Path fichero = Paths.get("./src/ejercicio6/LecturaFichero.java");
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		Path fichero = Paths.get("./src/ejercicio6/Ejercicio6.java");

		try (BufferedReader flujoLectura = Files.newBufferedReader(fichero)) {

			System.out.println(flujoLectura.readAllAsString());
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
