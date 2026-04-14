package _10Path_Paths;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * En este ejemplo se muestra la creacion de diferentes objetos tipo Path
 * 
 * Para la creacion de los Path, se utiliza la clase Paths, lo cual es habitual en la mayoria de 
 * los casos. Y tambien teneis un ejemplo con la clase FileSystems
 *
 */
public class Ejemplo1Crear {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		
		// Nadie nos asegura que la ruta que estamos creando exista, es decir, no tiene porque existir
	
		// En estos dos primeros ejemplos crea una ruta que combina la ruta actual, con donde 
		// se esta ejecutando la aplicacion. Dos formas diferentes de hacer lo mismo
		Path p1 = Paths.get("java", "temario.txt");
		Path p2 = FileSystems.getDefault().getPath("java", "temario.txt");
		
		// Crea una ruta con el usuario logeado y la ruta indicada
		Path p3 = Paths.get(System.getProperty("user.home"),"documents", "java", "temario.txt");
					// La propiedad del sistema "user.home", nos devuelve la ruta del usuario
		            // que esta logeado
		
		// Mostramos las 3 rutas anteriores, convirtiendolas a rutas absolutas
		System.out.println(p1.toAbsolutePath().toString());
		System.out.println(p2.toAbsolutePath().toString());
		System.out.println(p3.toAbsolutePath().toString());

		// Mostramos los objetos sin convertirlos a ruta absoluta
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		
		// Utilizar una variable path para crear, copiar y borrar un determinado archivo
		Path path = Paths.get("./src/_10Path_Paths/archivo.txt");
		try {
			Files.createFile(path);
			Files.copy(path, Paths.get("./src/_10Path_Paths/nuevo_nombre.txt"));
			Files.delete(path);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
