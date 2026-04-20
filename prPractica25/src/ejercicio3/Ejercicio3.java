package ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 3.- En este ejercicio vamos a realizar un programa que nos permite escribir en un fichero de caracteres una
 * cadena que contengan el comienzo del El Quijote. Los caracteres los debéis escribir uno a uno en el
 * fichero con la ayuda de un flujo FileWriter. Modificar el programa para que os escriba la cadena en una
 * sola sentencia de escritura. El archivo que debéis crear se llama introquijote.txt.
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		FileWriter fw = null;

		String intro = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme camión";

		try {
			// Apertura del flujo de escritura de caracteres
			fw = new FileWriter(new File("./src/ejercicio3/introQuijote.txt"),Charset.defaultCharset(),true);

			// Escribir la cadena completa
			fw.write(intro);
			fw.write('\n');

			// Escribir caracter a caracter
			for (char c:intro.toCharArray()) {
				fw.write(c);
			}
			fw.write('\n');
			
			System.out.println("Fichero creado");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			}
			catch (Exception e2) {

			}
		}
	}

}
