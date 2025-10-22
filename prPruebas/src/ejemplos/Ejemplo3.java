package ejemplos;

import java.util.Scanner;

/**
 * Ejemplo de lectura de datos con la clase Scanner
 */
public class Ejemplo3 {

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {

		// Definir variables locales
		int num;
		
		// Crear objeto Scanner para poder leer datos de teclado
		Scanner sc = new Scanner(System.in);
		
		// Pedir un numero al usuario
		System.out.print("Introduce un número: ");
		num=sc.nextInt();
		
		// Mostrar un mensaje al usuario indicando el valor tecleado
		System.out.println("El número introducido ha sido: " +  num);
		
		// Cierre del objeto Scanner
		sc.close();
	}

}
