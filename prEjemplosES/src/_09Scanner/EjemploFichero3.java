package _09Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * En este ejemplo queremos leer un fichero de texto separando frases por una
 * coma guardando cada frase en un String.
 * 
 * Como podemos ver la diferencia con el anterior ejemplo es el uso del metodo
 * useDelimiter que permite leer separando por otros caracteres distintos de blanco. 
 *
 */

public class EjemploFichero3 {

	public static void main(String[] args) {
		
		System.out.println("---- Primera forma de hacerlo ----");
		try {
			Scanner sc = new Scanner(new File("./src/_09Scanner/datos1.txt"));
			Scanner scDelimitador = sc.useDelimiter(",");
			
			while (scDelimitador.hasNext()) { // Mientras queden frases separadas por coma
				
				String palabra=scDelimitador.next();  // Leer una frase
				
				System.out.println(palabra);   // Mostrar la frase en consola
			}
			
			sc.close();
			scDelimitador.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		
		
		System.out.println("---- Segunda forma de hacerlo ----");  
		try (Scanner sc = (new Scanner(
				               new File("./src/_09Scanner/datos1.txt"))).useDelimiter(",")){
				
			while (sc.hasNext()) { // Mientras queden frases separadas por coma
				
				String palabra=sc.next();  // Leer una frase
				
				System.out.println(palabra);   // Mostrar la frase en consola
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
	}
	
	
	

}
