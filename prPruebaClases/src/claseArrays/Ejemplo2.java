package claseArrays;

import java.util.Arrays;

public class Ejemplo2 {

	public static void main(String[] args) {

		// --------------------------------------------------------------
		// Prueba del método sort y parallelSort
		// --------------------------------------------------------------
		int [] ordenar = {4, 5, 2, 3, 7, 8, 2, 3, 9, 5};
		Arrays.sort(ordenar, 2, 6); // Solo se ordenan los índices 2 a 5
		System.out.println(Arrays.toString(ordenar)); // [4, 5, 2, 3, 7, 2, 3, 8, 9, 5]
		Arrays.sort(ordenar); // Ordena todo el array
		System.out.println(Arrays.toString(ordenar)); // [2, 2, 3, 3, 4, 5, 5, 7, 8, 9]
		System.out.println();
		
		int[] numeros = {5, 2, 8, 1, 3};
		Arrays.parallelSort(numeros);
		System.out.println(Arrays.toString(numeros)); // [1, 2, 3, 5, 8]
		
		// --------------------------------------------------------------
		// Prueba del método binarySearch
		// --------------------------------------------------------------
		int[] datos = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9, 10};
		int index = Arrays.binarySearch(datos, 7);
		System.out.println(index); // 6 (índice del valor 7)
		
	}

}
