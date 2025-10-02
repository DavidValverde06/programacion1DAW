package prPractica02;

import java.util.Scanner;

/**
 * 31. Realizar un programa para calcular el valor máximo y el mínimo de una lista de n números que se
	   introducen por teclado, es decir, me indicarán cuántos valores se van a introducir, y se pedirán por
	   teclado los que nos hayan indicado.
 */

public class Ejercicioo31 {

	public static void main(String[] args) {

		asi no es
		
		Scanner sc = new Scanner(System.in);
		
		int numLista,valorMaximo=0,valorMinimo;
		
		System.out.print("Indica cuantos números tendrá la lista: ");
		numLista=sc.nextInt();
		
		valorMinimo=numLista;
		
		for (int cont=1;cont<=numLista;cont++) {
			System.out.print(cont + " | ");
			if (cont>valorMaximo) {
				valorMaximo=cont;
			}
			if (cont<valorMinimo) {
				valorMinimo=cont;
			}
		}
		
		System.out.println("\nValor máximo: " + valorMaximo);
		System.out.println("Valor mínimo: " + valorMinimo);

	}

}
