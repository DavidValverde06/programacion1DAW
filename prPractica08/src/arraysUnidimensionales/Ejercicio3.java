package arraysUnidimensionales;

/**
 * 3.- Define un array de 10 caracteres y asigna valores a los elementos según la tabla que se muestra a
 * continuación. Muestra el contenido de todos los elementos del array. ¿Qué sucede con los valores de
 * los elementos que no han sido inicializados?
 * 
 * Los valores no inicializados se pondrá su valor por defecto (valor por defecto de un caracter = ' ').
 */

public class Ejercicio3 {

	public static void main(String[] args) {

		char[] array = new char[10];

		array[0] = 'a';
		array[1] = 'x';
		array[4] = '@';
		array[6] = ' ';
		array[7] = '+';
		array[8] = 'Q';

		System.out.println("Array de caracteres: ");
		for (int cont=0;cont<array.length;cont++) {
			System.out.print(array[cont] + " ");
		}
	}

}
