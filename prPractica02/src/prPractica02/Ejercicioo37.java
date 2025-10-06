package prPractica02;

import java.util.Scanner;

/**
 * 37. Realizar un algoritmo que calcule la media aritmética de una lista de números que se introducen por
	   teclado. El proceso finalizará con la introducción del número 0 y se usará en la media el valor absoluto
	   de los números negativos, si ya lo hicisteis en el ejercicio 22, no es necesario que lo volváis a hacer.
 */

public class Ejercicioo37 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num=1,suma=0,cont=0;
		
		while (num!=0) {
			System.out.print("Introduce un número: ");
			num=sc.nextInt();
			num=Math.abs(num);

			suma=suma+num;
			cont++;
		}
		
		System.out.println("\nSuma de los números introducidos: " + (int)suma);
		System.out.println("Cantidad de números introducidos: " + (int)cont);
		System.out.println("Media aritmética: " + (float)(suma/cont));
		
		sc.close();
	}

}
