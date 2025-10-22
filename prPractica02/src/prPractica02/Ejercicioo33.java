package prPractica02;

import java.util.Scanner;

/**
 * 33. Hacer un algoritmo para calcular de forma automática las n primeras potencias de un número A. Se
	   introducen por teclado los números n (exponente) y A (base).
 */

public class Ejercicioo33 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int exponente,base;
		System.out.print("Introduce un número: ");
		base=sc.nextInt();
		System.out.print("Introduce el número de veces que quieres hacer la potencia: ");
		exponente=sc.nextInt();
		
		System.out.println();
		
		for (int cont=0;cont<=exponente;cont++) {
			System.out.println(base + " elevado a " + cont + ": " + (int)Math.pow(base, cont));
		}
		
		sc.close();
	}

}
