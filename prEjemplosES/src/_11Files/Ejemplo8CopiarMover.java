package _11Files;

import java.io.IOException;
import java.nio.file.*;

public class Ejemplo8CopiarMover {

	public static void main(String[] args) {
        Path origen = Paths.get("./src/_11Files/prueba.txt");
        Path destino = Paths.get("./src/_11Files/prueba_copia.txt");

        try {
            // Copiar archivo
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado con éxito.");

            // Mover archivo
            Path nuevoDestino = Paths.get("./src/prueba_copia.txt");
            Files.move(destino, nuevoDestino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo movido con éxito.");
        } 
        catch (IOException e) {
            System.out.println("Error al copiar o mover el archivo: " + e.getMessage());
        }

	}

}
