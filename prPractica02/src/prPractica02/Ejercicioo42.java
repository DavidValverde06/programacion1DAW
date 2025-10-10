package prPractica02;

import java.util.Scanner;

/**
 * 42. Hacer un algoritmo para calcular si un número es primo o no. En matemáticas, un número primo es un
	   número natural mayor que 1 que tiene únicamente dos divisores positivos distintos: él mismo y el 1.
 */

public class Ejercicioo42 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num,contDivisores=0,cont=0;

		System.out.println("Introduce un número natural: ");
		num=sc.nextInt();

		if (num<1) {
			System.out.println("El número debe ser un número natural");

		}
		else {
			while (contDivisores<3) {
				if (num%cont==0) {
					
				}
				cont++;
			}
			
		}

		System.out.println("FIN DE PROGRAMA");


		sc.close();
	}

}
