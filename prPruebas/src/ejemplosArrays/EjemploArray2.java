package ejemplosArrays;

public class EjemploArray2 {

	public static void main(String[] args) {

		int[] boletosVendidos = {10,30,50,30,20,10,70,20,50};

		for (int cont=0;cont<boletosVendidos.length;cont++) {
			for (int cont2=0;cont2<boletosVendidos.length;cont2++) {
				System.out.print(boletosVendidos[cont] + " ");
			}
		}
	}

}
