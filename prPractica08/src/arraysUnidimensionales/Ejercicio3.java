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

		char[] miArray = new char[10];

		miArray[0] = 'a';
		miArray[1] = 'x';
		miArray[4] = '@';
		miArray[6] = ' ';
		miArray[7] = '+';
		miArray[8] = 'Q';

		System.out.println("Array de caracteres: ");
		for (int cont=0;cont<miArray.length;cont++) {
			System.out.print(miArray[cont] + " ");
		}
	}

}
