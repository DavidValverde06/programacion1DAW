package arraysUnidimensionales;

/**
 * 5.- Realizar un programa que genere y almacene en un array 20 números de forma aleatoria. A
 * continuación deberá mostrar el array con los números generados, así como mostrar (junto con su
 * posición en el array), contar y sumar los elementos pares que ocupan las posiciones impares.
 */

public class Ejercicio5 {

	public static void main(String[] args) {
		int[] array = new int[20];

		for (int cont=0;cont<array.length;cont++) {
			array[cont] = (int)(Math.random()*100)+1;
		}

		System.out.println("Array de números aleatorios: ");
		for (int cont=0;cont<array.length;cont++) {
			if (cont%2!=0 && array[cont]%2==0) {
				System.out.println("Posición:" + cont + " Número:" + array[cont]);
			}
		}
	}

}
