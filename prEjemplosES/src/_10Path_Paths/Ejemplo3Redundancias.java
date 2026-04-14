package _10Path_Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Este ejemplo nos muestra como podriamos eliminar redundancias en una ruta
 * con el metodo normalize
 *
 */

public class Ejemplo3Redundancias {


	public static void main(String[] args) {
		
		Path path = Paths.get(System.getProperty("user.home"),"documents", "java", "..", "..", "temario.txt");		
		System.out.println(path.toString());
		
		Path normalized = path.normalize();
		System.out.println(normalized.toString());
	}

}
