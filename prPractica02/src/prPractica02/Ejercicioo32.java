package prPractica02;

import java.util.Scanner;

/**
 * 32. Hacer un algoritmo para calcular el valor máximo y el valor mínimo de una lista de números que se
	   introducen por teclado, se terminará la operación cuando se introduzca el número 0, en este caso no
	   sabremos cuántos valores se van a introducir.
 */

public class Ejercicioo32 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num,valorMaximo,valorMinimo;

		System.out.print("Introduce un número: ");
		num=sc.nextInt();

		valorMaximo=num;
		valorMinimo=num;

		do {
			if (num>valorMaximo) {
				valorMaximo=num;
			}
			if (num<valorMinimo) {
				valorMinimo=num;
			}
			System.out.print("Introduce un número: ");
			num=sc.nextInt();
		}
		while (num!=0);

		System.out.println("\nValor máximo: " + valorMaximo);
		System.out.println("Valor mínimo: " + valorMinimo);

		sc.close();
	}

}
