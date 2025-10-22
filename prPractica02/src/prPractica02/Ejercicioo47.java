package prPractica02;

/**
 * 47. Simular 100 tiradas de un dado y contar las veces que aparece el nº 6. 
 */

public class Ejercicioo47 {

	public static void main(String[] args) {

		int num,resultado=0;

		for (int cont=0;cont<=100;cont++) {
			num = (int)(Math.random()*6)+1;
			System.out.print(num + " ");
			if (num==6) {
				resultado++;
			}			
		}
		
		System.out.println("\nHay un total de " + resultado + " seises.");

	}

}
