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
		
		a=sc.nextDouble();
		b=sc.nextDouble();
		c=sc.nextDouble();
		d=sc.nextDouble();

		resultado = (Math.pow(a, b) + Math.pow(c, d)) * (Math.pow(a, c) + Math.pow(b, d));
				
		System.out.println("Resultado de (ab + cd) * (ac + bd): " +  resultado);
		
		sc.close();
		
	}

}
