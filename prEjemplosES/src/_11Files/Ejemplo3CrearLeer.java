package _11Files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * En este ejemplo probamos el m�todo readAllLines, que se encarga de abrir un fichero,
 * leerlo todo devolviendo su contenido en una coleccion y tambien se encarga 
 * de cerrarlo
 * 
 * Lo que hacemos es leer todo el fichero con readAllLines, y a partir de la coleccion
 * lo mostramos en consola, y ademas lo escribimos en otro fichero
 * 
 * 
 * NOTA !! Si el nuevo fichero quijote2.txt no se visualizan correctamente algunos caracteres
 * cambiarle el tipo a UTF-8 (boton derecho Properties, por defecto eclipse les pone cp1252)
 */
public class Ejemplo3CrearLeer {

	public static void main(String[] args) {
		
		try {
			Path p = Paths.get("./src/_11Files", "quijote.txt");
			Path p2 = Paths.get("./src/_11Files", "quijote2.txt");
			if (Files.exists(p)) {
				
				BufferedWriter bw = Files.newBufferedWriter(p2, Charset.forName("UTF-8"));
				
				// El Charset del fichero debe ser UTF-8
				List<String> lineas = Files.readAllLines(p);
				lineas.forEach((s) ->{
					try {
						bw.write(s);
						bw.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println(s);
				});
				
				bw.close();
			}

		} catch (IOException e) {			
			e.printStackTrace();
		} 

	}

}
