package modelo;

public class CuadradoMagico {

	/**
	 * Este método será el encargado de generar y
	devolver en una matriz el cuadrado mágico con la dimensión que nos indiquen.
	 */
	public int[][] generaCuadrado(int dim) {

		int[][] cuadradoMagico = new int[dim][dim];
		int fila = 0;
		int columna = dim/2;
		int contador = 1;

		cuadradoMagico[fila][columna] = contador;

		while (contador != Math.pow(dim, 2)) {
			contador++;

			if (fila == 0 && cuadradoMagico[fila][columna]%dim != 0) {
				fila = dim-1;
				cuadradoMagico[fila][columna+=1] = contador;
			}
			else if (columna == dim-1 && cuadradoMagico[fila][columna]%dim != 0) {
				fila -= 1;
				cuadradoMagico[fila][columna=0] = contador;
			}
			else if (cuadradoMagico[fila][columna]%dim == 0){
				cuadradoMagico[fila+=1][columna] = contador;
			}
			else {
				cuadradoMagico[fila-=1][columna+=1] = contador;
			}
		}

		return cuadradoMagico;

	}

	/**
	 * Este método mostrará en consola, el
	cuadrado mágico que nos llega en la matriz pasada como parámetro.
	 */
	public void muestraCuadrado(int [][] matriz) {
		for (int fil=0;fil<matriz.length;fil++) {
			for (int col=0;col<matriz[fil].length;col++) {
				System.out.print(matriz[fil][col] + "\t");
			}
			System.out.println();
		}
	}

}
