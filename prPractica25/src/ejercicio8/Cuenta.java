package ejercicio8;

import java.io.*;
import java.util.*;

/**
 * 8.- Hacer una clase Cuenta, con un método cuentaPalabras() que cuente las palabras existentes en un
 * archivo de texto pasado como parámetro. Hay muchas formas de poder hacer este ejercicio, una sería
 * con la ayuda de StringTokenizer, que tiene un método countTokens, pero así sólo podéis especificar un
 * tipo de separador, otra forma posible es utilizar la clase Scanner y el método useDelimiter, al cual le
 * podréis especificar mediante expresiones regulares varios separadores entre palabras (. , ; )
 */
public class Cuenta {

	public static void main(String[] args) {

		int contadorPalabras = cuentaPalabras(solicitudNombre());
		System.out.println("\nEl fichero cuenta con " + contadorPalabras + " palabras");
	}

	/**
	 * Método al que se le pasa un fichero y devuelve el número de palabras del fichero
	 * @return número de palabras del fichero
	 */
	private static int cuentaPalabras(File fichero) {
		int contadorPalabras = 0;

		try (Scanner sc = new Scanner(fichero)) {

			sc.useDelimiter("[\\s.,;:_-]+"); // Delimitador (el guion se escribe al final porque se usa para rangos)

			while (sc.hasNext()) {
				sc.next();
				contadorPalabras++;
			}

		}
		catch (FileNotFoundException e) {
			System.out.println("Error: No se pudo leer el archivo.");
		}

		return contadorPalabras;
	}

	/**
	 * Método que devuelve el fichero escrito por consola
	 * @return
	 */
	public static File solicitudNombre() {
		String nomArchivo;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Escribe la ruta del archivo: ");
			nomArchivo = sc.nextLine();
		}

		File archiFile = new File(nomArchivo);

		if (!archiFile.exists()) {
			System.out.println("Archivo no encontrado");
			System.exit(0);
		}

		return archiFile;
	}

}
