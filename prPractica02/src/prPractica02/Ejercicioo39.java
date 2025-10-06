package prPractica02;

/**
 * 39. Realizar un algoritmo para imprimir las tablas de multiplicar del uno al diez, es decir, tenéis que mostrar
	   la tabla del 1, la del 2, la del 3, … hasta la del 10.
 */

public class Ejercicioo39 {

	public static void main(String[] args) {

		final int TABLAS=10;
		
		for (int cont=1;cont<=TABLAS;cont++) {
			System.out.println("\nTABLA DEL " + cont);
			for (int cont2=0;cont2<=TABLAS;cont2++) {
				System.out.println(cont + " x " + cont2 + " = " + cont*cont2);
			}
		}
		
	}

}
