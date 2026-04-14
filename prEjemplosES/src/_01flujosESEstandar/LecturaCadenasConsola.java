package _01flujosESEstandar;
/**
 * Este programa muestra como se utilizan las clases InputStreamReader y BufferedReader para
 * recoger datos del flujo de entrada estándar (teclado) - System.in
 * 
 * Lee cadenas por teclado y las repite por pantalla hasta que el usuario teclea "para"
 * 
 * Esta es una forma alternativa, aunque más compleja, a la recogida de datos de teclado
 * que hemos hecho hasta ahora con la clase Scanner
 * 
 */
import java.io.*;

public class LecturaCadenasConsola {

	/**
	 * Metodo principal
	 */
	public static void main(String args[]) {
		String cad;
		
		System.out.println("Este programa hace eco hasta que escribas 'para': ");
		
		// Abrir un flujo de entrada, de la entrada estándar (System.in), es decir, el teclado
		BufferedReader br = new BufferedReader(
				               new InputStreamReader(System.in));
		  // La línea anterior crea un objeto BufferedReader, que en su constructor 
		  // pide un Reader, para lo cual utilizamos un objeto InputStreamReader que 
		  // a su vez, pide en su constructor un InputStream(el objeto System.in)
		  // En realidad, está encadenando dos flujos
	
		try {
			do {
				cad = br.readLine();  // Leer una l�nea del buffer de entrada

				System.out.println(cad); // Mostrar la l�nea le�a en consola
				    // Observar como el m�todo println pertenece a la clase PrintStream
			} 
			while (!cad.equals("para"));

		}
		catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Se ha producido un error de E/S");
		}
		
		// Cerrar el flujo de entrada
		try {
			br.close();
		} 
		catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Error al cerrar el flujo de entrada");
		}
	}
}







