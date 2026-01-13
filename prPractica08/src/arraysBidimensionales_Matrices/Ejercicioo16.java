package arraysBidimensionales_Matrices;

/**
 * 16.- Utilizar una matriz de 4 x 10 elementos para representar una baraja con cuatro palos que contenga
 * cada uno las cartas del 1 al 7 y la Sota, el Caballo y el Rey. Utilizando dicha matriz implementar el juego
 * de las 7 y media con dos jugadores (usuario y ordenador como banca).
 */

public class Ejercicioo16 {

	sin hacer
	
	public static void main(String[] args) {

		int[][] matriz = new int[4][10];
		
		for (int filas=0;filas<matriz.length;filas++) {
			for (int columnas=0;columnas<matriz[filas].length;columnas++) {
				System.out.print(matriz[filas][columnas] + "\t");
			}
			System.out.println(" ");
		}
	}

}
