package arraysBidimensionales_Matrices;

/**
 * 13.- Define un array de números enteros de 3 filas por 6 columnas y asigna los valores según la siguiente
 * tabla. Muestra el contenido de todos los elementos del array dispuestos en forma de tabla como se
 * muestra en la figura.
 */

public class Ejercicioo13 {

	public static void main(String[] args) {

		int miMatriz[][] = new int [3][6];
		
		miMatriz[0][0] = 0;
		miMatriz[0][1] = 30;
		miMatriz[0][2] = 2;
		miMatriz[0][5] = 5;
		miMatriz[1][1] = 75;
		miMatriz[1][4] = 0;
		miMatriz[2][2] = -2;
		miMatriz[2][3] = 9;
		miMatriz[2][5] = 11;
		
		for (int filas=0;filas<miMatriz.length;filas++) {
			for (int columnas=0;columnas<miMatriz[filas].length;columnas++) {
				System.out.print(miMatriz[filas][columnas] + "\t");
			}
			System.out.println(" ");
		}
	}

}
