package ejercicio4;

import java.io.*;
import java.util.*;

/**
 * 4.- Vamos a desarrollar un ejercicio que nos permita escribir una serie de cadenas de texto que tendremos
 * almacenadas en una colección tipo List<String>. Iremos recorriendo dicha colección y escribiendo cada
 * cadena en el fichero con la ayuda de un flujo BufferedWriter.
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter("./src/ejercicio4/ejercicio4.txt"))) {
			
			String[] arrayCadenas = {"Hola","Adios","Que tal"};
			
			ArrayList<String> miColeccion = new ArrayList<String>(Arrays.asList(arrayCadenas));
			
			for (String cadena : miColeccion) {
				flujoEscritura.write(cadena);
				flujoEscritura.newLine();
			}
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
