package arraysUnidimensionales;

/**
 * 2.- Define un array de 12 números enteros y asigna los valores según la tabla que se muestra a
 * continuación. Muestra el contenido de todos los elementos del array. ¿Qué sucede con los valores de
 * los elementos que no han sido inicializados?
 * 
 * Los valores no inicializados se pondrá su valor por defecto (valor por defecto de un número entero = 0).
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		int[] array = new int[12];

		array[0] = 39;
		array[1] = -2;
		array[4] = 0;
		array[6] = 14;
		array[8] = 5;
		array[9] = 120;

		System.out.println("Array de números enteros: ");
		for (int cont=0;cont<array.length;cont++) {
			System.out.print(array[cont] + " ");
		}
	}

}
