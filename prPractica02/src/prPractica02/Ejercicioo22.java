package prPractica02;

import java.util.Scanner;

/**
 * 22. Programa que calcula la media aritmética de una serie de números
 * introducidos por teclado, que finaliza con la introducción del valor 0.
 */

public class Ejercicioo22 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce números: ");

		float suma=0,cont=-1;
		int num;
		
		do {
			System.out.print("Introduce un número (escribe 0 para salir): ");
			num = sc.nextInt();
			cont++;
			suma=suma+num;
		} 
		while (num != 0);

		System.out.println("\nSuma de los números introducidos: " + (int)suma);
		System.out.println("Cantidad de números introducidos: " + (int)cont);
		System.out.println("Media aritmética: " + (float)(suma/cont));
		
		sc.close();
	}

}
