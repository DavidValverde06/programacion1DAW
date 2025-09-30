package prPractica02;

import java.util.Scanner;

/**
 * 7. Hacer un algoritmo para ver si un número introducido por teclado es par o impar.
 */

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.print("Introduce un número: ");
		num=sc.nextInt();
		
		if (num%2==0) {
			System.out.println(num + " es par.");
		}
		else {
			System.out.println(num + " es impar.");
		}
		
		sc.close();
	}

}
