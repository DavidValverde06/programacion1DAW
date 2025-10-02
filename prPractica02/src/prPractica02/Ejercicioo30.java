package prPractica02;

import java.util.Scanner;

/**
 * 30. Hacer un algoritmo para mostrar por pantalla los números múltiplos de 3 que hay entre dos números
	   determinados, de forma alternativa.
 */

public class Ejercicioo30 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1,num2,suma=0;
		
		System.out.print("Introduce el primer número: ");
		num1=sc.nextInt();
		System.out.print("Introduce el segundo número: ");
		num2=sc.nextInt();
		
		for (int cont=num1;cont<=num2;cont++) {
			suma+=cont;
			System.out.print(cont + " ");
		}
		
		System.out.println("\nSuma de los números: " + suma);
		
		sc.close();
		
	}

}
