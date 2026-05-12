package ejemplosMatrices;

public class Ejemplo3 {

	public static void main(String[] args) {

		int[][] matriz = new int [10][11];
		
		for (int fil=0;fil<matriz.length;fil++) {
			for (int col=0;col<matriz[fil].length;col++) {
				matriz[fil][col] = (fil+1)*col;
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
