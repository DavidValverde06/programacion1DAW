package arraysUnidimensionales;

import java.util.Scanner;

/**
 * 4.- Escribe un programa que lea 8 números por teclado y que luego los muestre en orden inverso, es decir,
 * el primero que se introduce es el último en mostrarse y viceversa.
 */

public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int TAMANIO=8;
		int [] miArray = new int[TAMANIO];

		for (int cont=0;cont<miArray.length;cont++) {
			System.out.print("Introduce un número entero: ");
			miArray[cont] = sc.nextInt();
		}

		System.out.println("\nArray: ");
		for (int cont=0;cont<miArray.length;cont++) {
			System.out.print(miArray[cont] + " ");
		}
		
		System.out.println("\nArray inverso: ");
		for (int cont=miArray.length-1;cont>=0;cont--) {
			System.out.print(miArray[cont] + " ");
		}
		
		sc.close();
	}

}
