package ejemplo4;
import java.io.*;

public class Ejemplo4ExV1 {

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

		// ------------------------------------------------------------
		// --------------- Apertura del fichero -----------------------
		// ------------------------------------------------------------
		try { 
			// Crear un objeto para poder acceder al fichero
			fichero=new FileInputStream(nombre);
			br=new BufferedReader(new InputStreamReader(fichero));
		} 
		catch (FileNotFoundException e) { 
			System.out.println("FICHERO NO ENCONTRADO");
			e.printStackTrace(); 
		} 

		// ------------------------------------------------------------
		// ---------- Lectura de la primera linea del fichero ---------
		// ------------------------------------------------------------
		try { 
			// Leer la primera linea del fichero
			linea=br.readLine(); 
		} 
		catch (IOException e) { 
			System.out.println("SE HA PRODUCIDO UN ERROR EN LA LECTURA");
			e.printStackTrace(); 
		} 

		// ------------------------------------------------------------
		// ---------- Lectura del resto de lineas del fichero ---------
		// ------------------------------------------------------------
		while (linea!=null)  { // Recorrer el fichero hasta que no haya mas lineas

			System.out.println(linea); // Imprimo en consola la linea leida
			try { 
				linea=br.readLine(); // Leo una nueva linea
			} 
			catch (IOException e) { 
				System.out.println("SE HA PRODUCIDO UN ERROR EN LA LECTURA");
				e.printStackTrace(); 
			} 
		} 


		// ------------------------------------------------------------
		// ----------------------- Cierre del fichero -----------------
		// ------------------------------------------------------------
		if (br!=null) {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("SE HA PRODUCIDO UN ERROR AL CERRAR EL FICHERO");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo principal
	 * @param args
	 */
	public static void main(String[] args) {

		leerFichero("datos.txt");

	}

}
