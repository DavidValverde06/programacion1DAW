package ejercicio0;

import java.io.*;

public class Ejercicio0 {

	public static void main(String[] args) {

		System.out.println("Inicio del programa");

		// Abrir flujo de escritura con un try con recursos para que se cierre de forma automatica
		try (BufferedWriter flujoEscritura = new BufferedWriter(
				new FileWriter(
						new File("./src/ejercicio0/fichero.txt"), true))) {

			System.out.println("Escribiendo datos");

			flujoEscritura.write("Primera linea de escritura en el archivo");
			flujoEscritura.write(9);
			flujoEscritura.write(65);
			flujoEscritura.write('X');
			flujoEscritura.write("\r\n"); // Añadir un salto de linea (NO ACONSEJABLE DE ESTA FORMA)
			flujoEscritura.write("Otra linea");
			flujoEscritura.newLine(); // Preferible añadir asi las lineas en blanco
			flujoEscritura.write("Fin");
			flujoEscritura.newLine();

			System.out.println("Fin programa");

		}
		catch (FileNotFoundException e) {
			System.out.println("Problema al abrir el archivo");
		}
		catch (IOException e) {
			System.out.println("Error de E/S");
		}
	}

}
