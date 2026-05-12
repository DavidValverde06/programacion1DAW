/**
 * Verificar si un File corresponde a un fichero, o un directorio
 */
package _05File;

import java.io.File;

public class Ejemplo2File {

	public static void main(String[] args) {
		
		//File f = new File("./", "nuevo.txt");
		File f = new File("./");
		
		if (f.isFile()) 
			System.out.println("Es un fichero");
		else if (f.isDirectory())
			System.out.println("Es un directorio");
		else
			System.out.println("No es ni un fichero ni un directorio");

	}

}
