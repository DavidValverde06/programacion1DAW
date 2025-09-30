package prPractica02;

import java.util.Scanner;

/**
 * 10. Realizar un algoritmo para deducir el mayor de tres valores introducidos por teclado.
 * 
 * CORREGIR
 */

public class Ejercicioo10 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,num3 // PONER PUNTO Y COMA
		
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();
		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();
		System.out.print("Introduce el tercer número: ");
		num3=sc.nextInt();		
		
		if (num1>num2 && num1>num3) {
			System.out.println(num1 + " es mayor que " + num2 + " y " + num3);
		}
		else if (num2>num1 && num2>num3) {
			System.out.println(num2 + " es mayor que " + num1 + " y " + num3);
		}
		else if (num3>num1 && num3>num2) {
			System.out.println(num3 + " es mayor que " + num2 + " y " + num1);
		}
		else if (num1==num2||num1==num3||num2==num3) {
			System.out.println("Hay dos números iguales");
		}
		else {
			System.out.println("Todos son iguales");
		}

		sc.close();
	}
}
