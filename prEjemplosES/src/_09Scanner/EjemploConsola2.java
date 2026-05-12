package _09Scanner;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase que muestra un ejemplo de lectura de datos enteros de teclado
 * En este caso se ha utilizado try-con-recursos, por lo que no es necesario
 * cerrar el flujo abierto.
 * 
 * Ademas se esta controlando la excepcion de valor no v�lido, para que el programa
 * continue funcionando
 * 
 * @author Profesor
 */
public class EjemploConsola2 {

	/**
	 * M�todo principal
	 * @param args --> Argumentos de entrada al programa
	 */
	public static void main(String[] args) {
		
		// Definir una variable para recoger un numero
		int numero = 0;
		
		// Crear un objeto de la clase Scanner para la lectura 
		// desde la entrada estandar (teclado)
		try (Scanner sc = new Scanner(System.in)) {

			do {

				// Mostrar un mensaje en consola para solicitar el dato
				System.out.print("Introduzca un número: ");

				try {
					// Recoger el dato de teclado de tipo entero
					numero = sc.nextInt();
	
					// Mostrar el consola el n�mero introducido
					System.out.println("El número que se ha tecleado es: "+numero);
				}
				catch (InputMismatchException e) {
					System.out.println("Valor no válido");
					sc.nextLine();  // Limpiar buffer de teclado
				}
				
			}
			while (numero !=0);
		}  // end try-con-recursos
	}
}
