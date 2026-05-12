package _03ESFicheroBytes;
/**
 * Este programa permite leer los datos escritos previamente
 * con la clase "Ejemplo1FileOutputStream", y los muestra por pantalla.
 * 
 * Utilizaremos la clase FileInputStream, y el m�todo read para leer los 
 * bytes de uno en uno
 * 
 */

import java.io.*;
import java.util.Arrays;

public class Ejemplo2FileInputStream {

	public static void main(String[] args) {
		
		FileInputStream f = null;
		String s = "";
		int caracter;	
		
		try {
			// Apertura del flujo de entrada o lectura
			f = new FileInputStream("./src/_03ESFicheroBytes/datos1.txt");

			// Primer planteamiento, averiguando el tamaño del flujo
	//		int size = f.available();
			
	//		for (int i=0; i<size; i++)
	//			s = s + (char)f.read();  // Hay que hacer un casting a char, ya que nos devuelve
	//		                             // un valor int (valor ascii)
			
			// Segundo planteamiento, leyendo caracter a caracter, hasta alcanzar el final de 
			// fichero (valor -1)
//			caracter = f.read();
//			while (caracter!=-1) {
//				s = s + (char)caracter;  // Hay que hacer un casting a char, ya que nos devuelve
//										 // un valor int (valor ascii)
//				caracter = f.read();
//			}
			
			// Tercer planteamiento, idem al anterior, pero con lectura en la condición del bucle
	//		while ((caracter=f.read())!=-1) {
	//			s = s + (char)caracter;
	//		}
			
			
			// Cuarto planteamiento
			byte [] array = f.readAllBytes();
			for (int cont=0; cont<array.length; cont++) {
				s = s + (char)array[cont];
			}
		
			System.out.println("El contenido del fichero es:\n"+s);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	/*	finally {
			try {
				if (f!=null) f.close();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		*/
		finally {
			try {
				f.close();
			}
			catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
			}
			catch(NullPointerException e) {
				System.out.println("El archivo no estaba abierto");
			}
		}
		
		// En las lineas anteriores se pueden ver dos posibles planteamientos del bloque finally
		// en el que se cierra el archivo
	}
}





