package _03ESFicheroBytes;

/**
 * Escritura en un fichero utilizando la clase FileOutputStream, 
 * la cual permite escribir bytes en un fichero.
 */

import java.io.*;
public class Ejemplo1FileOutputStream {

	public static void main(String[] args) {
		
		FileOutputStream flujoSalida = null;
		String s = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, " +
				   "no ha mucho tiempo que vivía un hidalgo de los de lanza en " +
				   "astillero, adarga antigua, rocín flaco y galgo corredor...";
		
		try {
			// Apertura del flujo de salida que será el archivo datos1.txt
	//		flujoSalida = new FileOutputStream("datos1.txt",true);
	//		flujoSalida = new FileOutputStream(new File("./src/_03ESFicheroBytes/datos1.txt"),true);
			flujoSalida = new FileOutputStream(new File("./src/_03ESFicheroBytes/datos1.txt"));
			
			// Escribir cada caracter de la cadena, en el archivo
			for (int i=0; i<s.length(); i++) {
				flujoSalida.write(s.charAt(i));
			}
						
			flujoSalida.write('\n'); // Añadir un salto de linea 
			
	        byte[] datos = {65, 66, 67, 68}; // Bytes que representan 'A', 'B', 'C', 'D'
	        flujoSalida.write(datos);
	        
	        flujoSalida.write('\n'); // Añadir un salto de linea
	        
			System.out.println("El fichero ha sido creado");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (flujoSalida!=null) flujoSalida.close();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
//		finally {
//			try {
//				flujoSalida.close(); 
//			}
//			catch (IOException e) {
//				e.printStackTrace();
//				System.out.println("Error de E/S");
//			}
//			catch(NullPointerException e) {
//				System.out.println("El archivo no estaba abierto");
//			}
//		}
	}
}
