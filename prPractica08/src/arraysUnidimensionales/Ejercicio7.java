package arraysUnidimensionales;

import java.util.Arrays;

/**
 * 7.- Crear e imprimir una lista unidimensional de 50 elementos con números aleatorios entre 1 y 100 de tal
 * forma que no se repita ninguno.
 */

public class Ejercicio7 {

	public static void main(String[] args) {
		int[] array = new int[50];
		int numRandom;
		boolean repetir=true;

		for (int cont=0;cont<array.length;cont++) {
			do {
				repetir=false;
				numRandom = (int)(Math.random()*100)+1;

				for (int cont2=0;cont2<array.length;cont2++) {
					if (numRandom==array[cont2]) {
						repetir=true;
					}
				}
				array[cont]=numRandom;
			}
			while (repetir);
		}

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

	}

}
