package ejemplosArrays;

public class EjemploArray1 {

	public static void main(String[] args) {

		int[] array = {5,17,24,39,42};

		for (int cont=0;cont<array.length;cont++) {
			if (10<array[cont] && array[cont]<20) {
				System.out.println("La posición es: " + cont);
				System.out.println("Este número es mayor que 10 y menor que 20: " + array[cont]);
			}
		}
	}

}
