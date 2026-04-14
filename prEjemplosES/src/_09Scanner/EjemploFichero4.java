package _09Scanner;

/**
 * Si nuestro fichero contuviera datos de tipo numerico tambien se podrian leer con la clase
 * Scanner. Por ejemplo si quisieramos construir una lista de tipo Integer con el contenido del
 * siguiente fichero numeros.txt, podriamos hacer lo siguiente
 * 
 * Si en vez de leer numeros enteros quisieramos leer numeros reales sustituiriamos los
 * matodos hasNextInt y nextInt por hasNextDouble y nextDouble.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EjemploFichero4 {

	public static void main(String[] args) {
		
		// Definir una coleccion de datos Integer
		List<Integer> listaNumeros = new LinkedList<Integer>();
		
		try (Scanner sc = new Scanner(new File("./src/_09Scanner/numeros.txt"))) {
			
			while (sc.hasNextInt()) { // Mientras queden numeros en el fichero
				
				listaNumeros.add(sc.nextInt());  // Leer un numero y a�adirlo a la coleccion
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}

		// Mostrar la coleccion
		System.out.println("Lista generada: "+listaNumeros);
	}

}
