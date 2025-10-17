package prPracticaRepaso01;

/**
 * 1. Programa que calcule el cuadrado de los 100 primeros números pares.
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		int contNum=0;
		
		for (int cont=0;cont<200;cont++) {
			if (cont%2==0) {
				System.out.println((int)Math.pow(cont, 2));
				contNum++;
			}
		}
		
		System.out.println("\nContador números: " + contNum);
	}

}
