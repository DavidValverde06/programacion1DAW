package ejemplosMatrices;

import java.util.Scanner;

/**
 * Clase que genera una matriz cuadrada del tamaño que nos indique el usuario sus 
 * valores serán aleatorios, excepto el de la diagonal principal que sera siempre 1.
 */

public class Ejemplo2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tamanioCuadrado;
		
		int[][] matriz;
		
		System.out.print("Introduce el tamaño de la matriz: ");
		tamanioCuadrado=sc.nextInt();
		
		matriz = new int[tamanioCuadrado][tamanioCuadrado];
		
		for (int fil=0;fil<matriz.length;fil++) {
			for (int col=0;col<matriz[fil].length;col++) {
				matriz[fil][col] = (int)(Math.random()*100);
				if (fil==col) {
					matriz[fil][col] = 1;
				}
			}
		}
		
		for (int fil=0;fil<matriz.length;fil++) {
			for (int col=0;col<matriz[fil].length;col++) {
				System.out.print(matriz[fil][col] + "\t");
			}
			System.out.println();
		}
		
		sc.close();
		
	}

}
