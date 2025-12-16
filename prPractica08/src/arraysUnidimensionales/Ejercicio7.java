package arraysUnidimensionales;

/**
 * 7.- Crear e imprimir una lista unidimensional de 50 elementos con números aleatorios entre 1 y 100 de tal
 * forma que no se repita ninguno.
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		sin hacer
		
		int tamanioArray = 10;
		
		int[] array = new int[tamanioArray];
		int[] arrayAux = new int[tamanioArray];
		
		for (int cont=0;cont<arrayAux.length;cont++) {
			arrayAux[cont] = (int)(Math.random()*10)+1;
		}
		
		array=arrayAux;
		
		System.out.println("Array de números aleatorios que no se repiten: ");
		for (int cont=0;cont<array.length;cont++) {
			System.out.print(array[cont] + " ");
		}
		
	}

}
