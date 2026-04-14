package _11Files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class Ejemplo7Atributos {

	public static void main(String[] args) {
		
		Path ruta = Paths.get("./src/_11Files/Ejemplo7Atributos.java");

		try {
			// BasicFileAttributes es una interfaz que agrupa varios metadatos básicos de un archivo.
			BasicFileAttributes attrs = Files.readAttributes(ruta, BasicFileAttributes.class);

			System.out.println("Tamaño: " + attrs.size() + " bytes");
			System.out.println("Última modificación: " + attrs.lastModifiedTime());
			System.out.println("¿Es un directorio?: " + attrs.isDirectory());
		} 
		catch (IOException e) {
			System.out.println("Error al leer los atributos del archivo: " + e.getMessage());
		}

	}

}
