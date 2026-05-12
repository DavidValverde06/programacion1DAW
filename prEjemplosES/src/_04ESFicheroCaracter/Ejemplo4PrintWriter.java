package _04ESFicheroCaracter;
/**
 * Este ejemplo muestra la utilizacion de las clases FileReader FileWriter y PrintWriter
 *
 * ESCRITURA
 * En este caso, aunque es muy similar al anterior, como hemos utilizado PrintWriter,
 * me permite utilizar los metodos print y println para escribir en el fichero. 
 * 
 * LECTURA
 * Para la lectura del fichero se utiliza un objeto FileReader. Como queremos
 * leer linea a linea utilizamos un objeto de la clase BufferedReader que 
 * tiene el metodo readLine(), que permite ller una linea de un flujo de 
 * entrada.
 */

import java.io.*;
public class Ejemplo4PrintWriter {

	public static void main(String[] args) {
		
		// ----------------------------------------------------------		
		// Escritura en el fichero
		// ----------------------------------------------------------
		String [] amigos = {"Marina", "José Luis", "Pedro", "María"};
		
		PrintWriter flujoSalida = null; 
		try {
//			flujoSalida = new PrintWriter(
//			            		new BufferedWriter(
//			                		new FileWriter(
//			                    		new File("./src/_04ESFicheroCaracter/amigos2.txt"))));
		
			flujoSalida = new PrintWriter(
		           	          new File("./src/_04ESFicheroCaracter/amigos2.txt")); 
			
			for (int i=0; i<amigos.length; i++) {
				flujoSalida.println(amigos[i]);
			}			
			 	// Al utilizar la clase PrintWriter podemos utilizar los metodos print y println 
			    // para escribir datos en el fichero
			  
			
			// Añadirle algo mas al fichero
			double numero = 12.567;
			flujoSalida.println("El número es "+numero);
			flujoSalida.println("FIN DE ARCHIVO");
		}
		catch (IOException e) {
			System.out.println("Error de E/S");
		}
		finally {
			if (flujoSalida!=null) flujoSalida.close();
		}
		
		// ----------------------------------------------------------		
		// Lectura del fichero
		// ----------------------------------------------------------
		File fichero = new File("./src/_04ESFicheroCaracter/amigos2.txt");
		BufferedReader flujoLectura = null;
		if (fichero.exists()) {
			try {
				flujoLectura = new BufferedReader(
									new FileReader(fichero));
				String s = "";
				while ((s=flujoLectura.readLine())!=null) {
					System.out.println(s);
				}
			}
			catch (IOException e) {
				System.out.println("Error de E/S");
			}
			finally {
				try {
					if (flujoLectura!=null) flujoLectura.close();
				} 
				catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}
		}

	}

}
