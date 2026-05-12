package _04ESFicheroCaracter;

/**
 * Este ejemplo muestra la utilización de las clases FileReader y FileWriter
 *
 * ESCRITURA
 * El programa tiene almacenadas una serie de personas en una estructura
 * amigos que es un vector de objetos String. Los datos del vector se
 * graban en un fichero "amigos.txt", cada persona en una línea, para ello
 * se graba el retorno de carro y de línea (\r\n) 
 * 
 * 
 * LECTURA
 * Para la lectura del fichero se utiliza un objeto FileReader. Como queremos
 * leer linea a linea utilizamos un objeto de la clase BufferedReader que 
 * tiene el metodo readLine(), que permite leer una linea de un flujo de 
 * entrada.
 */

import java.io.*;
public class Ejemplo3BufferedWriterBufferedReader {

	public static void main(String[] args) {
		
		// ----------------------------------------------------------		
		// Escritura en el fichero
		// ----------------------------------------------------------
		String [] amigos = {"Marina", "José Luis", "Pedro", "María"};
		
		BufferedWriter flujoSalida = null;
		try {
			flujoSalida = new BufferedWriter(
								new FileWriter(
									new File("./src/_04ESFicheroCaracter/amigos.txt")));
			
	/*		for (String s : amigos) {
				// Escribir el nombre del amigo
				flujoSalida.write(s,0,s.length());
				
				// Escribir un salto de línea
			//	flujoSalida.write("\r\n");  // \r retorno de carro, \n nueva linea
			 						// No recomendable, ya que la configuracion varia segun la plataforma
				flujoSalida.newLine();  // Mejor asi
			}
	*/
			
			for (int i=0; i<amigos.length; i++) {
				flujoSalida.write(amigos[i], 0, amigos[i].length());
				flujoSalida.newLine();
				flujoSalida.write(amigos[i]);
				flujoSalida.newLine();  // Mejor asi
			}
    
		}
		catch (IOException e) {
			System.out.println("Error de E/S");
		}
		finally {
			try {
				if (flujoSalida!=null) flujoSalida.close();
			} 
			catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
			}
		}
		
		
		// ----------------------------------------------------------		
		// Lectura del fichero
		// ----------------------------------------------------------
		File fichero = new File("./src/_04ESFicheroCaracter/amigos.txt");
		
		BufferedReader flujoLectura = null;
		
		if (fichero.exists()) {
			try {
				flujoLectura = new BufferedReader(
									new FileReader(fichero));
				
				String cadenaLeida = flujoLectura.readLine();
				while (cadenaLeida!=null) {
					System.out.println(cadenaLeida);
					cadenaLeida=flujoLectura.readLine();
				}
								
//				while ((s=flujoLectura.readLine())!=null) {
//					System.out.println(s);
//				}
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
