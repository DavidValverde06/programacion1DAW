package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 3. Programa que determine cuantas cifras posee un número entero positivo dado como entrada a
	  nuestro programa por teclado. Repetir el proceso cuantas veces se quiera.
 */

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long num;

		System.out.print("Introduce un número (0 para salir): ");
		num=sc.nextLong();

		while (num!=0) {

			if (num<0) {
				System.out.println("ERROR - Introduce un número positivo\n");
			}
			
			System.out.println("Tiene " + String.valueOf(num).length() + " cifras");
			
			System.out.print("Introduce un número (0 para salir): ");
			num=sc.nextInt();

		}

		System.out.println("\nFIN DE PROGRAMA");

		sc.close();
	}

}
