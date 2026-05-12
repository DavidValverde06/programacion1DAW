package prPractica01;

import java.util.Scanner;

/**
 * 17.- Escribir un programa que reciba 4 números naturales a, b, c y d y que calcule:
		(ab + cd) * (ac + bd)

 */

public class Ejercicioo17 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double a,b,c,d,resultado;
		
		System.out.println("Introduce los valores de a, b, c y d: ");
		
		System.out.print("Valor de a: ");
		a=sc.nextDouble();
		System.out.print("Valor de b: ");
		b=sc.nextDouble();
		System.out.print("Valor de c: ");
		c=sc.nextDouble();
		System.out.print("Valor de d: ");
		d=sc.nextDouble();

		resultado = (Math.pow(a, b) + Math.pow(c, d)) * (Math.pow(a, c) + Math.pow(b, d));
				
		System.out.println("Resultado de (ab + cd) * (ac + bd): " +  resultado);
		
		sc.close();
		
	}

}
