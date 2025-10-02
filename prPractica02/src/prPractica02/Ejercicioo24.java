package prPractica02;

import java.util.Scanner;

/**
 * 24. Programa que calcule el producto de dos números enteros positivos mediante sumas sucesivas, no
	   podéis utilizar la operación de multiplicación.
 */

public class Ejercicioo24 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,resultado=0;
		
		System.out.print("Introduce el valor del primer número: ");
		num1=sc.nextInt();
		System.out.print("Introduce el valor del segundo número: ");
		num2=sc.nextInt();
		
		System.out.println("\nResultado usando el operador '*': " + (num1*num2));
		
		for (int cont=1;cont<=num2;cont++) {
			resultado += num1;
		}
		
		System.out.println("Resultado sin usar el operador '*': " + resultado);

		sc.close();
	}

}
