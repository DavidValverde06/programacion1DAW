package _09Scanner;

/**
 * Vamos a leer un fichero de texto línea a línea guardando cada línea en un String
 * Como podemos ver los metodos usados son hasNextLine que nos devuelve cierto
 * mientras haya mas líneas por leer y falso cuando el fichero se acaba y nextLine 
 * que devuelve la siguiente línea del fichero en un String.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class EjemploFichero1 {

	public static void main(String[] args) {

		Scanner sc = null;
		try {
			sc = new Scanner(new File("./src/_09Scanner/amigos.txt"));

			while (sc.hasNextLine()) { // Mientras queden lineas en el fichero

				String linea=sc.nextLine();  // Leer una línea del fichero

				System.out.println(linea);   // Mostrar la línea en consola
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}

		if (sc!=null) sc.close();

		System.out.println("\nLectura del archivo con readAllLines: ");
		try {
			List<String> lineasFichero = Files.readAllLines(Path.of("./src/_09Scanner/amigos.txt"));
			System.out.println(lineasFichero);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\nLectura del archivo con readString: ");
		try {
			String lineasFichero = Files.readString(Path.of("./src/_09Scanner/amigos.txt"));
			System.out.println(lineasFichero);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
