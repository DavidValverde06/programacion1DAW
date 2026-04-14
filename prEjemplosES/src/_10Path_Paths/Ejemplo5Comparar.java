package _10Path_Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Vamos a ver a traves de este ejemplo como comparar path, lo cual nos va resultar muy util
 * para saber si dos rutas son iguales o no 
 *
 */
public class Ejemplo5Comparar {

	public static void main(String[] args) {

		Path p1 = Paths.get(System.getProperty("user.home"), "documents", "java", "..", "..", "documents", "java",
				"temario.txt");
		
		Path p2 = Paths.get(System.getProperty("user.home"), "documents", "java", "temario.txt");
		
		if (p1.equals(p2))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		if (p1.normalize().equals(p2))
			System.out.println("Ahora sí son iguales");

	}

}
