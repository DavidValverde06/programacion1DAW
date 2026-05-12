package _10Path_Paths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * En este ejemplo veremos como unir dos path con la ayuda del metodo resolve
 * @author Usuario
 *
 */
public class Ejemplo4Unir {


	public static void main(String[] args) {
		
		Path basePath = Paths.get(System.getProperty("user.home"),"documents", "java");
		Path file = Paths.get("temario.txt");
		
		Path complete = basePath.resolve(file);
		
		System.out.println(complete.toString());
		
		

	}

}
