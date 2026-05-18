package ejercicio9;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * 9.- Se necesita crear una clase Censura con un método aplicaCensura(), que modifique ciertas palabras de
 * un fichero. El método toma un fichero de entrada y mediante un fichero de censura cerrará un fichero
 * de salida con las modificaciones.
 * 
 * Ejemplo:
 * 
 * Fichero de entrada: (datos.txt)
 * En un lugar de la Mancha de cuyo nombre no quiero acordarme, no ha mucho tiempo
 * que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y
 * galgo corredor...
 * 
 * Fichero censura (censura.txt)
 * acordarme recordar
 * hidalgo noble
 * 
 * Fichero de salida (datos1.txt)
 * En un lugar de la Mancha de cuyo nombre no quiero recordar, no ha mucho tiempo
 * que vivía un noble de los de lanza en astillero, adarga antigua, rocín flaco y
 * galgo corredor...
 */
public class Censura {

	public static void main(String[] args) {

		Path ficheroEntrada = Path.of("./src/ejercicio9/datos.txt");
		Path ficheroCensura = Path.of("./src/ejercicio9/censura.txt");

		aplicaCensura(ficheroEntrada, ficheroCensura);
	}

	/**
	 * Método aplicaCensura(Path ficheroEntrada,Path ficheroCensura) al que le llegan dos
	 * ficheros (ficheroEntrada y ficheroCensura) y reemplaza el fichero entrada por una nueva
	 * copia con las palabras reemplazadas del fichero censura
	 */
	private static void aplicaCensura(Path ficheroEntrada, Path ficheroCensura) {

		HashMap<String, String> mapaCensura = new HashMap<>();

		/**
		 * Paso 1
		 * 
		 * Abrir censura.txt
		 * Leer cada línea
		 * Separar las dos palabras (con split(" "))
		 * Hacer censura.put(palabra[0], palabra[1])
		 */
		try (BufferedReader flujoLecturaCensura = Files.newBufferedReader(ficheroCensura)) {

			System.out.println("Leyendo el fichero de censura ...");

			String linea;
			String[] palabrasCensura;

			while ((linea = flujoLecturaCensura.readLine()) != null) {
				palabrasCensura = linea.split(" ");
				mapaCensura.put(palabrasCensura[0], palabrasCensura[1]);
			}

			System.out.println("Palabras del fichero de censura guardadas\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Paso 2
		 * 
		 * Leer el fichero de entrada línea a línea
		 * Para cada línea del texto original, tienes que revisar si contiene
		 * alguna de las palabras del fichero de censura.
		 */
		try (BufferedReader flujoLectura = Files.newBufferedReader(ficheroEntrada);
				BufferedWriter flujoEscritura = Files.newBufferedWriter(Path.of("./src/ejercicio9/datos1.txt"))) {

			System.out.println("Leyendo fichero de entrada");

			String linea;

			System.out.println("Reemplazando palabras ...\n");
			System.out.println("Creando nuevo fichero censurado ...\n");

			while ((linea = flujoLectura.readLine()) != null) {

				/**
				 * Paso 3
				 * 
				 * Aplicar las sustituciones
				 * Por cada par del fichero censura, reemplazas en la línea la palabra
				 * original por la nueva. Usar método replace
				 */
				for (String clave : mapaCensura.keySet()) {
					// clave              		--> "acordarme"
					// mapaCensura.get(clave) 	--> "recordar"
					linea = linea.replace(clave, mapaCensura.get(clave));
				}

				/**
				 * Paso 4
				 * 
				 * Escribir en el fichero de salida
				 * Cada línea (ya modificada) la escribes en datos1.txt.
				 */
				flujoEscritura.write(linea);
				flujoEscritura.newLine();
			}
			System.out.println("Fichero creado");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
