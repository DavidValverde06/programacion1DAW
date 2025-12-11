package arraysUnidimensionales;

import java.util.Scanner;

/**
 * 1. Hacer un programa que lea del teclado 10 números enteros y los almacene en un vector. Utilizando
 * este vector, visualizar y sumar los elementos que ocupan las posiciones pares.
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int suma=0;
		int [] miArray = new int[10];

		for (int cont=0;cont<miArray.length;cont++) {
			System.out.print("Introduce un número entero: ");
			miArray[cont] = sc.nextInt();
		}

		System.out.println("\nMi primer Array: ");
		for (int cont=0;cont<miArray.length;cont++) {
			if (cont%2!=0) { // Posición impar en el array (Par para el usuario)
				System.out.print(miArray[cont] + " ");
				suma+=miArray[cont];
			}
		}
		
		System.out.println("\nLa suma de los valores es: " + suma);
		
		sc.close();
	}

}
