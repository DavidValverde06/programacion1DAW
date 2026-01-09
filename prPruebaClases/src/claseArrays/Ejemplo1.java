package claseArrays;

import java.util.Arrays;

/**
 * Clase de prueba de algunos de los métodos de la clase Arrays
 */
public class Ejemplo1 {

	public static void main(String[] args) {

		// Crear un vector y una matriz
		int [] vector = {12,8,65,92,19,22};
		int [][] matriz = {{1,2,3,4},{5,6,7,8}};

		// --------------------------------------------------------------
		// Prueba de los metodos toString y deepToString
		// --------------------------------------------------------------

		// Mostrar el vector con toString
		System.out.println(Arrays.toString(vector)); // toString -> Muestra arrays unidimensionales (Vectores)
		System.out.println();

		// Mostrar la matriz de diferentes formas
		// Forma 1 - Con toString
		System.out.println(Arrays.toString(matriz)); // Muestra la dirección de memoria de los dos arrays
		System.out.println();

		// Forma 2 - Con toString t recorremos "las filas" de la matriz (array de arrays)
		for (int fila=0;fila<matriz.length;fila++) {
			System.out.println("Fila " + (fila) + ": " + Arrays.toString(matriz[fila]));
		}
		System.out.println();

		// Forma 3 - Con el método deepToString
		System.out.println(Arrays.deepToString(matriz)); // deepToString -> Muestra arrays bidimensionales (Matrices)



		// --------------------------------------------------------------
		// Prueba del método fill
		// --------------------------------------------------------------
		int[] valores=new int[20];
		int[] valores2=new int[20];
		char[] valores3=new char[12];

		byte filasCuadro=5;
		byte columnasCuadro=20;
		char[][] cuadro = new char[filasCuadro][columnasCuadro];

		Arrays.fill(valores,-1); //Todos los elementos del array valdrán -1
		System.out.println(Arrays.toString(valores));
		System.out.println();

		Arrays.fill(valores2,5,8,-1); //Del elemento 5 al 7 valdrán -1
		System.out.println(Arrays.toString(valores2));
		System.out.println();

		Arrays.fill(valores3, 0,4,'A');
		System.out.println(Arrays.toString(valores3));
		Arrays.fill(valores3, 4,7,'B');
		System.out.println(Arrays.toString(valores3));
		Arrays.fill(valores3, 7,12,'X');
		System.out.println(Arrays.toString(valores3));
		System.out.println();
		
		
		for (int filas=0;filas<cuadro.length;filas++) {
			for (int columnas=0;columnas<cuadro[filas].length;columnas++) {
				Arrays.fill(cuadro[filas], '-');
				Arrays.fill(cuadro[filas],0,1,'*');
				Arrays.fill(cuadro[filas],columnasCuadro-1,columnasCuadro,'*');
			}
		}
		
		Arrays.fill(cuadro[0], '*');
		Arrays.fill(cuadro[cuadro.length-1],'*');
		
		for (int filas=0;filas<cuadro.length;filas++) {
			for (int columnas=0;columnas<cuadro[filas].length;columnas++) {
				System.out.print(cuadro[filas][columnas] + " ");
			}
			System.out.println(" ");
		}
		System.out.println();
		
		
		// --------------------------------------------------------------
		// Prueba del método equals
		// --------------------------------------------------------------
		int [] a = {2,3,4,5,6};
		int [] b = {2,3,4,5,6};
		int [] c = a;
//		byte [] d = {2,3,4,5,6};
		
		System.out.println(a==b); //false
		System.out.println(Arrays.equals(a,b)); //true
		System.out.println(a==c); //true
		System.out.println(Arrays.equals(a,c)); //true
//		System.out.println(Arrays.equals(a, d)); // Daría error al ser de distinto tipo
		
		int [][] x = {{1, 2}, {3, 4}};
		int [][] y = {{1, 2}, {3, 4}};
		System.out.println(Arrays.deepEquals(x, y)); // true
		System.out.println();
		
	}

}
