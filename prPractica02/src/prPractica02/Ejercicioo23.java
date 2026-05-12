package prPractica02;

import java.util.Scanner;

/**
 * 23. Hacer un algoritmo que nos sume los números naturales, comprendidos entre dos números introducidos
	   por teclado, debéis tener en cuenta si el primero de los números no es más pequeño que el segundo.

 */

public class Ejercicioo23 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,aux,suma=0;
		
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();
		
		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();
		
		if (num1>num2) {
			aux=num1;
			num1=num2;
			num2=aux;
		}
		
		for (int cont=num1; cont<=num2; cont++) {
			suma=suma+cont;
		}
		
		System.out.println("Suma: " + suma);
		
		sc.close();
	}

}
