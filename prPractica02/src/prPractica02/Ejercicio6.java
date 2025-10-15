package prPractica02;

import java.util.Scanner;

/**
 * 6. Diseñar un algoritmo que nos permita saber el mayor de dos números introducidos. Controlar el caso de
	  que sean iguales.
 */

public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2;
		
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();
		
		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();
		
		if (num1>num2) {
			System.out.println(num1 + " es mayor que " + num2);
		}
		else if (num1<num2) {
			System.out.println(num2 + " es mayor que " + num1);
		}
		else {
			System.out.println(num1 + " es igual que " + num2 + ". Los números son iguales");
		}
		
		sc.close();
	}

}
