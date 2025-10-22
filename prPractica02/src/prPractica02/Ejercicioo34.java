package prPractica02;

import java.util.Scanner;

/**
 * 34. Hacer un algoritmo que calcule la suma de la serie de Fibonacci para un término n que se introduce por
	   teclado. La serie de Fibonacci tiene la siguiente expresión:
 */

public class Ejercicioo34 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int aux1=1,aux2=1,fibo=2,num;
		
		System.out.print("Introduce un número: ");
		num=sc.nextInt();
		
//		System.out.println(aux1 + " " + aux2 + " " + fibo);
		
		for (int cont=0;cont<num;cont++) {
			
//			System.out.println(aux1 + " " + aux2 + " " + fibo);
			
			aux1=aux2;
			aux2=fibo;
			fibo=aux1+aux2;
			
//			System.out.println(aux1 + " " + aux2 + " " + fibo);

		}
		
		System.out.println("Fib(" + num + ") = " + aux1);
		
		sc.close();
		
	}

}
