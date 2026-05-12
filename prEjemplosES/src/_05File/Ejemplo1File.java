/**
 * Creacion de ficheros y ficheros temporales
 */
package _05File;

import java.io.File;
import java.io.IOException;

public class Ejemplo1File {

	public static void main(String[] args) {
		
		try {
			File f = new File("./", "./src/_05File/nuevo.txt");
			f.createNewFile();
				
			System.out.println("¿Existe?: " + f.exists());
			System.out.println("¿Es fichero?: " + f.isFile());
			System.out.println("¿Es directorio?: " + f.isDirectory());
			System.out.println("Tamaño (bytes): " + f.length());

			File temp = File.createTempFile("temporal", ".tmp");
			System.out.println(temp.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
