package _09Scanner;

import java.io.*;
import java.util.Scanner;

/**
 * En este ejemplo vamos a leer un fichero de texto palabra a palabra separadas por un
 * blanco guardando cada palabra en un String:
 * 
 * Como podemos ver ahora los metodos usados son hasNext que nos devuelve cierto
 * mientras haya mas palabras por leer y falso cuando el fichero se acaba y next 
 * que devuelve la siguiente palabra del fichero en un String. 
 *
 */

public class EjemploFichero2 {

	public static void main(String[] args) {
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File("./src/_09Scanner/amigos.txt"));
			
			while (sc.hasNext()) { // Mientras queden palabras en el fichero
				
				String palabra=sc.next();  // Leer una palabra del fichero
				
				System.out.println(palabra);   // Mostrar la palabra en consola
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		
		if (sc!=null) sc.close();
	}

}
