package _04ESFicheroCaracter;
/**
 * Este programa permite leer los datos escritos previamente
 * con la clase "Ejemplo1FileWriter", y los muestra por pantalla.
 * 
 * Utilizaremos la clase FileReader.
 */

import java.io.*;

public class Ejemplo2FileReader {

	public static void main(String[] args) {
		
		FileReader f = null;
		String s = "";
		int caracter;	
		
		try {
			f = new FileReader("./src/_04ESFicheroCaracter/datos.txt");

			caracter = f.read();
			while (caracter!=-1) {
				s = s + (char)caracter;
				caracter = f.read();
			}
			System.out.println("El contenido del fichero es:\n"+s);
			
		/*	
		   while ((caracter = f.read()) != -1) {
                System.out.print((char) caracter);
            }
		 */
			
		
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





