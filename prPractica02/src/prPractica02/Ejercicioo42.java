package prPractica02;

import java.util.Scanner;

/**
 * 42. Hacer un algoritmo para calcular si un número es primo o no. En matemáticas, un número primo es un
	   número natural mayor que 1 que tiene únicamente dos divisores positivos distintos: él mismo y el 1.
 */

public class Ejercicioo42 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int num,contDivisores=0;

		System.out.print("Introduce un número natural: ");
		num=sc.nextInt();

		if (num<1) {
			System.out.println("El número debe ser un número natural");

		}
		else {
			for (int cont=2;cont<num;cont++) {
				if (num%cont==0) {
					contDivisores++;
				}
			}
			
			if (contDivisores>=1) {
				System.out.println(num + " no es primo.");
			}
			else {
				System.out.println(num + " si es primo.");
			}
		}

		System.out.println("\nFIN DE PROGRAMA");


		sc.close();
	}

}
