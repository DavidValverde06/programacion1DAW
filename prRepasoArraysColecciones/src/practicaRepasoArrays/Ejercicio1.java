package practicaRepasoArrays;

/**
 * 1. Diseñar un programa que:
 * a) Cree un array bidimiensional de longitud 5 × 15 (filas × columnas) y nombre ‘marco’.
 * 
 * b) Cargue el array con dos únicos valores 0 y 1, donde el valor 1 ocupará las posiciones o 
 * 	  elementos que delimitan el array, es decir, las más externas, mientras que el resto de los 
 * 	  elementos contendrán el valor 0.
 * 
 * 		111111111111111
 * 		122222222222221
 * 		122222222222221
 * 		122222222222221
 * 		111111111111111
 * 
 * Visualiza el contenido de la matriz en pantalla 
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		int filas = 5;
		int columnas = 15;
		int[][] marco = new int[filas][columnas]; // Array bidimensional de longitud 5 x 15

		for (int fil=0;fil<marco.length;fil++) {
			for (int col=0;col<marco[fil].length;col++) {
				marco[fil][col] = 2; // Rellenar todo con 2
				
				marco[fil][0] = 1; // Lateral izquierdo
				
				marco[fil][columnas-1] = 1; // Lateral derecho
				
				marco[0][col] = 1; // Parte superior
				
				marco[filas-1][col] = 1; // Parte inferior
				
				System.out.print(marco[fil][col]); // Mostrar matriz
			}
			System.out.println(" ");
		}
	}
}
