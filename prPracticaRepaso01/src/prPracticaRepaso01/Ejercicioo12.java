package prPracticaRepaso01;

import java.util.Scanner;

/**
 * 12. Diseñar un programa para calcular el valor de S para un número entero X dado utilizando la
       siguiente serie:
       
       S(X) = 1 + X + X2 + X3 + X4 + ... + XX
 */

public class Ejercicioo12 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int x;
		int s=2, resultado=1;
		
		System.out.print("Introduce el valor de X: ");
		x=sc.nextInt();
		
		System.out.print("S(" + x + ") = 1 + " + x);
		
		resultado+=x;
		
		for (int cont=s;cont<=x;cont++) {	
			
			s=(int)(Math.pow(x, cont));
			
			resultado+=s;
			
			System.out.print(" + " + s);
		}
		
		System.out.println("\nResultado = " + resultado);
		
		sc.close();
	}

}
