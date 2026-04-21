package ejercicio7;

import java.io.File;
import java.util.Scanner;

/**
 * 7.- Programa que solicita al usuario un nombre de archivo de texto, y lo copia en otro nuevo archivo en
 * forma encriptada, siguiendo el cifrado Cesar1
 * . Posteriormente recorrerá el nuevo archivo y lo mostrará
 * al usuario sin encriptar. 
 */
public class Ejercicio7 {

	public static void main(String[] args) {


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
