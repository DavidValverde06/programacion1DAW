package _10Path_Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * En este ejemplo obtendremos informacion del Path
 *
 */

public class Ejemplo2Informacion {

	public static void main(String[] args) {

		Path path = Paths.get(System.getProperty("user.home"),"documents", "java", "temario.txt");
		
		System.out.println("toString:" + path.toString());  // Devuelve una representacion como una cadena de caracteres
		System.out.println("getFileName: " + path.getFileName());  // Nombre del fichero o ultimo directorio donde hemos definido la ruta
		System.out.println("getName(0): " + path.getName(0));      // Trocea la ruta, y nos devuelve una parte que le indiquemos
		System.out.println("getNameCount: " + path.getNameCount());  // Indica el n�mero de partes de la ruta
		System.out.println("subpath(0,2): " + path.subpath(0,2));    // Obtiene las dos primeras partes de la ruta
		System.out.println("getParent: " + path.getParent());        // Padre del nombre del fichero
		System.out.println("getRoot: " + path.getRoot());			 // Raiz del sistema
	}

}
