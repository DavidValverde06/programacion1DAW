package ejercicio7;

import java.io.*;
import java.util.*;

import recursos.UtilCarCad;

/**
 * 7.- Programa que solicita al usuario un nombre de archivo de texto, y lo copia en otro nuevo archivo en
 * forma encriptada, siguiendo el cifrado Cesar1
 * . Posteriormente recorrerá el nuevo archivo y lo mostrará
 * al usuario sin encriptar. 
 */
public class Ejercicio7 {

	public static void main(String[] args) {

		String fichero = "";
		String encriptado = "";

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Escribe el archivo a cifrar: ");
			fichero = sc.next();
		}

		try (BufferedReader flujoLectura = new BufferedReader(new FileReader("./src/recursos/" + fichero))) {

			encriptado = UtilCarCad.encriptaCadena(flujoLectura.readAllAsString());

		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter flujoEscritura = new BufferedWriter(new FileWriter(new File("./src/ejercicio7/datosEncriptados.txt")))) {

			flujoEscritura.write(encriptado);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader flujoLectura = new BufferedReader(new FileReader("./src/ejercicio7/datosEncriptados.txt"))) {

			System.out.println("\n" + UtilCarCad.desencriptaCadena(flujoLectura.readAllAsString()));

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
