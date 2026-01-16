package ejemplosArrays;

public class EjemploForEach {

	public static void main(String[] args) {

		int [] arrayNumeros = {1,2,3,4,5,6,7,8,9};
		char [] arrayCaracter = {'a','@','Y','b','$'};
		int [][] matrizNumeros = {{1,2,3},{4,5,6},{7,8,9}};

		for(int elemento:arrayNumeros) {
			System.out.print(elemento + " ");
		}

		System.out.println("\n");

		for(char elemento:arrayCaracter) {
			System.out.print(elemento + " ");
		}

		System.out.println("\n");

		for(int[] fila:matrizNumeros) { // Filas
			for(int elem: fila) {

				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}

}
