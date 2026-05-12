package ejercicio5;

import java.io.*;
import java.util.Scanner;

/**
 * 5.- Realizar un programa que nos permita el duplicado de un archivo que contenga una imagen. La copia
 * debéis realizarla byte a byte con la ayuda de flujos BufferedInputStream y BufferedOutputStream,
 * debéis utilizar un array de byte (buffer) para la lectura con un tamaño de 16K, y escribir en cada
 * sentencia de escritura el mismo número de bytes que hayáis leído. El nombre/ruta del archivo a copiar
 * debéis solicitarlo por teclado, y el nuevo archivo duplicado se llamará como el original. En esta práctica
 * vamos a realizar una serie de ejercicios cortos, para familiarizarnos y comprender mejor la
 * entrada/salida de datos tanto de teclado/consola como con archivos en disco.
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		BufferedInputStream flujoLectura = null;
		byte[] buffer = new byte[16*1024];
		String fichero = "";
		
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Escribe la ruta del archivo(foto) a copiar: ");
			fichero = sc.next();

			flujoLectura = new BufferedInputStream(new FileInputStream("./src/recursos/" + fichero));
						
			buffer = flujoLectura.readAllBytes();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (flujoLectura!=null) {
				try {
					flujoLectura.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try (BufferedOutputStream flujoEscritura = new BufferedOutputStream(new FileOutputStream("./src/ejercicio5/copia" + fichero ))) {

			flujoEscritura.write(buffer);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
