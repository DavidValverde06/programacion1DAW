/**
 * 
 */
package _03ESFicheroBytes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * En este ejemplo se escriben los 100 primeros números (de 0 a 99) como bytes en un fichero
 * 
 * Realizar la prueba cambiándolo a 1000 números, al tratarse de bytes, sólo se queda
 * con el primer byte, del valor int, observar el resultado, con ayuda del siguiente 
 * ejemplo (Ejemplo6FilesInputStream)
 *
 */
public class Ejemplo5FileOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		OutputStream fOut = null;
		
		try {
			fOut = new FileOutputStream("./src/_03ESFicheroBytes/numeros.dat");
			for(int i = 0; i < 100; i++) {
				fOut.write(i);
			}	
			System.out.println("Fichero creado");
		} 
		catch (FileNotFoundException e) {			
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (fOut != null)
				try {
					fOut.close();
				} 
				catch (IOException e) {					
					e.printStackTrace();
				}
		}
		
		

	}

}
