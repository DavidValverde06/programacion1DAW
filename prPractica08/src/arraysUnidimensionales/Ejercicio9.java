package arraysUnidimensionales;

import java.util.Arrays;

/**
 * 9.- Hacer un programa que genere un array de 15 números enteros de forma aleatoria, y a continuación
 * invierta internamente los números del array, no se puede utilizar un array auxiliar.
 */

public class Ejercicio9 {

	public static void main(String[] args) {

		int[] array = new int[15];
		int contador = array.length-1;
		int aux;
		
		for (int cont=0;cont<array.length;cont++) {
			array[cont] = (int)(Math.random()*100)+1;
//			array[cont] = (cont+1);
		}

		System.out.println("Array: ");
		System.out.println(Arrays.toString(array));

		System.out.println("\nArray invertido: ");
		for (int cont=array.length-1;cont>=0;cont--) {
			System.out.print(array[cont] + ", ");
		}

		/**
		 * Invertir array internamente
		 */
		for (int cont=0;cont<array.length/2;cont++) {
			aux=array[cont];
			array[cont] = array[contador];
			array[contador] = aux;
			contador--;
		}
		
		System.out.println("\n\nArray invertido internamente: ");
		System.out.println(Arrays.toString(array));
	}

}
