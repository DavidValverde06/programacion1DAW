package _03ESFicheroBytes;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Este ejemplo lee, los número escritos en el ejemplo anterior
 * 
 */
public class Ejemplo6FilesInputStream {

	public static void main(String[] args) {
		
		FileInputStream f = null;
		String s = "";
		int numero;	
		
		try {
			// Apertura del flujo de entrada o lectura
			f = new FileInputStream("./src/_03ESFicheroBytes/numeros.dat");

			while ((numero=f.read())!=-1) {
				s = s + numero + " ";
			}
			
			System.out.println("El contenido del fichero es:\n"+s);
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
