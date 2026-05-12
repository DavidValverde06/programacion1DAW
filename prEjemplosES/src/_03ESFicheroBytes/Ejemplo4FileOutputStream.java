package _03ESFicheroBytes;

import java.io.*;

/**
 * Este ejemplo lee el texto que el usuario introduce por teclado y lo va escribiendo 
 * en un fichero. 
 * Utiliza para la escritura un buffer de 64 bytes.
 * @author Usuario
 *
 */
public class Ejemplo4FileOutputStream {


	public static void main(String[]  argumentos) {
		final int TAMANIO_BUFFER = 64;
		byte buffer[] = new byte[TAMANIO_BUFFER];
		int NumBytes; 

		FileOutputStream ficheroDestino = null;
		try {
			ficheroDestino = new FileOutputStream("./src/_03ESFicheroBytes/Salida.txt");

			System.out.println("A continuación vaya tecleando el contenido del nuevo arhivo");
			System.out.println("Introduzca una línea en blanco para finalizar");
			do {
				NumBytes = System.in.read(buffer);  // Lectura de teclado
				ficheroDestino.write(buffer,0,NumBytes);  // Escribe en el fichero
			}
			// En la condición de terminación del bucle se comprueba si el usuario
			// ha pulsado la tecla "enter", introduciendo una nueva línea en blanco
			// (Character.LINE_SEPARATOR), que se corresponde con el valor 13.
			while (buffer[0] != Character.LINE_SEPARATOR);

		} 

		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		catch (IOException e){  
			System.out.println("Error escribiendo los datos o cerrando el fichero");   
		}
		finally {
			try {
				if (ficheroDestino!=null) ficheroDestino.close();
			} 
			catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		}
	}
}
