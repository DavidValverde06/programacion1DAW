package ejemplosMatrices;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		// Definine una matriz de 6 filas y 8 columnas de tipo entero
		int [][] matriz = new int[6][8];
		
		// Rellenar la matriz con valores aleatorios
		for (int fil=0;fil<matriz.length;fil++) {
			for (int col=0;col<matriz[fil].length;col++) {
				matriz[fil][col] = (int)(Math.random()*100);
			}
		}
		
		for (int fil=0;fil<matriz.length;fil++) {
			for (int col=0;col<matriz[fil].length;col++) {
				System.out.print(matriz[fil][col] + "\t");
			}
			System.out.println();
		}
	}

}
