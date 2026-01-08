package arraysBidimensionales_Matrices;

/**
 * 14.- Diseñar un algoritmo que lee una matriz de tamaño 6 x 8 de números enteros (fila a fila), la almacena
 * en un array bidimensional llamado A. A continuación almacena los resultados de las sumas de los
 * elementos de cada fila en un vector llamado B, y las sumas de los elementos de cada columna en un
 * vector llamado C. Finalmente imprime los tres arrays.
 */

public class Ejercicioo14 {

	sin hacer
	
	public static void main(String[] args) {

		byte filasArray=8;
		byte columnasArray=6;

		int[][] miMatriz = new int [filasArray][columnasArray];

		int[][] A;

		int[] B = new int[filasArray];

		int[] C = new int [columnasArray];

		for (int filas=0;filas<miMatriz.length;filas++) {
			for (int columnas=0;columnas<miMatriz[filas].length;columnas++) {
				miMatriz[filas][columnas]=(int)(Math.random()*10);
			}
		}

		System.out.println("Array miMatriz: ");

		for (int filas=0;filas<miMatriz.length;filas++) {
			for (int columnas=0;columnas<miMatriz[filas].length;columnas++) {
				System.out.print(miMatriz[filas][columnas] + " ");
			}
			System.out.println(" ");
		}

		A = miMatriz;

		System.out.println("\nArray A: ");

		for (int filas=0;filas<A.length;filas++) {
			for (int columnas=0;columnas<A[filas].length;columnas++) {
				System.out.print(A[filas][columnas] + " ");
			}
			System.out.println(" ");
		}

		System.out.println("\nArray B: ");

		for (int cont=0;cont<B.length;cont++) {
			System.out.print(B[cont] + " ");
		}

		System.out.println("\n\nArray C: ");

		for (int cont=0;cont<C.length;cont++) {
			System.out.print(C[cont] + " ");
		}
	}

}
