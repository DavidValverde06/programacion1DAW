package _11Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * En este ejemplo vamos a probar algunos metodos relacionados con comprobaciones
 * Comprobaremos si un fichero existe, si no existe, si es regular, ...
 *
 * Muchos de los metodos de esta clase nos van a lanzar excepciones 
 * que deberemos controlar
 */
public class Ejemplo1Comprobaciones {

	public static void main(String[] args) {

		Path p = Paths.get("./src/_11Files/file.txt");

		if (Files.notExists(p)) {
			System.out.println("La ruta no existe");
			try {
				Files.createFile(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (Files.exists(p))
			System.out.println("La ruta si existe");

		if (Files.notExists(p)) 
			System.out.println("La ruta no existe");
		
		// Se nos puede dar el caso de que las dos comprobaciones anteriores nos den
		// false, por ejemplo, porque tengamos problemas de permisos, por eso
		// existen ambos metodos
		

		if (Files.isRegularFile(p))
			System.out.println("El fichero " + p.toString() + " es regular");

		Path p2 = Paths.get("./src/_11Files/file.txt");

		try {
			if (Files.isSameFile(p, p2))
				System.out.println("Son el mismo fichero");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
