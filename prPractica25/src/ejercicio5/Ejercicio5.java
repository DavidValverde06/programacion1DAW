package ejercicio5;

import java.io.*;
import java.util.*;

/**
 * 5.- Realizar un programa que nos permita el duplicado de un archivo que contenga una imagen. La copia
 * debéis realizarla byte a byte con la ayuda de flujos BufferedInputStream y BufferedOutputStream,
 * debéis utilizar un array de byte (buffer) para la lectura con un tamaño de 16K, y escribir en cada
 * sentencia de escritura el mismo número de bytes que hayáis leído. El nombre/ruta del archivo a copiar
 * debéis solicitarlo por teclado, y el nuevo archivo duplicado se llamará como el original.
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		final int TAMBUFFER = 1024*16;
		BufferedInputStream bis = null;
		BufferedOutputStream bos= null;

		File archivoOriginal = solicitudNombre();

		try {
			bis = new BufferedInputStream(
					new FileInputStream(archivoOriginal));

			bos = new BufferedOutputStream(new FileOutputStream("./src/ejercicio5/copia" + archivoOriginal.getName()));

			int cantidadBytes = 0;
			byte[] buffer = new byte[TAMBUFFER];

			while ((cantidadBytes = bis.read(buffer, 0, TAMBUFFER)) != -1) {

				bos.write(buffer, 0, cantidadBytes);
				System.out.println("--");
			}
		}
		catch (FileNotFoundException e) {
			
		}
		catch (IOException e) {
			
		}
	}

	public static File solicitudNombre() {

		String nomArchivo;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Nombre del archivo a copiar: ");
			nomArchivo = sc.nextLine();
		}

		File archiFile = new File(nomArchivo);

		if (!archiFile.exists()) {
			System.out.println("Archivo no encontrado");
			System.exit(0);
		}

		return archiFile;
	}
}
