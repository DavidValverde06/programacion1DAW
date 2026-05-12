package prPractica02;

import java.util.Scanner;

/**
 * 31. Realizar un programa para calcular el valor máximo y el mínimo de una lista de n números que se
	   introducen por teclado, es decir, me indicarán cuántos valores se van a introducir, y se pedirán por
	   teclado los que nos hayan indicado.
 */

public class Ejercicioo31 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numLista,num,valorMaximo,valorMinimo;
		
		System.out.print("Indica cuantos números tendrá la lista: ");
		numLista=sc.nextInt();
		
		System.out.print("Introduce el número 1: "); // Lectura adelantada :)
		num=sc.nextInt();
		
		valorMaximo=num;
		valorMinimo=num;
		
		for (int cont=2;cont<=numLista;cont++) {
			System.out.print("Introduce el número " + cont + ": ");
			num=sc.nextInt();
			
			if (num>valorMaximo) {
				valorMaximo=num;
			}
			if (num<valorMinimo) {
				valorMinimo=num;
			}
			
		}
		
		System.out.println("\nValor máximo: " + valorMaximo);
		System.out.println("Valor mínimo: " + valorMinimo);
		
		sc.close();

	}

}
