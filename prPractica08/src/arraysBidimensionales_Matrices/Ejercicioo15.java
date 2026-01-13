package arraysBidimensionales_Matrices;

import java.util.Scanner;

/**
 * 15.- Hacer una función para trasponer matrices de N x M elementos, otra para leer matrices desde teclado
 * y otra para visualizar matrices. Hacer un programa que utilizando dichas funciones nos visualice la
 * matriz traspuesta de una introducida desde teclado.
 */

public class Ejercicioo15 {

	sin hacer
	
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)){

			int[][] miMatriz;
			int n,m;

			System.out.print("Introduce las filas de la matriz: ");
			n=sc.nextInt();
			
			System.out.print("Introduce las columnas de la matriz: ");
			m=sc.nextInt();
			
			miMatriz = new int[n][m];
			
			visualizarMatrices(miMatriz);
		}
	}

	public static void transportarMatrices(int[][] miMatriz) {
		
		
	}

	public static void leerMatrices() {

	}

	public static void visualizarMatrices(int[][] miMatriz) {
		for (int filas=0;filas<miMatriz.length;filas++) {
			for (int columnas=0;columnas<miMatriz[filas].length;columnas++) {
				System.out.print(miMatriz[filas][columnas] + "\t");
			}
			System.out.println(" ");
		}
	}
}
