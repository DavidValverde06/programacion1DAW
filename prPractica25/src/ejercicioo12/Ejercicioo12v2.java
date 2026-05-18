package ejercicioo12;

import java.io.*;
import java.nio.file.*;

/**
 * 12.- Realiza un programa que almacene y recupere un objeto persona en un fichero. La clase persona
 * contiene los siguientes atributos: nombre, apellido y teléfono.
 */
public class Ejercicioo12v2 {

	public static void main(String[] args) {

		Path ruta = Path.of("./src/ejercicioo12/objetoPersonaSerializable.txt");
		Persona persona1 = new Persona("David", "Valverde Barea", "123456678");
		Persona persona2;

		almacenarObjetoPersona(persona1);
		persona2 = recuperarObjetoPersona(ruta);

		System.out.println(persona2);
	}

	public static void almacenarObjetoPersona(Persona persona) {

		Path ruta = Path.of("./src/ejercicioo12/objetoPersonaSerializable.txt");

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta.toFile()))) {

			oos.writeObject(persona);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Persona recuperarObjetoPersona(Path ficheroPersonas) {

		Persona persona = null;

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroPersonas.toFile()))) {
			return persona = (Persona)ois.readObject();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return persona;
		}
		catch (IOException e) {
			e.printStackTrace();
			return persona;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return persona;
		}
	}
}
