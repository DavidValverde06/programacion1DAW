package ejercicio3;

import java.io.*;

/**
 * 3.- En este ejercicio vamos a realizar un programa que nos permite escribir en un fichero de caracteres una
 * cadena que contengan el comienzo del El Quijote. Los caracteres los debéis escribir uno a uno en el
 * fichero con la ayuda de un flujo FileWriter. Modificar el programa para que os escriba la cadena en una
 * sola sentencia de escritura. El archivo que debéis crear se llama introquijote.txt.
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		try (FileWriter flujoEscritura = new FileWriter(new File("./src/ejercicio3/introquijote.txt"))) {
		
			String intro = "En un lugar de la Mancha\n";
			
			for (int cont=0;cont<intro.length();cont++) {
				flujoEscritura.write(intro.charAt(cont));
			}
			
			flujoEscritura.write(intro);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
