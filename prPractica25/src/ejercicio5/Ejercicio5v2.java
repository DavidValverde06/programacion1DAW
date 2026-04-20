package ejercicio5;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Ejercicio5v2 {

	public static void main(String[] args) {

		final int TAMBUFFER = 1024*16;

		Path archivoOg = solicitudNombre();
		Path archivoCopy = Path.of("./src/ejercicio5/copia" + archivoOg.getFileName().toString());

		try (InputStream bin = Files.newInputStream(archivoOg, StandardOpenOption.READ);
				OutputStream bout = Files.newOutputStream(archivoCopy, StandardOpenOption.CREATE)) {

			int cantidadBytes = 0;
			byte[] buffer = new byte[TAMBUFFER];

			while ((cantidadBytes = bin.read(buffer, 0, TAMBUFFER)) != -1) {
				bout.write(buffer, 0, cantidadBytes);
				System.out.println("--");
			}
		}
		catch (FileNotFoundException e) {

		}
		catch (IOException e) {

		}
	}

	public static Path solicitudNombre() {

		String nomArchivo;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Nombre del archivo a copiar: ");
			nomArchivo = sc.nextLine();
		}

		Path archiFile = Path.of(nomArchivo);

		if (!Files.exists(archiFile)) {
			System.out.println("Archivo no encontrado");
			System.exit(0);
		}

		return archiFile;
	}
}
