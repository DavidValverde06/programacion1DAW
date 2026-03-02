package practicaRepasoArrays;

/**
 * 3. Realizar un programa para generar e imprimir un cuadrado mágico de dimensión N, siendo N un número
 * entero positivo e impar. Un cuadrado mágico de dimensión N es una matriz cuadrada de orden N, que
 * contiene los números naturales de 1 a N2
 * , tal que coinciden la suma de los números de cualquiera de las
 * filas, columnas o diagonales principales. El cuadrado se construye siguiendo las siguientes reglas:
 * 		- El número 1 se coloca en la casilla central de la primera fila del cuadrado.
 * 		- Cada número siguiente se coloca en la casilla correspondiente a la fila anterior y columna posterior.
 * 		- Si el número sigue a un múltiplo de N, no se aplica la regla anterior, sino que se coloca en la casilla
 * 		  de la fila posterior e igual columna.
 * 		- Se considera que y fila anterior a la primera es la última, y la columna posterior a la última es la
 * 		  primera. 
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		int n = 3;
		int[][] cuadrado = new int[n][n];

		for (int fil=0;fil<cuadrado.length;fil++) {
			System.out.print("|");
			for (int col=0;col<cuadrado[fil].length;col++) {
				System.out.print(cuadrado[fil][col] + "|");
			}
			System.out.println(" ");
		}
	}

}
