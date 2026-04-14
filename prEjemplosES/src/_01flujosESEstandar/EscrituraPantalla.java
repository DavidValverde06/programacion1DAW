package _01flujosESEstandar;
/**
 * En este programa se utiliza el objeto PritWriter, el cual es redirigido a la pantalla.
 * 
 * En realidad PrintWriter, es un flujo de salida, hacia la salida estándar que es la 
 * consola (System.out)
 * 
 * También se utilizan los métodos write, print, println y flush (vacia el buffer de contenido).
 * 
 */

import java.io.*;

public class EscrituraPantalla {

	public static void main(String[] args) {
		
		// Abrir un flujo de salida a la salida estándar (System.out), es decir, la consola
		PrintWriter pantalla = new PrintWriter(System.out);
		char [] array = {'a','m','a','p','o','l','a','s'};
		
		String str = new String("Ya llegó la primavera con las");
		pantalla.write(str);
		pantalla.print(" ");
		pantalla.write(array);
		pantalla.println("");
	//	pantalla.flush();  // Limpiar el buffer de salida
		   // Probar a anular esta sentencia, en ese caso la información se quedará en
		   // el buffer, y no la mostrará, excepto si se cierra el flujo de salida, en
		   // cuyo caso devolverá la información que tenga en el buffer
		
		pantalla.close();  // Cerrar el flujo de salida
	}
}
