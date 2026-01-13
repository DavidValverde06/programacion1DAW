package arraysUnidimensionales;

import java.util.Arrays;

/**
 * 7.- Crear e imprimir una lista unidimensional de 50 elementos con números aleatorios entre 1 y 100 de tal
 * forma que no se repita ninguno.
 */

sin hacer

public class Ejercicio7 {

	public static void main(String[] args) {
		byte tamanioArray = 10;
		int[] array = new int[tamanioArray];
		int numRandom;
		boolean repetir=true;

		//	Generas un número aleatorio.
		//
		//	Antes de meterlo, recorres el array para ver si ya existe.
		//
		//	Si existe, repites el intento.
		//
		//	Si no existe, lo guardas.

		for(int cont=0;cont<array.length;cont++) {
			array[cont] = (int)(Math.random()*10);
			while (repetir) {
				repetir=false;
				numRandom=(int)(Math.random()*10);
				if (numRandom!=array[cont]) {
					array[cont]=numRandom;
				}
			}
		}

		System.out.println(Arrays.toString(array));

		Arrays.sort(array);

		System.out.println();

		System.out.println(Arrays.toString(array));
	}

}
