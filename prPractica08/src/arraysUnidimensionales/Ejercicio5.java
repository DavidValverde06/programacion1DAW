package arraysUnidimensionales;

/**
 * 5.- Realizar un programa que genere y almacene en un array 20 números de forma aleatoria. A
 * continuación deberá mostrar el array con los números generados, así como mostrar (junto con su
 * posición en el array), contar y sumar los elementos pares que ocupan las posiciones impares.
 */

public class Ejercicio5 {

	public static void main(String[] args) {

		int suma=0,contador=0;
		int[] miArray = new int[20];

		for (int cont=0;cont<miArray.length;cont++) {
			miArray[cont] = (int)(Math.random()*100)+1;
		}

		System.out.println("Array de números aleatorios: ");
		for (int cont=0;cont<miArray.length;cont++) {
			System.out.println("Posición:" + (cont+1) + " Número:" + miArray[cont]);
			suma+=miArray[cont];
			contador++;
		}

		System.out.println("\nArray posición impar y elemento par: ");
		for (int cont=0;cont<miArray.length;cont++) {
			if (cont%2==0 && miArray[cont]%2==0) { // Posición impar y elemento par
				System.out.println("Posición:" + (cont+1) + " Número:" + miArray[cont]);
				suma+=miArray[cont];
				contador++;
			}
		}

		System.out.println("\nContador de valores pares: " + contador);
		System.out.println("Suma de los valores pares: " + suma);
	}

}
