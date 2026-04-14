package _11Files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * A traves de este ejemplo veremos como hacer operaciones de copiar, mover y borrar
 * 
 * Para no "liar mucho el codigo", no se estan controlando las excepciones, pero 
 * como ya hemos visto en otras ocasiones habria que controlarlas 
 *
 */
public class Ejemplo2CopiarBorrarMover {

	public static void main(String[] args) throws IOException {
		
		//Creamos una ruta para crear un fichero
		Path p = Paths.get("./src/_11Files", "fichero.txt");
		
		// Creamos un fichero, y abrimos el flujo de texto para escribir, se utiliza el charset por
		// defecto para evitar problemas con tildes
		BufferedWriter bw = Files.newBufferedWriter(p, Charset.defaultCharset());
		bw.write("Tiene la Tarara un vestido blanco que sólo se pone en el Jueves Santo.\n" +
				 "La Tarara sí, la Tarara no, la Tarara madre que la bailo yo.");
		bw.close();
		System.out.println("Fichero fichero.txt creado correctamente");
		
		//Copiamos el fichero
		Path copia = Paths.get("./src/_11Files", "fichero_copiado.txt");
		Files.copy(p, copia, StandardCopyOption.REPLACE_EXISTING);  // Hay otras opciones de copiado
		System.out.println("Fichero copiado");
		
		//Lo movemos fuera del directorio
		Files.move(copia, Paths.get("./", "copiado.txt"), StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Fichero movido fuera del directorio");
		
		//Lo eliminamos
		Files.deleteIfExists(Paths.get("./", "copiado.txt"));
		System.out.println("Fichero eliminado");
	}
}
