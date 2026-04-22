package ejercicio7;

import java.io.*;
import java.util.*;
import recursos.UtilCarCad;

/**
 * 7.- Programa que solicita al usuario un nombre de archivo de texto, y lo copia en otro nuevo archivo en
 * forma encriptada, siguiendo el cifrado Cesar1.
 * 
 * Posteriormente recorrerá el nuevo archivo y lo mostrará
 * al usuario sin encriptar. 
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		// Guardamos el fichero a copiar
		File archivoOriginal = solicitudNombre();

		// Definimos la ruta de destino de ese fichero
		File archivoCopia = new File("./src/ejercicio7/copiacifrada" + archivoOriginal.getName());

		System.out.println(); // Salto de línea en consola

		try (BufferedReader flujoLectura = new BufferedReader(new FileReader(archivoOriginal));
				BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(archivoCopia))) {

			realizarCopiaEncriptada(flujoLectura, flujoEscritura);

		}
		catch (FileNotFoundException e) {
			System.out.println("Error: No se encontró el archivo");
		}
		catch (IOException e) {
			System.out.println("Error de entrada/salida");
		}

		lecturaDelFichero(archivoCopia);

	}

	/**
	 * Método que realiza la copia encriptada de un fichero que
	 * se le pasa escrito por consola
	 * @param flujoLectura
	 * @param flujoEscritura
	 * @throws IOException
	 */
	private static void realizarCopiaEncriptada(BufferedReader flujoLectura, BufferedWriter flujoEscritura) throws IOException {
		String linea;

		while ((linea = flujoLectura.readLine()) != null) {

			flujoEscritura.write(UtilCarCad.encriptaCadena(linea));
			flujoEscritura.newLine();

			System.out.println("Encriptando...");

		}

		System.out.println("\nCopia encriptada finalizada");
	}

	/**
	 * Método que lee el fichero creado y lo muestra primero en 
	 * consola de forma encriptada y luego lo muestra desencriptado
	 * @param archivoCopia
	 */
	private static void lecturaDelFichero(File archivoCopia) {
		String cadena;

		System.out.println("\nArchivo encriptado: ");

		// Lectura del fichero encriptado
		try (BufferedReader flujoLectura = new BufferedReader(new FileReader(archivoCopia))) {

			cadena = flujoLectura.readAllAsString(); // Método nuevo de Java 25
			System.out.println((String)cadena);

		}
		catch (FileNotFoundException e) {
			System.out.println("Error: No se encontró el archivo");
		}
		catch (IOException e) {
			System.out.println("Error de entrada/salida");
		}

		System.out.println("Archivo desencriptado:");

		// Desencriptación del fichero
		try (BufferedReader flujoLectura = new BufferedReader(new FileReader(archivoCopia))) {

			cadena = flujoLectura.readAllAsString(); // Método nuevo de Java 25
			System.out.println((String)UtilCarCad.desencriptaCadena(cadena));

		}
		catch (FileNotFoundException e) {
			System.out.println("Error: No se encontró el archivo");
		}
		catch (IOException e) {
			System.out.println("Error de entrada/salida");
		}
	}

	/**
	 * Método que devuelve el fichero escrito por consola
	 * @return
	 */
	public static File solicitudNombre() {
		String nomArchivo;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Nombre del archivo a copiar: ");
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
