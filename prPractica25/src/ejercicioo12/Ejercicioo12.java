package ejercicioo12;

import java.io.*;
import java.nio.file.*;

/**
 * 12.- Realiza un programa que almacene y recupere un objeto persona en un fichero. La clase persona
 * contiene los siguientes atributos: nombre, apellido y teléfono.
 */
public class Ejercicioo12 {

	public static void main(String[] args) {

		Path ruta = Path.of("./src/ejercicioo12/objetoPersona.txt");
		Persona persona1 = new Persona("David", "Valverde Barea", "123456678");
		Persona persona2;

		almacenarObjetoPersona(persona1);
		persona2 = recuperarObjetoPersona(ruta);

		System.out.println(persona2);
	}

	public static void almacenarObjetoPersona(Persona persona) {

		try (BufferedWriter flujoEscritura = Files.newBufferedWriter(Path.of("./src/ejercicioo12/objetoPersona.txt"))) {

			String linea = persona.toString();
			String[] arrayPalabras = linea.split(",");

			for (int cont=0;cont<arrayPalabras.length;cont++) {
				flujoEscritura.write(arrayPalabras[cont]);
				flujoEscritura.write(",");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Persona recuperarObjetoPersona(Path ficheroPersonas) {

		try (BufferedReader flujoLectura = Files.newBufferedReader(ficheroPersonas)) {

			String linea,nombre="",apellido="",telefono="";
			String[] arrayPalabras;

			while ((linea = flujoLectura.readLine()) != null) {

				arrayPalabras = linea.split(",");

				nombre = arrayPalabras[0];
				apellido = arrayPalabras[1];
				telefono = arrayPalabras[2];
			}

			return new Persona(nombre, apellido, telefono);

		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
