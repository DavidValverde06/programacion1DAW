package _04ESFicheroCaracter;
/**
 * Escritura en un fichero utilizando la clase FileWriter, 
 * la cual permite escribir caracteres en un fichero.
 * 
 * Escribiremos la cadena s, de dos formas diferentes:
 *   - Caracter a caracter
 *   - La cadena completa
 */

import java.io.*;
public class Ejemplo1FileWriter {

	public static void main(String[] args) {
		
		FileWriter f = null;
		String s = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, " +
				   "no ha mucho tiempo que vivia un hidalgo de los de lanza en " +
				   "astillero, adarga antigua, rocin flaco y galgo corredor...";
		
		try {
			f = new FileWriter("./src/_04ESFicheroCaracter/datos.txt",true);
			// Escritura caracter a caracter
			for (int i=0; i<s.length(); i++)
				f.write((byte)s.charAt(i));
			
			// Escritura de la cadena completa
			f.write("\n-------\n");
			f.write(s);
			f.write("\n");
		
			System.out.println("El fichero ha sido creado");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if (f!=null) f.close();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
