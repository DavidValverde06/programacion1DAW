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

		int[] miArray = new int[12];

		miArray[0] = 39;
		miArray[1] = -2;
		miArray[4] = 0;
		miArray[6] = 14;
		miArray[8] = 5;
		miArray[9] = 120;

		System.out.println("Array de números enteros: ");
		for (int cont=0;cont<miArray.length;cont++) {
			System.out.print(miArray[cont] + " ");
		}
	}

}
