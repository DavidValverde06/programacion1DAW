package _07Serializacion;

import java.io.*;
import java.util.Arrays;

/**
 * En este ejemplo se escribe y lee un array de elementos en un fichero.
 * 
 * En este ejemplo estamos utilizamos try-catch con recursos, por lo que 
 * el fichero se cierra de forma automatica
 */

public class Ejemplo2Serializacion {
	
	public static void main(String[] args) {

		// ----------------------------------------------------------		
		// Escritura en el fichero de un array
		// ----------------------------------------------------------
		try (ObjectOutputStream out = new ObjectOutputStream(
										new FileOutputStream("./src/_07Serializacion/arrayOB.txt")))
		{
			int [] array = {1,2,3,4,5,6,7,8};
			out.writeObject(array);			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado al escribir");
		} 
		catch (IOException e) {
			System.out.println("Error de E/S al escribir");
		}
	

		// ----------------------------------------------------------		
		// Lectura del array del fichero
		// ----------------------------------------------------------
		try (ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("./src/_07Serializacion/arrayOB.txt"))) {

			int [] array = (int[])in.readObject();
			System.out.println(Arrays.toString(array));
		} 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado al leer");
		} 
		catch (IOException e) {
			System.out.println("Error de E/S al leer");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("El fichero no almacena un objeto array");
		}

	}
	
	interface Externalizable {
		public void writeExternal(ObjectOutput out) throws IOException;
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException;
	}

}
