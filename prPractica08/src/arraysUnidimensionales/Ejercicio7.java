package arraysUnidimensionales;

/**
 * 7.- Crear e imprimir una lista unidimensional de 50 elementos con números aleatorios entre 1 y 100 de tal
 * forma que no se repita ninguno.
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		int[] arraySinRepeticiones = new int[50];

		for (int cont=0;cont<arraySinRepeticiones.length;cont++) {
			arraySinRepeticiones[cont] = (int)(Math.random()*50)+1;
		}

		System.out.println("Array de números aleatorios que no se repiten: ");
		for (int cont=0;cont<arraySinRepeticiones.length;cont++) {
			System.out.print(arraySinRepeticiones[cont] + " ");
		}
		
	}

}
