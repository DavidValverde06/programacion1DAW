package ejemplo4;
import java.io.*;

public class Ejemplo4ExV2 {

	/**
	 * Método que permite leer un fichero y mostrar su contenido
	 * en consola, lleva el control de excepciones
	 * @param nombre
	 */
	public static void leerFichero(String nombre) 
	{ 
		FileInputStream fichero=null; 
		BufferedReader br=null; 
		String linea=null; 
		try 
		{ 
			// Crear un objeto para poder acceder al fichero
			fichero=new FileInputStream(nombre);
			br=new BufferedReader(new InputStreamReader(fichero));

			// Leer la primera linea del fichero
			linea=br.readLine(); 

			// Leer resto de lineas del fichero
			while (linea!=null) { 
				System.out.println(linea); 
				linea=br.readLine();
			}

			// Cerrar el fichero
			if (br!=null) {
				br.close();
			}
		}

		catch (FileNotFoundException e) { 
			System.out.println("FICHERO NO ENCONTRADO");
			e.printStackTrace(); 
		} 

		catch (IOException e) { 
			System.out.println("SE HA PRODUCIDO UN ERROR EN EL ACCESO AL FICHERO");
			e.printStackTrace(); 
		} 

		// IMPORTANTE!! El orden de los catch tiene que ir de los más específicos a los
		// más genéricos, podéis hacer la prueba en este ejemplo cambiandolos de orden
	}

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {

		leerFichero("datos.txt");

	}

}
