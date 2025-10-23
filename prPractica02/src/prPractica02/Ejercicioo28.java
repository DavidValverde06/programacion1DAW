package prPractica02;

import java.util.Scanner;

/**
 * 28. Hacer un algoritmo que imprima, sume y cuente los números pares que hay entre dos números
	   determinados, debéis tener en cuenta si el primero de los números no es más pequeño que el segundo
 */

public class Ejercicioo28 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,totalNum=0,sumaNum=0;
		
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();
		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();
		
		System.out.println();
		
		if (num1>num2) {
			int aux = num1;
			num1=num2;
			num2=aux;
		}
		
		for (int cont=num1;cont<=num2;cont++) {
			if (cont%2==0) {
				System.out.print(cont + " ");
				totalNum++;
				sumaNum+=cont;
			}
		}
		
		System.out.println("\nSe han contado "+ totalNum +" números y suman " + sumaNum);
		
		sc.close();
	}

}
