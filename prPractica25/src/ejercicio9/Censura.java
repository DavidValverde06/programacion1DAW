package ejercicio9;

import java.io.*;
import java.util.*;

/**
 * 9.- Se necesita crear una clase Censura con un método aplicaCensura(), que modifique ciertas palabras de
 * un fichero. El método toma un fichero de entrada y mediante un fichero de censura cerrará un fichero
 * de salida con las modificaciones.
 * 
 * Ejemplo:
 * 		Fichero de entrada: (datos.txt)
 * 			En un lugar de la Mancha de cuyo nombre no quiero acordarme, no ha mucho tiempo
 * 			que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y
 * 			galgo corredor...
 * 
 * 		Fichero censura (censura.txt)
 * 			acordarme recordar
 * 			hidalgo noble
 * 
 * 		Fichero de salida (datos1.txt)
 * 			En un lugar de la Mancha de cuyo nombre no quiero recordar, no ha mucho tiempo
 * 			que vivía un noble de los de lanza en astillero, adarga antigua, rocín flaco y
 * 			galgo corredor...
 */
public class Censura {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		RandomAccessFile fichero = null;
		String palabra, cadena;
		StringBuilder auxBuilder;
		long pos = 0;
		int indice;

		try {
			// se abre el fichero para lectura/escritura
			fichero = new RandomAccessFile("./src/ejercicio9/censura.txt", "rw");

			// Se pide la palabra a buscar
			System.out.print("Introduce palabra: ");
			palabra = sc.nextLine();

			// lectura del fichero
			cadena = fichero.readLine(); // leemos la primera linea
			while(cadena!=null){         // mientras no lleguemos al final del fichero
				indice = cadena.indexOf(palabra); // buscamos la palabra en la linea leida
				while(indice!=-1){ // mientras la linea contenga esa palabra (por si esta repetida)

					// paso la linea a un StringBuilder para modificarlo
					auxBuilder = new StringBuilder(cadena); 
					auxBuilder.replace(indice, indice+palabra.length(), palabra.toUpperCase());
					cadena = auxBuilder.toString();

					// Nos posicionamos al principio de la linea actual y se sobrescribe la linea completa
					// La posicion donde empieza la linea actual la estoy guardando en la variable pos
					fichero.seek(pos);
					fichero.writeBytes(cadena);

					// compruebo si se repite la misma palabra en la linea
					indice = cadena.indexOf(palabra);
				}
				pos = fichero.getFilePointer(); // posicion de la linea actual que voy a leer
				cadena = fichero.readLine();    // lectura de la linea
			}
			System.out.println("Fichero actualizado");
		} 
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} 
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
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
