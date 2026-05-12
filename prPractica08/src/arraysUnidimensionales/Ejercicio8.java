package arraysUnidimensionales;

import java.util.Scanner;

/**
 * 8.- Hacer un programa que:
 * - Cree y cargue un array unidimensional de 12 elementos de tipo entero.
 * - Recorra ese array metiendo en un segundo array todos aquellos elementos que sean pares y
 * mayores que 25.
 * - Muestre en pantalla el contenido de los dos arrays unidimensionales.
 */

public class Ejercicio8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tamanioPrimerArray = 12;
		int tamanioSegundoArray = 0;
		int contador = 0;

		int[] array1 = new int[tamanioPrimerArray];
		int[] array2;

		System.out.println("=== Introduce 12 números enteros ===");
		for (int cont=0;cont<array1.length;cont++) {
			System.out.print("Elemento " + (cont+1) + ": ");
			array1[cont]=sc.nextInt();
			if (array1[cont]%2==0 && array1[cont]>25) {
				tamanioSegundoArray++;
			}
		}

		array2 = new int[tamanioSegundoArray];

		for (int cont=0;cont<array1.length;cont++) {
			if (array1[cont]%2==0 && array1[cont]>25) {
				array2[contador] = array1[cont];
				contador++;
			}
		}

		System.out.println("\nPrimer array de 12 elementos de tipo entero: ");
		for (int cont=0;cont<array1.length;cont++) {
			System.out.print(array1[cont] + " ");
		}

		System.out.println("\n\nSegundo array con los elementos pares y mayores de 25 del primer array: ");
		for (int cont=0;cont<array2.length;cont++) {
			System.out.print(array2[cont] + " ");
		}

		sc.close();
	}

}
