package prPractica01;

import java.util.Scanner;

/**
 * 14.- Realizar un programa que realiza y muestra las operaciones aritméticas básicas de dos números
		pasados a nuestro programa. Las operaciones aritméticas básicas son, suma, resta, multiplicación y
		división.
 */

public class Ejercicioo14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		float num1,num2;
		
		System.out.print("Introduce el primer número: ");
		
		num1=sc.nextFloat();
		
		System.out.print("Introduce el segundo número: ");
		
		num2=sc.nextFloat();
		
		System.out.println("\nOperaciones aritméticas básicas:" +
						   "\nSuma: " + (num1+num2) +
						   "\nResta: " + (num1-num2) +
						   "\nMultiplicación: " + (num1*num2) +
						   "\nDivisión: " + (num1/num2));
		
		sc.close();
	}

}
