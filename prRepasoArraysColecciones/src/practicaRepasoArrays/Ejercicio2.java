package practicaRepasoArrays;

import java.util.Arrays;

/**
 * 2. Hacer un algoritmo que seleccione el mayor de los números de una lista numérica de 20 elementos,
 * generados aleatoriamente y lo lleve a la última posición, no se debe perder ninguno de los números de
 * la lista. 
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		int numElementos = 20;
		int numMaximo = 0;
		int[] array = new int[numElementos];

		for (int cont=0;cont<array.length;cont++) {
			array[cont] = (int)(Math.random()*50);
			numMaximo = array[cont];
		}

		for (int cont=0;cont<array.length;cont++) {
			if (numMaximo<array[cont]) {
				numMaximo=array[cont];
			}
		}

		System.out.println(Arrays.toString(array));

		System.out.println("Número máximo: " + numMaximo);

		// Abrir hueco en el array para insertar el numMaximo

		System.out.println(Arrays.toString(array));

	}

}
