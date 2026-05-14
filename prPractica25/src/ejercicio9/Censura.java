package ejercicio9;

import java.io.*;
import java.nio.file.Path;
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

		aplicaCensura(ficheroEntrada.toFile());

	}

	private static void aplicaCensura(File fichero) {

		try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter())) {


		}
		catch (Exception e) {

		}
	}

}
