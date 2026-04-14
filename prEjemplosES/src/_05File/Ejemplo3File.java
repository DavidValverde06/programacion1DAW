package _05File;

/**
 * Ejemplo de la utilizacion de algunos de los metodos de la clase File
 */

import java.io.*;
import java.util.Arrays;
import java.util.List;
public class Ejemplo3File {

	public static void main(String[] args) {
		
	//	File dir = new File("c:\\");
		File dir = new File("c:/");
		
		if (dir.exists())
			System.out.println("Existe el directorio "+dir.getName());
		else
			System.out.println("El directorio no existe");
		
		if (dir.canRead())
			System.out.println("El directorio existe y tiene permiso de lectura");
		
		if (dir.canWrite())
			System.out.println("El directorio existe y tiene permiso de escritura");
		
		// Obtener el contenido del directorio en un array de objetos tipo file
		
		if (!dir.isDirectory()) {
			System.out.println("No es un directorio!!!");
		}
		else {
			// Obtener un array de objetos tipo File con el contenido del directorio
			System.out.println("\nListado contenido directorio con Array de File");
			File [] ficheros = dir.listFiles();
			for (File f: ficheros)
				System.out.println(f.getName());

			// Obtener una coleccion de objetos tipo String con el contenido del directorio
			System.out.println("\nListado contenido directorio con List de String");
			List<String> listaString = Arrays.asList(dir.list());
			for (String elemento: listaString) {
				System.out.println(elemento);
			}
			
			// Otra forma de poder recorrer la colección anterior, utilizando el bucle foreach
			System.out.println("\nLista recorrida con foreach");
			listaString.forEach(System.out::println);
			
			// Crear una lista de objetos de tipo File con el contenido del directorio
			System.out.println("\nLista de objetos tipo File");
			List<File> listaFile = Arrays.asList(dir.listFiles());
			listaFile.forEach((file) -> {
				System.out.println(file.getName());
			});

			// Otra forma de recorrer la lista anterior con el uso del API Streams (no tienen nada que ver con los flujos)
			listaFile
				.stream()
				.map(File::getName)   // Mapeamos el nombre del fichero
				.forEach(System.out::println);
		}
	}
}
