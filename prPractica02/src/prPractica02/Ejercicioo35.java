package prPractica02;

import java.util.Scanner;

/**
 * 35. Hacer un algoritmo que calcule el valor de un número combinatorio a partir de dos valores, a y b, que
	   se introducen por teclado, aplicando la siguiente fórmula:
	   
	   (a b) = a! / b!*(a-b)
	   
	    Se debe tener en cuenta que para poder calcular el combinatorio de dos números se debe cumplir que
		a ≥ b, a ≥ 0 y b ≥ 0.

 */

public class Ejercicioo35 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double numA,numB,numAB,factorialA=1,factorialB=1,factorialAB=1,resultado;
		
		System.out.print("Introduce el valor de A: ");
		numA=sc.nextDouble();
		
		System.out.print("Introduce el valor de B: ");
		numB=sc.nextDouble();
		
		if (numA>=numB && numA>=0 && numB>=0) {
						
			for (double cont=numA;cont>0;cont--) {
				factorialA=factorialA*cont;
			}
			
			for (double cont=numB;cont>0;cont--) {
				factorialB=factorialB*cont;
			}
			
			numAB=numA-numB;
			
			for (double cont=numAB;cont>0;cont--) {
				factorialAB=factorialAB*cont;
			}
			
//			(a b) = a! / b!*(a-b)!
			
			resultado = factorialA / (factorialB * factorialAB);
			
			System.out.println("\nEl factorial de " + numA + " es: " + factorialA);
			System.out.println("El factorial de " + numB + " es: " + factorialB);

			System.out.println("\nEl combinatorio de " + numA + " sobre " + numB + " es: " + resultado);
			
		}
		else {
			System.out.println("Error, no se puede calcular el combinatorio de " + numA + " y " + numB);
		}
		
		sc.close();
	}

}
